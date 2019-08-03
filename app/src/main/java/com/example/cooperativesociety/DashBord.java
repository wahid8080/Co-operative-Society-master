package com.example.cooperativesociety;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.cooperativesociety.Adapter.ExampleDailog;
import com.example.cooperativesociety.Model.UserInformation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class DashBord extends AppCompatActivity {

    private DatabaseReference databaseReference,databaseReference2;
    private FirebaseUser user;
    private TextView userName;
    private ImageView userProfile,userCover,dashbordImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_bord);

        userName = findViewById(R.id.userName);
        userProfile = findViewById(R.id.profilePicIdDashbord);
        userCover = findViewById(R.id.coverPicIdDashBord);
        dashbordImg = findViewById(R.id.dashbordImage);
        TextView profile = findViewById(R.id.Profile);

        try {
            user = FirebaseAuth.getInstance().getCurrentUser();
            databaseReference2 = FirebaseDatabase.getInstance().getReference("User").child(user.getUid());

            databaseReference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    UserInformation userInformation = dataSnapshot.getValue(UserInformation.class);
                    userName.setText("Name : "+userInformation.getUsername());
                    Bitmap bm = StringToBitMap(userInformation.getImageToString());
                    userProfile.setImageBitmap(bm);
                    userCover.setImageBitmap(bm);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch ( Exception e)
        {
            userCover.setVisibility(View.GONE);
            userProfile.setVisibility(View.GONE);
            userName.setVisibility(View.GONE);
            profile.setVisibility(View.GONE);
            dashbordImg.setVisibility(View.VISIBLE);
        }

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



    public void krishiBank(View view) {

        try {
            user = FirebaseAuth.getInstance().getCurrentUser();
            databaseReference = FirebaseDatabase.getInstance().getReference("User").child(user.getUid());

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    UserInformation userInformation = dataSnapshot.getValue(UserInformation.class);
                    if (userInformation.getUser().equals("user"))
                    {
                        Intent intent = new Intent(DashBord.this, LoginForBank.class);
                        intent.putExtra("bank","Krishi");
                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e)
        {
            Intent intent = new Intent(DashBord.this, MainActivity.class);
            intent.putExtra("bank","Krishi");
            startActivity(intent);
        }
    }



    public void brackbank(View view) {

        try {
            user = FirebaseAuth.getInstance().getCurrentUser();
            databaseReference = FirebaseDatabase.getInstance().getReference("User").child(user.getUid());

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    UserInformation userInformation = dataSnapshot.getValue(UserInformation.class);
                    if (userInformation.getUser().equals("user"))
                    {
                        Intent intent = new Intent(DashBord.this, LoginForBank.class);
                        intent.putExtra("bank","brak");
                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e)
        {
            Intent intent = new Intent(DashBord.this, MainActivity.class);
            intent.putExtra("bank","brak");
            startActivity(intent);
        }
    }

    public void asaBank(View view) {

        try {
            user = FirebaseAuth.getInstance().getCurrentUser();
            databaseReference = FirebaseDatabase.getInstance().getReference("User").child(user.getUid());

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    UserInformation userInformation = dataSnapshot.getValue(UserInformation.class);
                    if (userInformation.getUser().equals("user"))
                    {
                        Intent intent = new Intent(DashBord.this, LoginForBank.class);
                        intent.putExtra("bank","asa");
                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e)
        {
            Intent intent = new Intent(DashBord.this, MainActivity.class);
            intent.putExtra("bank","asa");
            startActivity(intent);
        }
    }

    public void grameenBank(View view) {
        try {
            user = FirebaseAuth.getInstance().getCurrentUser();
            databaseReference = FirebaseDatabase.getInstance().getReference("User").child(user.getUid());

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    UserInformation userInformation = dataSnapshot.getValue(UserInformation.class);
                    if (userInformation.getUser().equals("user"))
                    {
                        Intent intent = new Intent(DashBord.this, LoginForBank.class);
                        intent.putExtra("bank","grameen");
                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Exception e)
        {
            Intent intent = new Intent(DashBord.this, MainActivity.class);
            intent.putExtra("bank","grameen");
            startActivity(intent);
        }
    }

    public void logoutDashbord(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, Login.class));
    }

    public void profileDashbord(View view) {
        startActivity(new Intent(DashBord.this,UserProfile.class));
    }

}
