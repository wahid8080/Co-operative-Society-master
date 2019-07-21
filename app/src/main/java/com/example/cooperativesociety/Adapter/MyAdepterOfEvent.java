package com.example.cooperativesociety.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cooperativesociety.Model.EventModelClass;
import com.example.cooperativesociety.R;

import java.util.ArrayList;

public class MyAdepterOfEvent extends RecyclerView.Adapter<MyAdepterOfEvent.MyViewHolder> {


    Context context;
    ArrayList<EventModelClass> eventModelClassArrayList;

    public MyAdepterOfEvent(Context context, ArrayList<EventModelClass> eventModelClassArrayList) {
        this.context = context;
        this.eventModelClassArrayList = eventModelClassArrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.event_view_list,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.name.setText(eventModelClassArrayList.get(i).getEventName());
        myViewHolder.phone.setText(eventModelClassArrayList.get(i).getEventCost());

    }

    @Override
    public int getItemCount() {
        return eventModelClassArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,phone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.EventName);
            phone = itemView.findViewById(R.id.EventPhone);

        }
    }
}
