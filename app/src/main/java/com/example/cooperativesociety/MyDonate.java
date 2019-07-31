package com.example.cooperativesociety;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cooperativesociety.Model.UserInformation;
import com.example.cooperativesociety.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyDonate extends AppCompatActivity {

    Toolbar mActionBarToolbar;
    TextView totalDonate;
    EditText donateNow;

    DatabaseReference databaseReference,databaseReference1,databaseReference3;
    FirebaseUser user;

    int total = 0;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_donate);

        totalDonate = findViewById(R.id.totalDonate);
        donateNow = findViewById(R.id.donateNow1);

        mActionBarToolbar = findViewById(R.id.toolbar_actionbar);
        mActionBarToolbar.setTitle("Your Total Donate");
        mActionBarToolbar.setBackgroundColor(getColor(R.color.colorPrimaryDark));
        mActionBarToolbar.getElevation();
        setSupportActionBar(mActionBarToolbar);
        user = FirebaseAuth.getInstance().getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference("User").child(user.getUid()).child("Balance");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    UserInformation userInformation = dataSnapshot1.getValue(UserInformation.class);
                     total = total + userInformation.getBalance();
                    totalDonate.setText("Your Donate : "+String.valueOf(total));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void confirm(View view) {
        databaseReference3 = FirebaseDatabase.getInstance().getReference("Fund").child("Balance").push();
        databaseReference1 = FirebaseDatabase.getInstance().getReference("User").child(user.getUid()).child("Balance").push();
        String balance = donateNow.getText().toString().trim();
        int finalValue = Integer.valueOf(balance);
        UserInformation userInformation3 = new UserInformation(finalValue);
        UserInformation userInformation1 = new UserInformation(finalValue);
        databaseReference3.setValue(userInformation3);
        databaseReference1.setValue(userInformation1);
    }
}
