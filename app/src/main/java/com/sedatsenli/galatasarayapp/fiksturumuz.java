package com.sedatsenli.galatasarayapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.ktx.Firebase;
import com.sedatsenli.galatasarayapp.adapter.fiksturAdapter;
import com.sedatsenli.galatasarayapp.model.fikstur;

import java.util.ArrayList;
import java.util.List;

public class fiksturumuz extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<fikstur> list = new ArrayList<>();
    private fiksturAdapter fiksturAdapter;
    private ProgressDialog progressDialog; //yukleniyor yazisi icin

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiksturumuz);

        recyclerView = findViewById(R.id.recyler_view);

        progressDialog = new ProgressDialog(fiksturumuz.this);
        progressDialog.setTitle("Yükleniyor");
        progressDialog.setMessage("Veriler Alınıyor...");
        fiksturAdapter = new fiksturAdapter(getApplicationContext(), list);



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(fiksturAdapter);

        progressDialog.show();
        db.collection("fikstur")
                .orderBy("hafta", Query.Direction.ASCENDING)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()){
                                fikstur fikstur = new fikstur(document.getString("takim"), document.getString("rakipTakim"), document.getString("hafta"), document.getString("SaatveGun"));
                                list.add(fikstur);
                            }
                            fiksturAdapter.notifyDataSetChanged();

                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Veri Alınamadı!", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }
}