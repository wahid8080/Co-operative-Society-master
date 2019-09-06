package com.example.cooperativesociety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cooperativesociety.Model.HelpModelClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UploadHelp extends AppCompatActivity {

    DatabaseReference databaseReference,databaseReference2;

    EditText helpCost,helpDesc;

    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_help);

        helpCost = findViewById(R.id.submitHelpCost);
        helpDesc = findViewById(R.id.submitHelpDesc);

        key = getIntent().getStringExtra("bank");
    }

    public void submitHelp(View view) {

        String cost = helpCost.getText().toString().trim();
        String desc = helpDesc.getText().toString();

        int intValueForCost = Integer.valueOf(cost);

        databaseReference = FirebaseDatabase.getInstance().getReference("Help").child(key).push();
        databaseReference2 = FirebaseDatabase.getInstance().getReference("TotalCost").child(key).push();
        HelpModelClass helpModelClass = new HelpModelClass(intValueForCost,desc);
        HelpModelClass helpModelClass1 = new HelpModelClass(intValueForCost);
        databaseReference.setValue(helpModelClass);
        databaseReference2.setValue(helpModelClass1);

        Toast.makeText(UploadHelp.this, "Help Submit Successful", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(UploadHelp.this,DashBord.class));
        finish();

    }
}
