package com.example.cooperativesociety.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cooperativesociety.EventDonate;
import com.example.cooperativesociety.Model.EventModelClass;
import com.example.cooperativesociety.R;
import com.example.cooperativesociety.TotalDataViewOfEvent;

import java.util.ArrayList;

public class MyAdepterOfEvent extends RecyclerView.Adapter<MyAdepterOfEvent.MyViewHolder> {


    private Context context;
    private ArrayList<EventModelClass> eventModelClassArrayList;
    private Bitmap bitmap;
    private String key;


    public MyAdepterOfEvent(Context context, ArrayList<EventModelClass> eventModelClassArrayList,String key) {
        this.context = context;
        this.eventModelClassArrayList = eventModelClassArrayList;
        this.key = key;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_view_list,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        final EventModelClass modelClass = eventModelClassArrayList.get(i);
        myViewHolder.name.setText("Event Name: "+modelClass.getEventName());
        myViewHolder.location.setText("Location: "+modelClass.getLocation());
        bitmap = StringToBitMap(modelClass.getImage1());
        myViewHolder.mImage.setImageBitmap(bitmap);

        myViewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TotalDataViewOfEvent.class);
                intent.putExtra("name",modelClass.getEventName());
                intent.putExtra("location",modelClass.getLocation());
                intent.putExtra("cost",modelClass.getEventCost());
                intent.putExtra("description",modelClass.getEventDescription());
                intent.putExtra("img1",modelClass.getImage1());
                intent.putExtra("img2",modelClass.getImage2());
                intent.putExtra("img3",modelClass.getImage3());
                intent.putExtra("img4",modelClass.getImage4());
                context.startActivity(intent);
                Toast.makeText(context,modelClass.getEventName(),Toast.LENGTH_SHORT).show();
            }
        });

        myViewHolder.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventDonate.class);
                intent.putExtra("bank",key);
                intent.putExtra("name",modelClass.getEventName());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return eventModelClassArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,location;
        Button button,button2;
        ImageView mImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.eventNameId);
            location = itemView.findViewById(R.id.eventLocationId);
            mImage = itemView.findViewById(R.id.eventImage1Id);
            button = itemView.findViewById(R.id.seeDetailsOnClick);
            button2 = itemView.findViewById(R.id.donateForEvent);

        }
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
