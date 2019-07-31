package com.example.cooperativesociety;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cooperativesociety.Model.AccountForUserBank;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationForBank extends AppCompatActivity {

    EditText userName,pass,confPass;
    TextView bankName;

    DatabaseReference databaseReference;

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
        AccountForUserBank  accountForUserBank = new AccountForUserBank(name,password,cnPass);
        databaseReference.setValue(accountForUserBank);

        Intent intent = new Intent(RegistrationForBank.this, UserMainActivity.class);
        intent.putExtra("bank",key);
        startActivity(intent);

        finish();
    }
}
