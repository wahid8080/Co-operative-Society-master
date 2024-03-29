package com.example.cooperativesociety.Adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cooperativesociety.Model.AnnualModelClass;
import com.example.cooperativesociety.R;

import java.util.ArrayList;

public class MyAdepterOfAnnualProg extends RecyclerView.Adapter<MyAdepterOfAnnualProg.MyViewHolder> {

    private Activity activity;
    private ArrayList<AnnualModelClass> annualModelClassArrayList;
    private Bitmap bitmap;

    public MyAdepterOfAnnualProg(Activity activity, ArrayList<AnnualModelClass> annualModelClassArrayList) {
        this.activity = activity;
        this.annualModelClassArrayList = annualModelClassArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(activity).inflate(R.layout.annual_list_view,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        AnnualModelClass modelClass = annualModelClassArrayList.get(i);

        myViewHolder.typeOfProgram.setText(modelClass.getTypeOfProgram());
        myViewHolder.locationOfProgram.setText(modelClass.getProgramLocatiion());
        myViewHolder.historyOfProgram.setText(modelClass.getProgramHistory());

        bitmap = StringToBitMap(modelClass.getStringImage());
        myViewHolder.annulEventImageId.setImageBitmap(bitmap);

    }

    @Override
    public int getItemCount() {
        return annualModelClassArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView typeOfProgram,locationOfProgram,historyOfProgram;
        ImageView annulEventImageId;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            typeOfProgram = itemView.findViewById(R.id.typeOfProgram);
            locationOfProgram = itemView.findViewById(R.id.locationOfProgram);
            historyOfProgram = itemView.findViewById(R.id.historyOfProgram);
            annulEventImageId = itemView.findViewById(R.id.annulEventImageId);
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
