package com.example.manas.talneo_event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import android.content.Intent;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button a = (Button) findViewById(R.id.button3);
        a.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                //sync();
                Intent k = new Intent(v.getContext(), CREW.class);
                startActivity(k);

            }
        });
    }
}
