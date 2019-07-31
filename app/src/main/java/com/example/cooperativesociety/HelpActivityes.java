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

import com.example.cooperativesociety.Adapter.MyAdepterOfHelp;
import com.example.cooperativesociety.Model.HelpModelClass;
import com.example.cooperativesociety.Model.UserInformation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HelpActivityes extends AppCompatActivity {

    ArrayList<HelpModelClass> helpModelClassArrayList;
    RecyclerView recyclerView;
    MyAdepterOfHelp myAdepterOfHelp;
    DatabaseReference databaseReference,databaseReference2;
    FirebaseUser user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_activityes);
        final FloatingActionButton fab = findViewById(R.id.fab);
        helpModelClassArrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerViewForHelp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Help");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    HelpModelClass helpModelClass = dataSnapshot1.getValue(HelpModelClass.class);
                    helpModelClassArrayList.add(helpModelClass);

                }

                myAdepterOfHelp  = new MyAdepterOfHelp(helpModelClassArrayList,HelpActivityes.this);
                recyclerView.setAdapter(myAdepterOfHelp);
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
            public void onClick(View v) {
                startActivity(new Intent(HelpActivityes.this, UploadHelp.class));
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }
}
