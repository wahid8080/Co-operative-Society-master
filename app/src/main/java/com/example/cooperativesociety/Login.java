package com.example.cooperativesociety;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cooperativesociety.MainActivitys.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private EditText mEmail,mPass;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.userNameId_log);
        mPass = findViewById(R.id.passId_log);
        mAuth = FirebaseAuth.getInstance();



    }

    public void confirmInput(View view) {

        progressDialog = new ProgressDialog(this);

        String email = mEmail.getText().toString().trim();
        String pass = mPass.getText().toString();


        if (validate() == true){
            progressDialog.setMessage("Try to Login");
            progressDialog.setTitle("Processing...");
            progressDialog.show();
            login(email,pass);
        } else {
            validate();
        }
    }


    public boolean validate()
    {
        boolean valid = true;
        String email = mEmail.getText().toString().trim();
        String pass = mPass.getText().toString();

        if (email.isEmpty() | !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("enter a valid email address");
            return false;
        } else {
            mEmail.setError(null);
        }

        if (pass.isEmpty() ){
            mPass.setError("enter your correct password");
            return false;
        } else {
            mPass.setError(null);
        }
        return valid;
    }

    private void login(final String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            progressDialog.dismiss();
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            progressDialog.cancel();
                            Toast.makeText(Login.this, "check your email or password.",Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        if (currentUser!=null)
        {
            startActivity(new Intent(Login.this,MainActivity.class));
        }
    }


    public void gotoSingupActivity(View view) {
        startActivity(new Intent(Login.this,Registration.class));
    }
}
