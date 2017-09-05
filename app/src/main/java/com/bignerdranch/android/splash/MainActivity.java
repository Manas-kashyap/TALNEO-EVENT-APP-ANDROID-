package com.bignerdranch.android.splash;
import com.bignerdranch.android.splash.ItemListActivity;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button a = (Button) findViewById(R.id.button);

        Button f = (Button)findViewById(R.id.button3);
        Button b =(Button)findViewById(R.id.button2);

        //a.setOnClickListener();





        f.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                //sync();
                Intent k = new Intent(v.getContext(), Gallary.class);
                startActivity(k);

            }
        });

        a.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                //sync();
                Intent k = new Intent(v.getContext(), INFO.class);
                startActivity(k);

            }
        });
    }
}
