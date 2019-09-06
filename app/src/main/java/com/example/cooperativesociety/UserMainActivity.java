package com.example.cooperativesociety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class UserMainActivity extends AppCompatActivity {

    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        key = getIntent().getStringExtra("bank");
    }


    public void YourProfile(View view) {
        startActivity(new Intent(UserMainActivity.this, UserProfile.class));
    }

    public void Donate(View view) {

        startActivity(new Intent(this, MyDonate.class));

    }

    public void Logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, Login.class));

    }


    public void TotalEvent(View view) {
        Intent intent = new Intent(UserMainActivity.this, EventsActivity.class);
        intent.putExtra("bank",key);
        startActivity(intent);
    }


    public void annual_Activityes(View view) {
        Intent intent = new Intent(UserMainActivity.this,AnnualActivityes.class);
        intent.putExtra("bank",key);
        startActivity(intent);
    }

    public void donateFund(View view) {
        Intent intent = new Intent(UserMainActivity.this,FundActivityes.class);
        intent.putExtra("bank",key);
        startActivity(intent);
    }

    public void mission(View view) {
        Intent intent = new Intent(UserMainActivity.this,Mission.class);
        intent.putExtra("bank",key);
        startActivity(intent);
    }

    public void vision(View view) {
        Intent intent = new Intent(UserMainActivity.this,Vision.class);
        intent.putExtra("bank",key);
        startActivity(intent);
    }

    public void socialWork(View view) {
        Intent intent = new Intent(UserMainActivity.this,HelpActivityes.class);
        intent.putExtra("bank",key);
        startActivity(intent);
    }

}
