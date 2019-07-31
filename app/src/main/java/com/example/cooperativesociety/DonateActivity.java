package com.example.cooperativesociety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DonateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
    }


    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }

    public void bkashPayment(View view) {
        startActivity(new Intent(this, BkashPayment.class));
    }

    public void cashPayment(View view) {
        startActivity(new Intent(this, MyDonate.class));
    }

    public void creditCardPayment(View view) {
        startActivity(new Intent(DonateActivity.this, Payment.class));
    }
}
