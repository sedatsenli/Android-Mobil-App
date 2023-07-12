package com.sedatsenli.galatasarayapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sedatsenli.galatasarayapp.R;
import com.sedatsenli.galatasarayapp.model.puandurumu;

import java.util.List;

public class puandurumuAdapter extends RecyclerView.Adapter<puandurumuAdapter.MyViewHolder5> {

    private Context context;
    private List<puandurumu> list; //model icindeki fikstur
    private fiksturAdapter.Dialog dialog;

    public interface Dialog {
        void onClick(int pos);
    }

    public fiksturAdapter.Dialog getDialog() {
        return dialog;
    }

    public puandurumuAdapter (Context context, List<puandurumu> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder5 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_puandurumu, parent, false);
        return new MyViewHolder5(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull puandurumuAdapter.MyViewHolder5 holder, int position) {
        holder.takimAdi.setText(list.get(position).getTakimAdi());
        holder.oynananMac.setText(list.get(position).getOynananMac());
        holder.galibiyet.setText(list.get(position).getGalibiyet());
        holder.beraberlik.setText(list.get(position).getBeraberlik());
        holder.maglubiyet.setText(list.get(position).getMaglubiyet());
        holder.atilanGol.setText(list.get(position).getAtilanGol());
        holder.yenilenGol.setText(list.get(position).getYenilenGol());
        holder.averaj.setText(list.get(position).getAveraj());
        holder.puan.setText(list.get(position).getPuan());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder5 extends RecyclerView.ViewHolder {

        TextView takimAdi, oynananMac, galibiyet, beraberlik, maglubiyet, atilanGol, yenilenGol, averaj, puan;
        public MyViewHolder5(@NonNull View itemView) {
            super(itemView);
            takimAdi= itemView.findViewById(R.id.takimAdi8); //row_fikstur idleri
            oynananMac = itemView.findViewById(R.id.oynananMac8);
            galibiyet   = itemView.findViewById(R.id.galibiyet8);
            beraberlik = itemView.findViewById(R.id.beraberlik8);
            maglubiyet = itemView.findViewById(R.id.maglubiyet8);
            atilanGol = itemView.findViewById(R.id.atilanGol8);
            yenilenGol = itemView.findViewById(R.id.yenilenGol8);
            averaj = itemView.findViewById(R.id.averaj8);
            puan = itemView.findViewById(R.id.puan8);
        }
    }
}
