package com.example.cooperativesociety.MainActivitys;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cooperativesociety.Adapter.MyAdepterOfEvent;
import com.example.cooperativesociety.Model.EventModelClass;
import com.example.cooperativesociety.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    ArrayList<EventModelClass> eventModelClassArrayList;
    MyAdepterOfEvent myAdepterOfEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

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

    }
}
