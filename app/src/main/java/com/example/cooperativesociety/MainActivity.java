package com.example.cooperativesociety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        key = getIntent().getStringExtra("bank");

    }


    public void TotalMember(View view) {
        Intent intent = new Intent(MainActivity.this, MemberActivity.class);
        intent.putExtra("bank",key);
        startActivity(intent);
    }

    public void TotalEvent(View view) {
        Intent intent = new Intent(MainActivity.this, EventsActivity.class);
        intent.putExtra("bank",key);
        startActivity(intent);
    }


    public void Fant(View view) {
        Intent intent = new Intent(MainActivity.this, FundActivityes.class);
        intent.putExtra("bank",key);
        startActivity(intent);
    }

    public void Admin(View view) {
        Intent intent = new Intent(MainActivity.this, AdminActivity.class);
        intent.putExtra("bank",key);
        startActivity(intent);
    }

    public void socialWork(View view) {
        Intent intent = new Intent(MainActivity.this, HelpActivityes.class);
        intent.putExtra("bank",key);
        startActivity(intent);
    }

    public void annualProgram(View view) {

        Intent intent = new Intent(MainActivity.this, AnnualActivityes.class);
        intent.putExtra("bank",key);
        startActivity(intent);
    }
}
