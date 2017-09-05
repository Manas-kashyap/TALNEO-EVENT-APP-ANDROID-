package com.bignerdranch.android.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class mid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid);
        Button c = (Button) findViewById(R.id.button);
        Button a = (Button) findViewById(R.id.button5);

        //a.setOnClickListener();
        assert a != null;
        a.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //sync();
                Intent k = new Intent(v.getContext(), MAP.class);
                startActivity(k);

            }
        });
        c.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //sync();
                Intent k = new Intent(v.getContext(), Upload.class);
                startActivity(k);

            }
        });

    }
}

