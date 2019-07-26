package com.example.cooperativesociety.MainActivitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.cooperativesociety.Login;
import com.example.cooperativesociety.R;
import com.example.cooperativesociety.UserProfile;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void YourProfile(View view) {
        startActivity(new Intent(MainActivity.this, UserProfile.class));
    }

    public void Donate(View view) {

        startActivity(new Intent(this,MyDonate.class));

    }

    public void Logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, Login.class));
    }

    public void TotalMember(View view) {
        startActivity(new Intent(MainActivity.this, MemberActivity.class));
    }

    public void TotalEvent(View view) {
        startActivity(new Intent(MainActivity.this, EventsActivity.class));
    }

    public void Help(View view) {
        startActivity(new Intent(MainActivity.this,HelpActivityes.class));
    }

    public void DonateActivitys(View view) {
        startActivity(new Intent(MainActivity.this,DonateActivity.class));
    }

    public void Fant(View view) {
        startActivity(new Intent(MainActivity.this,FundActivityes.class));
    }

    public void Admin(View view) {
        startActivity(new Intent(MainActivity.this, AdminActivity.class));
    }
}
