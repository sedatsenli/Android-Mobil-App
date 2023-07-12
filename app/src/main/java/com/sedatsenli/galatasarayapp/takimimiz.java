package com.sedatsenli.galatasarayapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.load.model.Model;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.sedatsenli.galatasarayapp.adapter.takimGorselAdapter;
import com.sedatsenli.galatasarayapp.model.takimGorsel;

import java.util.ArrayList;
import java.util.List;

public class takimimiz extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private ArrayList<takimGorsel> list1;

    private takimGorselAdapter adapter;

    private DatabaseReference root = FirebaseDatabase.getInstance().getReference("Image");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takimimiz);

        recyclerView1 = findViewById(R.id.recyler_view1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(takimimiz.this));
        list1 = new ArrayList<>();
        adapter = new takimGorselAdapter(takimimiz.this , list1);
        recyclerView1.setAdapter(adapter);

        root.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    takimGorsel model = dataSnapshot.getValue(takimGorsel.class);
                    list1.add(model);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}