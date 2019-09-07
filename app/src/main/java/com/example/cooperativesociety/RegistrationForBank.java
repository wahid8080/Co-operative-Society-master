package com.example.cooperativesociety;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cooperativesociety.Model.AccountForUserBank;
import com.example.cooperativesociety.Model.UserInformation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegistrationForBank extends AppCompatActivity {

    EditText userName,pass,confPass;
    TextView bankName;

    private FirebaseUser user;
    DatabaseReference databaseReference,databaseReference2,databaseReference3;

    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_for_bank);

        key = getIntent().getStringExtra("bank");

        userName = findViewById(R.id.input_Email_Address_Id_inSingup);
        pass = findViewById(R.id.input_password_Id_inSingup);
        confPass = findViewById(R.id.input_confirm_password_Id_inSingup);
        bankName = findViewById(R.id.textForBank_id);
        bankName.setText(key+" Bank");
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    public void doRegistration(View view) {
        String name = userName.getText().toString().trim();
        String password = pass.getText().toString();
        String cnPass = confPass.getText().toString();

        if (password.equals(cnPass))
        {
            registration(name,password,cnPass);
        }
        else
        {
            Snackbar.make(view,"Password Does't match", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }

    }

    public void registration(String name,String password,String cnPass)
    {
        databaseReference = FirebaseDatabase.getInstance().getReference("UserOfBank").child(key).push();
        databaseReference2 = FirebaseDatabase.getInstance().getReference("BankUser").child(key).push();
        AccountForUserBank  accountForUserBank = new AccountForUserBank(name,password,cnPass);
        databaseReference.setValue(accountForUserBank);

        databaseReference3 = FirebaseDatabase.getInstance().getReference("User").child(user.getUid());
        databaseReference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserInformation userInformation = dataSnapshot.getValue(UserInformation.class);

                String userEmail = userInformation.getEmail();
                String userPhone = userInformation.getPhone();
                String userImage = userInformation.getImageToString();

                UserInformation  userInformation1 = new UserInformation(userEmail,userPhone,userImage);
                databaseReference2.setValue(userInformation1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Intent intent = new Intent(RegistrationForBank.this, UserMainActivity.class);
        intent.putExtra("bank",key);
        startActivity(intent);

        finish();
    }
}
