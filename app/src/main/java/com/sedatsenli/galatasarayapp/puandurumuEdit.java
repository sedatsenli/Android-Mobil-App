package com.sedatsenli.galatasarayapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class puandurumuEdit extends AppCompatActivity {


    private EditText takimAdi, oynananMac, galibiyet, beraberlik, maglubiyet, atilanGol, yenilenGol, averaj, puan;
    private Button ekleButonu;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puandurumu_edit);

        takimAdi= findViewById(R.id.takimAdi6);
        oynananMac = findViewById(R.id.oynananMac5);
        galibiyet = findViewById(R.id.galibiyet5);
        beraberlik = findViewById(R.id.beraberlik5);
        maglubiyet = findViewById(R.id.maglubiyet5);
        atilanGol = findViewById(R.id.atilanGol5);
        yenilenGol = findViewById(R.id.yenilenGol5);
        averaj = findViewById(R.id.averaj5);
        puan = findViewById(R.id.puan5);

        ekleButonu = findViewById(R.id.ekleButonu5);

        progressDialog = new ProgressDialog(puandurumuEdit.this);
        progressDialog.setTitle("Yükleniyor");
        progressDialog.setMessage("Kaydediliyor...");

        ekleButonu.setOnClickListener(v -> {
            if (takimAdi.getText().length()>0 && oynananMac.getText().length()>0 && galibiyet.getText().length()>0 && beraberlik.getText().length()>0 && maglubiyet.getText().length()>0 && atilanGol.getText().length()>0
                    && yenilenGol.getText().length()>0 && averaj.getText().length()>0 && puan.getText().length()>0) {
                saveData(takimAdi.getText().toString(), oynananMac.getText().toString(), galibiyet.getText().toString(), beraberlik.getText().toString(), maglubiyet.getText().toString(),
                        atilanGol.getText().toString(), yenilenGol.getText().toString(), averaj.getText().toString(), puan.getText().toString());
            }
            else {
                Toast.makeText(getApplicationContext(), "Doldurma alanları boş geçilemez!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveData (String takimAdi, String oynananMac, String galibiyet, String beraberlik, String maglubiyet,
                           String atilanGol, String yenilenGol, String averaj, String puan){
        Map<String, Object> puandurumu = new HashMap<>();
        puandurumu.put("takimadi", takimAdi);
        puandurumu.put("oynananmac", oynananMac);
        puandurumu.put("galibiyet", galibiyet);
        puandurumu.put("beraberlik", beraberlik);
        puandurumu.put("maglubiyet", maglubiyet);
        puandurumu.put("atilangol", atilanGol);
        puandurumu.put("yenilengolt", yenilenGol);
        puandurumu.put("averaj", averaj);
        puandurumu.put("puan", puan);

        progressDialog.show();
        db.collection("puandurumu")
                .add(puandurumu)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Başarılı!", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });
    }
}