package com.sedatsenli.galatasarayapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sedatsenli.galatasarayapp.R;
import com.sedatsenli.galatasarayapp.model.fikstur;

import java.util.List;

public class fiksturAdapter extends RecyclerView.Adapter<fiksturAdapter.MyViewHolder>{

    private Context context;
    private List<fikstur> list; //model icindeki fikstur
    private Dialog dialog;

    public interface Dialog {
        void onClick(int pos);
    }

    public Dialog getDialog() {
        return dialog;
    }

    public fiksturAdapter (Context context, List<fikstur> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_fikstur, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.takimAdi.setText(list.get(position).getTakim());
        holder.rakiptakimAdi.setText(list.get(position).getRakipTakim());
        holder.hafta.setText(list.get(position).getHafta());
        holder.saatvegun.setText(list.get(position).getSaatvegun());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView takimAdi, rakiptakimAdi, hafta, saatvegun;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            takimAdi= itemView.findViewById(R.id.takimAdi1); //row_fikstur idleri
            rakiptakimAdi = itemView.findViewById(R.id.rakiptakimAdi1);
            hafta   = itemView.findViewById(R.id.hafta1);
            saatvegun = itemView.findViewById(R.id.saatvegun1);
        }
    }
}
