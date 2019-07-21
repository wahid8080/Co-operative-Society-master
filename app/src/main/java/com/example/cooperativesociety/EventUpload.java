package com.example.cooperativesociety;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cooperativesociety.Model.EventModelClass;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class EventUpload extends AppCompatActivity {

    private ImageView mImg1,mImg2,mImg3,mImg4;
    private Bitmap bitmap1,bitmap2,bitmap3,bitmap4;

    private EditText mName,mCost,mDesc;
    private Button upload;
    private LinearLayout mLayout1,mLayout2;
    private static final int CODE_MULTIPLE_IMG_GALLERY = 2;

    private DatabaseReference databaseReference;

    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_upload);
        upload = findViewById(R.id.chooseImage);

        mImg1 = findViewById(R.id.img1);
        mImg2 = findViewById(R.id.img2);
        mImg3 = findViewById(R.id.img3);
        mImg4 = findViewById(R.id.img4);
        mName = findViewById(R.id.eventNameId);
        mCost = findViewById(R.id.eventCostId);
        mDesc = findViewById(R.id.eventDicId);
        mLayout1 = findViewById(R.id.linearLayoutForImage1);
        mLayout2 = findViewById(R.id.linearLayoutForImage2);

        user = FirebaseAuth.getInstance().getCurrentUser();

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Multiple image"),
                        CODE_MULTIPLE_IMG_GALLERY);
            }
        });


    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODE_MULTIPLE_IMG_GALLERY && resultCode == RESULT_OK )
        {
            ClipData clipData = data.getClipData();
            if (clipData != null)
            {
                mImg1.setImageURI(clipData.getItemAt(0).getUri());
                mImg2.setImageURI(clipData.getItemAt(1).getUri());
                mImg3.setImageURI(clipData.getItemAt(2).getUri());
                mImg4.setImageURI(clipData.getItemAt(3).getUri());

                try {
                    bitmap1 = MediaStore.Images.Media.getBitmap(getContentResolver(), clipData.getItemAt(0).getUri());
                    bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver(), clipData.getItemAt(1).getUri());
                    bitmap3 = MediaStore.Images.Media.getBitmap(getContentResolver(), clipData.getItemAt(2).getUri());
                    bitmap4 = MediaStore.Images.Media.getBitmap(getContentResolver(), clipData.getItemAt(3).getUri());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mLayout1.setVisibility(View.VISIBLE);
                mLayout2.setVisibility(View.VISIBLE);
                upload.setVisibility(View.GONE);

            }
        }
    }

    public void eventSubmit(View view) {

        String m1 = imageToString(bitmap1);
        String m2 = imageToString(bitmap2);
        String m3 = imageToString(bitmap3);
        String m4 = imageToString(bitmap4);

        String name = mName.getText().toString().trim();
        String cost = mCost.getText().toString().trim();
        String desc = mDesc.getText().toString().trim();

        databaseReference = FirebaseDatabase.getInstance().getReference("Event").child("event1");
        EventModelClass modelClass = new EventModelClass(m1,m2,m3,m4,name,cost,desc);
        databaseReference.setValue(modelClass);
    }

    public String imageToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
        byte[] imgbyte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgbyte, Base64.DEFAULT);
    }
}
