package com.example.manas.talneo_event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import static com.example.manas.talneo_event.R.id.webView;

public class webpage extends AppCompatActivity {
    private WebView myWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webpage);
        myWebView = (WebView)findViewById(webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setSupportMultipleWindows(true);



        myWebView.setWebViewClient(new WebViewClient(){

            public void onPageFinished(WebView view,String url){
                ProgressBar progressbar = (ProgressBar) findViewById(R.id.progressBar);
                progressbar.setVisibility(View.GONE);
            }
        });




        myWebView.loadUrl("http://www.talneo.com");

    }


    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}

/*public class webpage extends AppCompatActivity {
    private ProgressBar progressBar;

    public webpage (ProgressBar progressBar) {
        this.progressBar=progressBar;
        progressBar.setVisibility(View.VISIBLE);
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // TODO Auto-generated method stub
        view.loadUrl("http://www.talneo.com");
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        // TODO Auto-generated method stub
        super.onPageFinished(view, "http://www.talneo.com");
        progressBar.setVisibility(View.GONE);
    }
}*/