package com.bignerdranch.android.splash;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.loopj.android.http.HttpGet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

public class Gallary extends AppCompatActivity {

    private static final String TAG = Gallary.class.getSimpleName();
    private GridView mGridView;
    private ProgressBar mProgressBar;
    private GridViewAdapter mGridAdapter;
    private ArrayList<GridItem> mGridData;
    private String FEED_URL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);

        mGridView = (GridView) findViewById(R.id.gridView);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        //Initialize with empty data
        mGridData = new ArrayList<>();
        mGridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, mGridData);
        mGridView.setAdapter(mGridAdapter);

        //Start download
        new AsyncHttpTask().execute(FEED_URL);
        mProgressBar.setVisibility(View.VISIBLE);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                //Get item at position
                GridItem item = (GridItem) parent.getItemAtPosition(position);

                //Pass the image title and url to DetailsActivity
                Intent intent = new Intent(Gallary.this, DetailsActivity.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("image", item.getImage());

                //Start details activity
                startActivity(intent);
            }
        });
    }

    //Downloading data asynchronously
    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {

        @Override
        protected Integer doInBackground(String... params) {
            Integer result = 0;
          /*  try {
                // Create Apache HttpClient
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse httpResponse = httpclient.execute(new HttpGet(params[0]));
                int statusCode = httpResponse.getStatusLine().getStatusCode();

                // 200 represents HTTP OK
                if (statusCode == 200) {
                    String response = streamToString(httpResponse.getEntity().getContent());
                    //parseResult(response);
                    Log.d("data",response);
                    result = 1; // Successful
                } else {
                    result = 0; //"Failed
                }
            } catch (Exception e) {
                Log.d(TAG, e.getLocalizedMessage());
            }*/
            String text = "";
            BufferedReader reader=null;
            try
            {

                // Defined URL  where to send data
                URL url = new URL("http://aminet.in/api/shutterbug/Loadimg.php");

                // Send POST data request

                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.flush();

                // Get the server response
                String a = streamToString(conn.getInputStream());
                //reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                //StringBuilder sb = new StringBuilder();
                //String line = null;

                // Read Server Response
                //while((line = reader.readLine()) != null)
                //{
                    // Append server response in string
                  //  sb.append(line + "\n");
               // }
               // String a = streamToString(sb);
                Log.d("data",a);
                parseResult(a);

               // text = sb.toString();
                //Log.d("Data",text);
            }
            catch(Exception ex)
            {
                Log.d("Error",ex.getMessage());
                ex.printStackTrace();
            }
            finally
            {
                try
                {

                    reader.close();
                }

                catch(Exception ex) {}
            }
            result=1;
            return result;
        }

        @Override
        protected void onPostExecute(Integer result) {
            // Download complete. Let us update UI
            if (result == 1) {
                mGridAdapter.setGridData(mGridData);
            } else {
                Toast.makeText(Gallary.this, "Failed to fetch data!", Toast.LENGTH_SHORT).show();
            }
            mProgressBar.setVisibility(View.GONE);
        }
    }

    String streamToString(InputStream stream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
        String line;
        String result = "";
        while ((line = bufferedReader.readLine()) != null) {
            result += line;
        }

        // Close stream
        if (null != stream) {
            stream.close();
        }
        return result;
    }

    /**
     * Parsing the feed results and get the list
     * @param result
     */
    private void parseResult(String result) {
        /*try {
            JSONObject response = new JSONObject(result);
            JSONArray posts = response.optJSONArray(0);
            GridItem item;
            for (int i = 0; i < posts.length(); i++) {
                JSONObject post = posts.optJSONObject(i);
                String title = post.optString("title");
                item = new GridItem();
                item.setTitle(title);
                JSONArray attachments = post.getJSONArray("attachments");
                if (null != attachments && attachments.length() > 0) {
                    JSONObject attachment = attachments.getJSONObject(0);
                    if (attachment != null)
                        item.setImage(attachment.getString("url"));
                }
                mGridData.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        JSONArray posts = null;
        try {
            posts = new JSONArray(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        /*try {
            JSONObject a = posts.getJSONObject(1);
            Log.d("data",a.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        } */
        GridItem item;
        for (int i = 0; i < posts.length(); i++) {
            JSONObject post = null;
            try {
                post = posts.getJSONObject(i);
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            String title = null;
            try {
                title = post.getString("Title");
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            item = new GridItem();
            item.setTitle(title);
            try {
                item.setImage("http://www.aminet.in/api/Shutterbug/pic/"+post.getString("URL"));
                Log.d("data",post.getString("URL"));
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            mGridData.add(item);
        }

    }
}
