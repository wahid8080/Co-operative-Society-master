package com.example.cooperativesociety.Adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cooperativesociety.Model.MembersModelClass;
import com.example.cooperativesociety.R;

import java.util.ArrayList;


public class MyAdepter extends RecyclerView.Adapter<MyAdepter.MyViewHolder> {

    private Activity context;
    private ArrayList<MembersModelClass> membersArrayList;


    public MyAdepter(Activity context, ArrayList<MembersModelClass> membersArrayList) {
        this.context = context;
        this.membersArrayList = membersArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.members_view_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {

        MembersModelClass members = membersArrayList.get(i);

        //holder.mImage.setImageBitmap(bm);
        holder.mEmail.setText(members.getEmail());
        holder.mName.setText(members.getUsername());
        holder.mPhone.setText(members.getPhone());
        holder.mImage.setImageBitmap(StringToBitMap(members.getImageToString()));
        holder.mImage2.setImageBitmap(StringToBitMap(members.getImageToString()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Number Of Member : " +i, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return membersArrayList.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        ImageView mImage,mImage2;
        TextView mEmail, mPhone, mName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.viewProfilePicMemberList);
            mEmail = itemView.findViewById(R.id.viewEmailMemberList);
            mPhone = itemView.findViewById(R.id.viewPhoneMemberList);
            mName = itemView.findViewById(R.id.viewNameMemberList);
            mImage2 = itemView.findViewById(R.id.viewCoverPicMemberList);
            relativeLayout = itemView.findViewById(R.id.userListClick);
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
