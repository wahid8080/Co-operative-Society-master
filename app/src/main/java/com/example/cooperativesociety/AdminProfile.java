package com.example.cooperativesociety;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AdminProfile extends AppCompatActivity {

    ImageView mImage;
    TextView mName,mEmail,mPhone,mId,mAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);

        mImage = findViewById(R.id.adminProfileImg);
        mName = findViewById(R.id.adminName);
        mEmail = findViewById(R.id.adminEmail);
        mPhone = findViewById(R.id.adminPhone);
        mId = findViewById(R.id.adminID);
        mAbout = findViewById(R.id.adminAbout);


        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        String email = getIntent().getStringExtra("email");
        String id = getIntent().getStringExtra("id");
        String about = getIntent().getStringExtra("about");

        mName.setText(name);
        mPhone.setText(phone);
        mEmail.setText(email);
        mId.setText(id);
        mAbout.setText(about);

        Bundle bundle =getIntent().getExtras();
        if (bundle!=null)
        {
            int img = bundle.getInt("img");

            mImage.setImageResource(img);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }
}
