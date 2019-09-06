package com.example.cooperativesociety;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeScreen extends AppCompatActivity {

    RelativeLayout flashscreen,buttonScreen;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        flashscreen = findViewById(R.id.relativeForFlashScreen);
        buttonScreen = findViewById(R.id.relativeForButtonScreen);
        mAuth = FirebaseAuth.getInstance();

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

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        if (currentUser!=null)
        {
            startActivity(new Intent(WelcomeScreen.this,DashBord.class));
            finish();
        }
    }

    public void userLogin(View view) {

        startActivity(new Intent(WelcomeScreen.this,Login.class));
        finish();
    }

    public void adminLogin(View view) {

        startActivity(new Intent(WelcomeScreen.this,Login.class));
        finish();
    }
}
