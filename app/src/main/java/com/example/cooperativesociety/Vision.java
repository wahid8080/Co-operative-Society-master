package com.example.cooperativesociety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Vision extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vision);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
