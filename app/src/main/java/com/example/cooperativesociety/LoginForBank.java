package com.example.cooperativesociety;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cooperativesociety.Model.AccountForUserBank;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginForBank extends AppCompatActivity {

    EditText username,password;
    TextView bankName;

    String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_for_bank);
        key = getIntent().getStringExtra("bank");

        bankName = findViewById(R.id.textForBank);
        username = findViewById(R.id.userNameIdForBank);
        password = findViewById(R.id.passIdForBank);
        bankName.setText(key+" Bank");
    }

    public void confirmInput(View view) {

        final String user = username.getText().toString().trim();
        final String pass = password.getText().toString();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("UserOfBank").child(key);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    AccountForUserBank account = dataSnapshot1.getValue(AccountForUserBank.class);

                    if (user.equals(account.getUserName()) && pass.equals(account.getPass()))
                    {
                        Intent intent = new Intent(LoginForBank.this, UserMainActivity.class);
                        intent.putExtra("bank",key);
                        startActivity(intent);
                        Toast.makeText(LoginForBank.this,"Log in",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void gotoSingupActivity(View view) {
        Intent intent = new Intent(LoginForBank.this, RegistrationForBank.class);
        intent.putExtra("bank",key);
        startActivity(intent);
        finish();
    }


}
