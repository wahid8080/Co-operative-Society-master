package com.example.cooperativesociety.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cooperativesociety.Model.HelpModelClass;
import com.example.cooperativesociety.R;

import java.util.ArrayList;


public class MyAdepterOfHelp extends RecyclerView.Adapter<MyAdepterOfHelp.MyViewHolder> {

    private ArrayList<HelpModelClass> helpModelClassArrayList;
    private Activity context;

    public MyAdepterOfHelp(ArrayList<HelpModelClass> helpModelClassArrayList, Activity context) {
        this.helpModelClassArrayList = helpModelClassArrayList;
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.help_list_view,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        HelpModelClass helpModelClass = helpModelClassArrayList.get(i);

        myViewHolder.cost.setText("Help Cost : "+helpModelClass.getHelpCost());
        myViewHolder.desc.setText("Description : "+helpModelClass.getHelpDesc());


    }

    @Override
    public int getItemCount() {
        return helpModelClassArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView cost,desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cost = itemView.findViewById(R.id.descrepitoncostId);
            desc = itemView.findViewById(R.id.descrepitonId);

        }
    }
}
