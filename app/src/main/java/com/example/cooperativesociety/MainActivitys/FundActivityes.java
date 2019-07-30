package com.example.cooperativesociety.MainActivitys;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cooperativesociety.Model.UserInformation;
import com.example.cooperativesociety.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FundActivityes extends AppCompatActivity {

    TextView totalDonate,totalDebit,totalCash;

    DatabaseReference databaseReference;

    int total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_activityes);

        totalCash = findViewById(R.id.totalCash);
        totalDebit = findViewById(R.id.totalDebit);
        totalDonate = findViewById(R.id.totalDonate);

        databaseReference = FirebaseDatabase.getInstance().getReference("Fund").child("Balance");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    UserInformation userInformation = dataSnapshot1.getValue(UserInformation.class);
                    total = total + userInformation.getBalance();
                    totalDonate.setText("Total Donate : "+String.valueOf(total));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
