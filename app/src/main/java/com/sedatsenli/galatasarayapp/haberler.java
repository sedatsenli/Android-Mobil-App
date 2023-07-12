package com.sedatsenli.galatasarayapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sedatsenli.galatasarayapp.adapter.haberlerAdapter;
import com.sedatsenli.galatasarayapp.model.haberlerModel;

import java.util.ArrayList;

public class haberler extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private ArrayList<haberlerModel> list6;

    private haberlerAdapter adapter;

    private DatabaseReference root = FirebaseDatabase.getInstance().getReference("Image2");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haberler);

        recyclerView1 = findViewById(R.id.recyler_view1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(haberler.this));
        list6 = new ArrayList<haberlerModel>();
        adapter = new haberlerAdapter(haberler.this , list6);
        recyclerView1.setAdapter(adapter);

        root.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    haberlerModel model4 = dataSnapshot.getValue(haberlerModel.class);
                    list6.add(model4);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}