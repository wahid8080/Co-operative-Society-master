package com.example.cooperativesociety;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cooperativesociety.Adapter.MyAdepter;
import com.example.cooperativesociety.Model.MembersModelClass;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MemberActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private RecyclerView memberListView;
    private FirebaseUser user;

    private ArrayList<MembersModelClass> membersList;
    private MyAdepter myAdepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        user = FirebaseAuth.getInstance().getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("User");

        membersList = new ArrayList<>();
        myAdepter = new MyAdepter(MemberActivity.this,membersList);
        memberListView = findViewById(R.id.memberListView);
        memberListView.setLayoutManager(new LinearLayoutManager(this));
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot resultSnapshot : dataSnapshot.getChildren())
                {
                    MembersModelClass members = resultSnapshot.getValue(MembersModelClass.class);
                    membersList.add(members);
                    memberListView.setAdapter(myAdepter);
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
