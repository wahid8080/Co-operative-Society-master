package com.example.cooperativesociety;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.cooperativesociety.Model.UserInformation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class UploadYourInformation extends AppCompatActivity {

    private int PIC_IMAGE_REQUEST = 1;
    private Bitmap bitmap = null;

    private DatabaseReference databaseReference, databaseReference1;
    private FirebaseUser user;
    private ProgressDialog progressDialog;

    private ImageView mImage;
    private EditText mUserNmae, mPhone, mNID, mDateOfBirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_your_information);

        mImage = findViewById(R.id.uploadProfilePicture);
        mUserNmae = findViewById(R.id.input_userName_id_SingUp);
        mPhone = findViewById(R.id.input_phone_Id_SingUp);
        mNID = findViewById(R.id.input_NID_Id_SingUp);
        mDateOfBirth = findViewById(R.id.input_dateOfBirth_Id_SingUp);
        user = FirebaseAuth.getInstance().getCurrentUser();

    }

    public void GalleryFunction(View view) {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PIC_IMAGE_REQUEST);

    }

    public void registration(View view) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Profile Update");
        progressDialog.setTitle("Processing...");
        progressDialog.show();
        uploadInformation(view);
        finish();
    }

    void uploadInformation(View view) {

            String email = user.getEmail();
            String image = imageToString(bitmap);
            String userName = mUserNmae.getText().toString().trim();
            String phone = mPhone.getText().toString().trim();
            String NID = mNID.getText().toString().trim();
            String dateOfBirth = mDateOfBirth.getText().toString().trim();
            String user1 = "user";
            int balance = 0;
            databaseReference = FirebaseDatabase.getInstance().getReference("User").child(user.getUid());
            databaseReference1 = FirebaseDatabase.getInstance().getReference("User").child(user.getUid()).child("Balance").push();
            UserInformation userInformation = new UserInformation(email, NID, phone, userName, image, dateOfBirth, user1);
            UserInformation userInformation1 = new UserInformation(balance);
            databaseReference.setValue(userInformation);
            databaseReference1.setValue(userInformation1);
            progressDialog.dismiss();
            Intent intent = new Intent(UploadYourInformation.this, DashBord.class);
            startActivity(intent);

        Snackbar.make(view, "Select Profile Image", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public String imageToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
        byte[] imgbyte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgbyte, Base64.DEFAULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PIC_IMAGE_REQUEST && resultCode == Activity.RESULT_OK
                && data != null && data.getData() != null) {

            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                mImage.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
