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
import com.sedatsenli.galatasarayapp.model.haberlerModel;
import com.sedatsenli.galatasarayapp.model.takimGorsel;

import java.util.ArrayList;

public class haberlerAdapter extends RecyclerView.Adapter<haberlerAdapter.MyViewHolder1>{
    private ArrayList<haberlerModel> mList;
    private Context context;

    public haberlerAdapter(Context context , ArrayList<haberlerModel> mList){

        this.context = context;
        this.mList = mList;
    }


    @NonNull
    @Override
    public haberlerAdapter.MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_haberler , parent ,false);
        return new haberlerAdapter.MyViewHolder1(v);
    }

    @Override
    public void onBindViewHolder(@NonNull haberlerAdapter.MyViewHolder1 holder, int position) {
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

            imageView = itemView.findViewById(R.id.oyuncuResim25);
        }
    }
}
