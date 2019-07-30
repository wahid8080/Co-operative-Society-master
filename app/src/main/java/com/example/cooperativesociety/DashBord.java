package com.example.cooperativesociety;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.example.cooperativesociety.MainActivitys.MainActivity;
import com.example.cooperativesociety.Model.UserInformation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class DashBord extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_bord);


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
                        Intent intent = new Intent(DashBord.this, UserMainActivity.class);
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
                        Intent intent = new Intent(DashBord.this, UserMainActivity.class);
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
                        Intent intent = new Intent(DashBord.this, UserMainActivity.class);
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
                        Intent intent = new Intent(DashBord.this, UserMainActivity.class);
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
            startActivity(intent);
        }
    }

    public void logoutDashbord(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, Login.class));
    }
}
