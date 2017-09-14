package com.example.manas.talneo_event;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (hasConnection(MainActivity.this)){
            Button a = (Button) findViewById(R.id.button3);
            a.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v)
                {
                    //sync();
                    Intent k = new Intent(v.getContext(), CREW.class);
                    startActivity(k);

                }
            });

            Button b = (Button) findViewById(R.id.button4);
            b.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v)
                {
                    //sync();
                    Intent k = new Intent(v.getContext(), GALLERY.class);
                    startActivity(k);

                }
            });
        }
        else{
            showNetDisabledAlertToUser(MainActivity.this);
        }
    }

    public boolean hasConnection(Context context){
        ConnectivityManager cm=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiNetwork=cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetwork != null && wifiNetwork.isConnected()){
            return true;
        }
        NetworkInfo mobileNetwork=cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mobileNetwork != null && mobileNetwork.isConnected()){
            return true;
        }
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()){
            return true;
        }
        return false;
    }

    public void showNetDisabledAlertToUser(final Context context){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context, AlertDialog.BUTTON_NEUTRAL);
        alertDialogBuilder.setMessage("Would you like to enable it?")
                .setTitle("No Internet Connection")
                .setPositiveButton(" Enable Internet ", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent dialogIntent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                        dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(dialogIntent);
                    }
                });

        alertDialogBuilder.setNegativeButton(" Cancel ", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                dialog.cancel();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();

















        Button a = (Button) findViewById(R.id.button3);
        a.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                //sync();
                Intent k = new Intent(v.getContext(), CREW.class);
                startActivity(k);

            }
        });

        Button b = (Button) findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                //sync();
                Intent k = new Intent(v.getContext(), GALLERY.class);
                startActivity(k);

            }
        });



    }

}
