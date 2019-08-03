package com.example.cooperativesociety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cooperativesociety.Model.PaymentModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EventDonate extends AppCompatActivity {

    private TextView eventDonate;
    private String key,eventName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_donate);

        eventDonate = findViewById(R.id.eventDonate);
        key = getIntent().getStringExtra("bank");
        eventName = getIntent().getStringExtra("name");

    }

    public void donateNow(View view) {

        String donate = eventDonate.getText().toString();

        int intvalue = Integer.valueOf(donate);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BalanceOfEvent").child("Event").child(key).child(eventName).push();
        PaymentModel paymentModel = new PaymentModel(intvalue);
        databaseReference.setValue(paymentModel);

        finish();
    }
}
