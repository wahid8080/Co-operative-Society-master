package com.example.cooperativesociety;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cooperativesociety.MainActivitys.MainActivity;
import com.example.cooperativesociety.Model.UserInformation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {

    private TextView mName, mNID, mPhone, mEmail, mDateOfBirth;
    private ImageView mUser_profile_photo;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mName = findViewById(R.id.user_profile_name);
        mNID = findViewById(R.id.textViewNIDid);
        mPhone = findViewById(R.id.textViewPhoneId);
        mEmail = findViewById(R.id.textViewEmailId);
        mUser_profile_photo = findViewById(R.id.profileImageViewId);
        mDateOfBirth = findViewById(R.id.textViewDateOfBirthId);
        user = FirebaseAuth.getInstance().getCurrentUser();
        getData();
    }


    void getData() {

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("User").child(user.getUid());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                UserInformation userInformation = dataSnapshot.getValue(UserInformation.class);
                mName.setText("User Name : " + userInformation.getUsername());
                mEmail.setText("Email : " + userInformation.getEmail());
                mPhone.setText("Phone Number : " + userInformation.getPhone());
                mNID.setText("N ID : " + userInformation.getNid());
                mDateOfBirth.setText("Date Of Birth : " + userInformation.getDateOfBirth());
                Bitmap bm = StringToBitMap(userInformation.getImageToString());
                mUser_profile_photo.setImageBitmap(bm);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }


    public void goToHome(View view) {
        startActivity(new Intent(UserProfile.this, MainActivity.class));
    }

    public void yourAmount(View view) {
        startActivity(new Intent(UserProfile.this,YourBalance.class));
    }

    public void doYouWantToDonate(View view) {
        startActivity(new Intent(UserProfile.this,DoYouWantToDonate.class));
    }
}
