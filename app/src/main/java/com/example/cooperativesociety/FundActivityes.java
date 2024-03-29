package com.example.cooperativesociety;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cooperativesociety.Model.EventModelClass;
import com.example.cooperativesociety.Model.HelpModelClass;
import com.example.cooperativesociety.Model.UserInformation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FundActivityes extends AppCompatActivity {

    TextView totalDonate, totalEventcost, totalHelpCost;
    DatabaseReference databaseReference,databaseReference3, databaseReference4;

    public String key;
    public static int totalHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_activityes);

        key = getIntent().getStringExtra("bank");

        totalDonate = findViewById(R.id.totalDonate);
        totalEventcost = findViewById(R.id.totalEventCost);
        totalHelpCost = findViewById(R.id.totalHelpCost);

        databaseReference = FirebaseDatabase.getInstance().getReference("TotalCost").child(key);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int total = 0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    HelpModelClass userInformation = dataSnapshot1.getValue(HelpModelClass.class);
                    total = total + userInformation.getTotalHelpCost();
                    totalDonate.setText("Total Donate : " + String.valueOf(total));



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference3 = FirebaseDatabase.getInstance().getReference("Event").child(key);
        databaseReference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int totatEventCost1 = 0;

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    EventModelClass eventModelClass = dataSnapshot1.getValue(EventModelClass.class);
                    totatEventCost1 = totatEventCost1 + eventModelClass.getEventCost();
                    totalEventcost.setText("Total event Cost : " + String.valueOf(totatEventCost1));

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference4 = FirebaseDatabase.getInstance().getReference("Help").child(key);
        databaseReference4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int totalHelpCost1 = 0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    HelpModelClass helpModelClass = dataSnapshot1.getValue(HelpModelClass.class);
                    totalHelpCost1 = totalHelpCost1 + helpModelClass.getHelpCost();
                    totalHelpCost.setText("Total Help Cost : " + String.valueOf(totalHelpCost1));
                    totalHelp = totalHelpCost1;

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
