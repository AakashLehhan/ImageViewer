package com.aakash.assignmenttwo6thsemester;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ProgressBar pBar;
    int progress;

    ImageView appIcon, mainImage, selectImage_1, selectImage_2, selectImage_3;
    TextView name, rNo, tag;

    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pBar = findViewById(R.id.pBar);
        appIcon = findViewById(R.id.appIcon);
        mainImage = findViewById(R.id.mainImage);
        selectImage_1 = findViewById(R.id.selectImage_1);
        selectImage_2 = findViewById(R.id.selectImage_2);
        selectImage_3 = findViewById(R.id.selectImage_3);

        name = findViewById(R.id.name);
        tag = findViewById(R.id.tag);
        rNo = findViewById(R.id.rNo);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        startProgressListener();
    }

    @Override
    protected void onStop(){
        super.onStop();
        handler.removeCallbacks(runnable);
    }

    public void startProgressListener() {
        progress = pBar.getProgress();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progress<80){
                    progress += 1;

                    handler.post((new Runnable() {
                        @Override
                        public void run() {
                            pBar.setProgress(progress);
                            if (progress == 40){
                                mainImage.setImageResource(R.drawable.icon_2);
                                selectImage_2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selected_image_bg));
                                selectImage_1.setBackgroundResource(0);
                                selectImage_1.setPadding(0,0,0,0);
                            }
                            if (progress == 70){
                                mainImage.setImageResource(R.drawable.icon_3);
                                selectImage_3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selected_image_bg));
                                selectImage_2.setBackgroundResource(0);
                                selectImage_2.setPadding(0,0,0,0);
                            }
                        }
                    }));
                    try {
                        Thread.sleep(50);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                handler.postDelayed(runnable, 50);
            }
        }).start();
    }
}