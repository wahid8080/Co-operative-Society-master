package com.example.cooperativesociety;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    DatabaseReference databaseReference;

    EditText mEmail, mPass, mRe_Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();
        mEmail = findViewById(R.id.input_Email_Address_Id_inSingup);
        mPass = findViewById(R.id.input_password_Id_inSingup);
        mRe_Pass = findViewById(R.id.input_confirm_password_Id_inSingup);

        databaseReference = FirebaseDatabase.getInstance().getReference("User");

    }

    public void doRegistration(View view) {
        String email = mEmail.getText().toString().trim();
        String pass = mPass.getText().toString();


        if (validate() == true) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Try to Sing up");
            progressDialog.setTitle("Processing...");
            progressDialog.show();
            singup(email, pass,view);
        } else {
            validate();
        }
    }

    public boolean validate() {
        String email = mEmail.getText().toString().trim();
        String pass = mPass.getText().toString();
        String rePass = mRe_Pass.getText().toString();
        boolean valid = true;

        if (email.isEmpty() | !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("enter a valid email address");
            return false;
        } else {
            mEmail.setError(null);
        }

        if (pass.length() <= 5) {
            mPass.setError("password too short");
            return false;
        } else if (pass.isEmpty()) {
            mPass.setError("Password is empty");
            return false;
        } else if (!pass.equals(rePass)) {
            mRe_Pass.setError("Password don't match");
            return false;
        } else {
            mRe_Pass.setError(null);
        }
        return valid;
    }

    void singup(final String singupEmail, String singupPass, final View view) {
        mAuth.createUserWithEmailAndPassword(singupEmail, singupPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            progressDialog.dismiss();
                            Intent intent = new Intent(Registration.this, UploadYourInformation.class);
                            startActivity(intent);
                            Toast.makeText(Registration.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            progressDialog.cancel();
                            Snackbar.make(view,"Registration Failed", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }
                });
    }

}
