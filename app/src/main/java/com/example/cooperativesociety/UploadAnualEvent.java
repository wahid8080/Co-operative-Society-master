package com.example.cooperativesociety;

import android.app.Activity;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cooperativesociety.Model.AnnualModelClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class UploadAnualEvent extends AppCompatActivity {

    EditText type,location,history;
    String key;
    private int PIC_IMAGE_REQUEST = 1;
    private Bitmap bitmap;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_anual_event);

        type = findViewById(R.id.uploadTypeOfProgram);
        location = findViewById(R.id.uploadLocationOfProgram);
        history = findViewById(R.id.uploadHistoryOfProgram);

        key = getIntent().getStringExtra("bank");
        button = findViewById(R.id.buttonId);


    }

    public void uploadanualEvent(View view) {

        String typeOfProgram = type.getText().toString();
        String programLpcation = location.getText().toString();
        String programhistory = history.getText().toString();
        String stringImage1 = imageToString(bitmap);


            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("AnnualProgram").child(key).push();
            AnnualModelClass  annualModelClass = new AnnualModelClass(typeOfProgram,programLpcation,programhistory,stringImage1);
            databaseReference.setValue(annualModelClass);
            startActivity(new Intent(UploadAnualEvent.this,DashBord.class));
            finish();

    }

    public void chooseImageForAnnualEvent(View view) {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PIC_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PIC_IMAGE_REQUEST && resultCode == Activity.RESULT_OK
                && data != null && data.getData() != null) {

            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                button.setEnabled(true);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String imageToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] imgbyte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgbyte, Base64.DEFAULT);
    }
}
