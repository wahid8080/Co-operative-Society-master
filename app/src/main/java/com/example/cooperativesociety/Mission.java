package com.example.cooperativesociety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Mission extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
