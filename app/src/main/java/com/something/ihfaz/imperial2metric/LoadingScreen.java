package com.something.ihfaz.imperial2metric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LoadingScreen extends AppCompatActivity {

    ImageView logoText;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        logoText = (ImageView) findViewById(R.id.logoText);
        logo = (ImageView) findViewById(R.id.logo) ;

        Animation loadTransition = AnimationUtils.loadAnimation(this, R.anim.transition);
        logoText.startAnimation(loadTransition);
        logo.startAnimation(loadTransition);
        final Intent intent = new Intent(this, MainActivity.class);

        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
