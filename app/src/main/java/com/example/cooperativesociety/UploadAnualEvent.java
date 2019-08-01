package com.example.cooperativesociety;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cooperativesociety.Model.AnnualModelClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UploadAnualEvent extends AppCompatActivity {

    EditText type,location,history;
    String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_anual_event);

        type = findViewById(R.id.uploadTypeOfProgram);
        location = findViewById(R.id.uploadLocationOfProgram);
        history = findViewById(R.id.uploadHistoryOfProgram);

        key = getIntent().getStringExtra("bank");


    }

    public void uploadanualEvent(View view) {

        String typeOfProgram = type.getText().toString();
        String programLpcation = location.getText().toString();
        String programhistory = history.getText().toString();


            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("AnnualProgram").child(key).push();
            AnnualModelClass  annualModelClass = new AnnualModelClass(typeOfProgram,programLpcation,programhistory);
            databaseReference.setValue(annualModelClass);
            startActivity(new Intent(UploadAnualEvent.this,DashBord.class));
            finish();



    }
}
