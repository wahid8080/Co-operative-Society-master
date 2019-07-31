package com.example.cooperativesociety;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.cooperativesociety.Model.PaymentModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BkashPayment extends AppCompatActivity {

    EditText referance,amount;

    DatabaseReference databaseReference,databaseReference2;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bkash_payment);

        referance = findViewById(R.id.referanceKey);
        amount = findViewById(R.id.amount);

    }

    public void paymentSubmit(View view) {

        String refarence  = referance.getText().toString().trim();
        String amount1 = amount.getText().toString().trim();
        int finalValue = Integer.valueOf(amount1);

        try {
            user = FirebaseAuth.getInstance().getCurrentUser();
            databaseReference2 = FirebaseDatabase.getInstance().getReference("User").child(user.getUid()).child("Balance").push();
            databaseReference = FirebaseDatabase.getInstance().getReference("Fund").child("Balance").push();

            PaymentModel paymentModel = new PaymentModel(finalValue,refarence);
            databaseReference2.setValue(paymentModel);
            databaseReference.setValue(paymentModel);
        }
        catch (Exception e)
        {
            Snackbar.make(view,"Only User Can Donate", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }
}
