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

public class fiksturEdit extends AppCompatActivity {
    private EditText editTakim, editRakiptakim, editSaatvegun, editHafta;
    private Button ekleButonu;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fikstur_edit);

        editTakim = findViewById(R.id.takimAdi);
        editRakiptakim = findViewById(R.id.rakiptakimAdi);
        editHafta = findViewById(R.id.hafta);
        editSaatvegun = findViewById(R.id.saatvegun);

        ekleButonu = findViewById(R.id.ekleButonu);

        progressDialog = new ProgressDialog(fiksturEdit.this);
        progressDialog.setTitle("Yükleniyor");
        progressDialog.setMessage("Kaydediliyor...");

        ekleButonu.setOnClickListener(v -> {
            if (editTakim.getText().length()>0 && editRakiptakim.getText().length()>0 && editHafta.getText().length()>0 && editSaatvegun.getText().length()>0) {
                saveData(editTakim.getText().toString(), editRakiptakim.getText().toString(), editHafta.getText().toString(), editSaatvegun.getText().toString());
            }
            else {
                Toast.makeText(getApplicationContext(), "Doldurma alanları boş geçilemez!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveData (String Takim, String rakipTakim, String Hafta, String SaatveGun ){
        Map<String, Object> hafta = new HashMap<>();
        hafta.put("takim", Takim);
        hafta.put("rakipTakim", rakipTakim);
        hafta.put("hafta", Hafta);
        hafta.put("SaatveGun", SaatveGun);

        progressDialog.show();
        db.collection("fikstur")
                .add(hafta)
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