package com.example.manas.talneo_event;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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

        Button b = (Button) findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                //sync();
                Intent k = new Intent(v.getContext(), CREW.class);
                startActivity(k);

            }
        });



    }

}
