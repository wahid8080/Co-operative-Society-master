package com.example.cooperativesociety;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.cooperativesociety.Adapter.MyAdepterOfAnnualProg;
import com.example.cooperativesociety.Model.AnnualModelClass;
import com.example.cooperativesociety.Model.UserInformation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AnnualActivityes extends AppCompatActivity {

    String key;
    DatabaseReference databaseReference,databaseReference2;
    RecyclerView recyclerView;
    FirebaseUser user;
    MyAdepterOfAnnualProg myAdepterOfAnnualProg;

    ArrayList<AnnualModelClass> annualModelClassArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annual_activityes);
        final FloatingActionButton fab = findViewById(R.id.fab);

        key = getIntent().getStringExtra("bank");

        recyclerView = findViewById(R.id.annualEventRecyclerView);
        annualModelClassArrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        databaseReference = FirebaseDatabase.getInstance().getReference("AnnualProgram").child(key);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    AnnualModelClass modelClass = dataSnapshot1.getValue(AnnualModelClass.class);
                    annualModelClassArrayList.add(modelClass);
                }

                myAdepterOfAnnualProg = new MyAdepterOfAnnualProg(AnnualActivityes.this,annualModelClassArrayList);
                recyclerView.setAdapter(myAdepterOfAnnualProg);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        try {
            user = FirebaseAuth.getInstance().getCurrentUser();
            databaseReference2 = FirebaseDatabase.getInstance().getReference("User").child(user.getUid());
            databaseReference2.addValueEventListener(new ValueEventListener() {
                @SuppressLint("RestrictedApi")
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                    UserInformation userInformation = dataSnapshot.getValue(UserInformation.class);
                    if (userInformation.getUser().equals("user"))
                    {
                        fab.setVisibility(View.GONE);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        } catch (Exception e)
        {

        }



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AnnualActivityes.this,UploadAnualEvent.class);
                intent.putExtra("bank",key);
                startActivity(intent);
            }
        });
    }
}
