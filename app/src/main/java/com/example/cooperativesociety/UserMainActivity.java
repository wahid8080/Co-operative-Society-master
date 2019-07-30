package com.example.cooperativesociety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.cooperativesociety.MainActivitys.AdminActivity;
import com.example.cooperativesociety.MainActivitys.DonateActivity;
import com.example.cooperativesociety.MainActivitys.EventsActivity;
import com.example.cooperativesociety.MainActivitys.FundActivityes;
import com.example.cooperativesociety.MainActivitys.HelpActivityes;
import com.example.cooperativesociety.MainActivitys.MainActivity;
import com.example.cooperativesociety.MainActivitys.MemberActivity;
import com.example.cooperativesociety.MainActivitys.MyDonate;
import com.google.firebase.auth.FirebaseAuth;

public class UserMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
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

    public void TotalMember(View view) {
        startActivity(new Intent(UserMainActivity.this, MemberActivity.class));
    }

    public void TotalEvent(View view) {
        startActivity(new Intent(UserMainActivity.this, EventsActivity.class));
    }

    public void Help(View view) {
        startActivity(new Intent(UserMainActivity.this, HelpActivityes.class));
    }

    public void DonateActivitys(View view) {
        startActivity(new Intent(UserMainActivity.this, DonateActivity.class));
    }

    public void Fant(View view) {
        startActivity(new Intent(UserMainActivity.this, FundActivityes.class));
    }

}
