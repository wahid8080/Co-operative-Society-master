package com.example.cooperativesociety.MainActivitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.cooperativesociety.Payment;
import com.example.cooperativesociety.R;

public class DonateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
    }

    public void goToPayment(View view) {
        startActivity(new Intent(DonateActivity.this, Payment.class));
    }
}
