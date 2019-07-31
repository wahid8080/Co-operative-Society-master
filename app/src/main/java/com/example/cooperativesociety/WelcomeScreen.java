package com.example.cooperativesociety;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class WelcomeScreen extends AppCompatActivity {

    RelativeLayout flashscreen,buttonScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        flashscreen = findViewById(R.id.relativeForFlashScreen);
        buttonScreen = findViewById(R.id.relativeForButtonScreen);

        Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                buttonScreen.setVisibility(View.VISIBLE);
                flashscreen.setVisibility(View.GONE);
            }
        };


        handler.postDelayed(runnable, 2000);

    }

    public void userLogin(View view) {

        startActivity(new Intent(WelcomeScreen.this,Login.class));
    }

    public void adminLogin(View view) {

        startActivity(new Intent(WelcomeScreen.this,Login.class));
    }
}
