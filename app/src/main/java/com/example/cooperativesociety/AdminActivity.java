package com.example.cooperativesociety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {

    ImageView mAlamin, mSujon, mSamim;
    TextView mAlaminName, mAlaminPhone, mSujonName, mSujonPhone, mSamimName, mSaminPhone;
    TextView mSaminEmail,mSamimId,mSamimAbout,mSujonEmail,
            mSujonId,mSujonAbout,mAlaminEmail,mAlaminId,mAlaminAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panal);

        mAlaminName = findViewById(R.id.alaminName);
        mAlaminPhone = findViewById(R.id.alaminPhone);
        mSujonName = findViewById(R.id.sujonName);
        mSujonPhone = findViewById(R.id.sujonPhone);
        mSamimName = findViewById(R.id.samimName);
        mSaminPhone = findViewById(R.id.saminPhone);

        mAlamin = findViewById(R.id.uploadProfilePicture2);
        mSamim = findViewById(R.id.uploadProfilePicture);
        mSujon = findViewById(R.id.uploadProfilePicture3);


        mAlaminEmail = findViewById(R.id.alaminEmail);
        mAlaminId = findViewById(R.id.alaminId);
        mAlaminAbout = findViewById(R.id.alaminAbout);
        mSujonEmail = findViewById(R.id.sujonEmail);
        mSujonId = findViewById(R.id.sujonId);
        mSujonAbout = findViewById(R.id.sujonAbout);
        mSaminEmail = findViewById(R.id.samimEmail);
        mSamimId = findViewById(R.id.saminId);
        mSamimAbout = findViewById(R.id.samimAbout);

    }

    public void samimProfile(View view) {

        Intent intent = new Intent(AdminActivity.this, AdminProfile.class);
        intent.putExtra("name",mSamimName.getText());
        intent.putExtra("phone",mSaminPhone.getText());
        intent.putExtra("email",mSaminEmail.getText());
        intent.putExtra("id",mSamimId.getText());
        intent.putExtra("about",mSamimAbout.getText());
        intent.putExtra("img",R.drawable.samim);
        startActivity(intent);


    }

    public void sujonProfile(View view) {

        Intent intent = new Intent(AdminActivity.this, AdminProfile.class);
        intent.putExtra("name",mSujonName.getText());
        intent.putExtra("phone",mSujonPhone.getText());
        intent.putExtra("email",mSujonEmail.getText());
        intent.putExtra("id",mSujonId.getText());
        intent.putExtra("about",mSujonAbout.getText());
        intent.putExtra("img",R.drawable.sujon);
        startActivity(intent);

    }

    public void alaminProfile(View view) {

        Intent intent = new Intent(AdminActivity.this, AdminProfile.class);
        intent.putExtra("name",mAlaminName.getText());
        intent.putExtra("phone",mAlaminPhone.getText());
        intent.putExtra("email",mAlaminEmail.getText());
        intent.putExtra("id",mAlaminId.getText());
        intent.putExtra("about",mAlaminAbout.getText());
        intent.putExtra("img",R.drawable.alamin);
        startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }
}
