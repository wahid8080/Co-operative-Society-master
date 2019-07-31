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

import com.example.cooperativesociety.Adapter.MyAdepterOfEvent;
import com.example.cooperativesociety.Model.EventModelClass;
import com.example.cooperativesociety.Model.UserInformation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    DatabaseReference databaseReference,databaseReference2;
    RecyclerView recyclerView;
    ArrayList<EventModelClass> eventModelClassArrayList;
    MyAdepterOfEvent myAdepterOfEvent;

    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);


        final FloatingActionButton fab = findViewById(R.id.fab);
        eventModelClassArrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.RecyclerViewForEventId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Event");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){

                    EventModelClass m = dataSnapshot1.getValue(EventModelClass.class);
                    eventModelClassArrayList.add(m);
                }

                myAdepterOfEvent = new MyAdepterOfEvent(EventsActivity.this,eventModelClassArrayList);
                recyclerView.setAdapter(myAdepterOfEvent);

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
                startActivity(new Intent(EventsActivity.this, EventUpload.class));
            }
        });

    }


    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }
}
