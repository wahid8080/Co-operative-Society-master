package com.example.cooperativesociety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void TotalMember(View view) {
        startActivity(new Intent(MainActivity.this, MemberActivity.class));
    }

    public void TotalEvent(View view) {
        startActivity(new Intent(MainActivity.this, EventsActivity.class));
    }

    public void Help(View view) {
        startActivity(new Intent(MainActivity.this, HelpActivityes.class));
    }

    public void DonateActivitys(View view) {
        startActivity(new Intent(MainActivity.this, DonateActivity.class));
    }

    public void Fant(View view) {
        startActivity(new Intent(MainActivity.this, FundActivityes.class));
    }

    public void Admin(View view) {
        startActivity(new Intent(MainActivity.this, AdminActivity.class));
    }
}