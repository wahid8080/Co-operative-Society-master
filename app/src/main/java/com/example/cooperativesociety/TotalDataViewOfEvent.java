package com.example.cooperativesociety;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

public class TotalDataViewOfEvent extends AppCompatActivity {

    ImageView img1,img2,img3,img4;
    TextView name,location,description,cost;
    Bitmap bitmap1,bitmap2,bitmap3,bitmap4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_data_view_of_event);

        name = findViewById(R.id.eventName);
        location = findViewById(R.id.eventLocation);
        description = findViewById(R.id.eventDesc);
        cost = findViewById(R.id.eventCost);

        img1 = findViewById(R.id.image1);
        img2 = findViewById(R.id.image2);
        img3 = findViewById(R.id.image3);
        img4 = findViewById(R.id.image4);

        String name1 = getIntent().getStringExtra("name");
        String location1 = getIntent().getStringExtra("location");
        String description1 = getIntent().getStringExtra("description");
        String cost1 = getIntent().getStringExtra("cost");
        String img11 = getIntent().getStringExtra("img1");
        String img21 = getIntent().getStringExtra("img2");
        String img31 = getIntent().getStringExtra("img3");
        String img41 = getIntent().getStringExtra("img4");


        bitmap1 = StringToBitMap(img11);
        bitmap2 = StringToBitMap(img21);
        bitmap3 = StringToBitMap(img31);
        bitmap4 = StringToBitMap(img41);

        name.setText(name1);
        location.setText(location1);
        description.setText(description1);
        cost.setText(cost1);


        img1.setImageBitmap(bitmap1);
        img2.setImageBitmap(bitmap2);
        img3.setImageBitmap(bitmap3);
        img4.setImageBitmap(bitmap4);


    }

    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
