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

    private TextView mName, mNID, mPhone, mEmail, mAdderss;
    private ImageView mUser_profile_photo,mUser_CoverPhoto;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mName = findViewById(R.id.nameForUser);
        mNID = findViewById(R.id.textViewNIDid);
        mPhone = findViewById(R.id.textViewPhoneId);
        mEmail = findViewById(R.id.textViewEmailId);
        mUser_profile_photo = findViewById(R.id.OwnerProfileImageId);
        mUser_CoverPhoto = findViewById(R.id.coverPicId);
        mAdderss = findViewById(R.id.address);
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
                mAdderss.setText("Address :  : " + userInformation.getDateOfBirth());
                Bitmap bm = StringToBitMap(userInformation.getImageToString());
                mUser_profile_photo.setImageBitmap(bm);
                Bitmap bm2 = StringToBitMap(userInformation.getImageToString());
                mUser_CoverPhoto.setImageBitmap(bm2);
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

    public void eventUpload(View view) {

        startActivity(new Intent(this,EventUpload.class));
    }

    public void logout(View view) {

        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, Login.class));
    }
}
