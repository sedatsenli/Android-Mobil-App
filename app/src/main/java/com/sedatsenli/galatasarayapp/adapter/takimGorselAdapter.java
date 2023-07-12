package com.sedatsenli.galatasarayapp.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sedatsenli.galatasarayapp.R;
import com.sedatsenli.galatasarayapp.model.takimGorsel;

import java.util.ArrayList;

public class takimGorselAdapter extends RecyclerView.Adapter<takimGorselAdapter.MyViewHolder1>{


    private ArrayList<takimGorsel> mList;
    private Context context;

    public takimGorselAdapter(Context context , ArrayList<takimGorsel> mList){

        this.context = context;
        this.mList = mList;
    }


    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_takim , parent ,false);
        return new MyViewHolder1(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 holder, int position) {
        Glide.with(context).load(mList.get(position).getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder1 extends RecyclerView.ViewHolder{

        ImageView imageView;
        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.oyuncuImageview);
        }
    }
}
