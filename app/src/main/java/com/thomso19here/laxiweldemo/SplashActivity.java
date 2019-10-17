package com.thomso19here.laxiweldemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    Thread splashThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        StartAnimations();

    }
    private void StartAnimations()
    {
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.translate);
        anim.reset();
        ImageView iv = findViewById(R.id.splash);
        iv.clearAnimation();
        iv.startAnimation(anim);
        splashThread = new Thread()
        {
            @Override
            public  void run()
            {
                try {
                    int waited = 0;
                    while (waited<1000)
                    {
                        sleep(100);
                        waited+=100;
                    }
                    Intent intent = new Intent(SplashActivity.this,DashboardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    SplashActivity.this.finish();
                }
                catch (InterruptedException e)
                {

                }
                finally {
                    SplashActivity.this.finish();
                }
            }
        };
        splashThread.start();
    }
}