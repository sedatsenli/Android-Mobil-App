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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.sedatsenli.galatasarayapp.adapter.fiksturAdapter;
import com.sedatsenli.galatasarayapp.adapter.puandurumuAdapter;
import com.sedatsenli.galatasarayapp.model.fikstur;
import com.sedatsenli.galatasarayapp.model.puandurumu;

import java.util.ArrayList;
import java.util.List;

public class puan_durumu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<puandurumu> list5 = new ArrayList<>();
    private com.sedatsenli.galatasarayapp.adapter.puandurumuAdapter puandurumuAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiksturumuz);

        recyclerView = findViewById(R.id.recyler_view);

        progressDialog = new ProgressDialog(puan_durumu.this);
        progressDialog.setTitle("Yükleniyor");
        progressDialog.setMessage("Veriler Alınıyor...");
        puandurumuAdapter = new puandurumuAdapter(getApplicationContext(), list5);



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(puandurumuAdapter);

        progressDialog.show();
        db.collection("puandurumu")
                .orderBy("puan", Query.Direction.DESCENDING) //TAKIMLARI PUAN DURUMUNA GORE SIRALAMAK ICIN...
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list5.clear();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()){
                                puandurumu puandurumuModel = new puandurumu(document.getString("takimadi"), document.getString("oynananmac"), document.getString("galibiyet"), document.getString("beraberlik"), document.getString("maglubiyet"),
                                        document.getString("atilangol"),document.getString("yenilengol"), document.getString("averaj"), document.getString("puan"));
                                list5.add(puandurumuModel);
                            }
                            puandurumuAdapter.notifyDataSetChanged();

                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Veri Alınamadı!", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }
}