package com.example.barclaysinterviewproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.barclaysinterviewproject.R;

/**
 * Created by Suresh reddy on 11/12/2016.
 */

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        },3000);
    }
}
