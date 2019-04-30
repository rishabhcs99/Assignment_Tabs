package com.example.nishit.assignment_rishabhshetty;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
    private Button button;
    private TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        button =(Button) findViewById(R.id.button);
        tv1=(TextView)findViewById(R.id.tvv1);
        tv2=(TextView)findViewById(R.id.tvv2);



        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv1.startAnimation(myanim);
        tv2.startAnimation(myanim);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Tabbed Activity",Toast.LENGTH_LONG).show();
                Intent i=new Intent(getApplicationContext(),Description.class);
                startActivity(i);
            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                button.performClick();

            }
        }, 5000);
    }
}
