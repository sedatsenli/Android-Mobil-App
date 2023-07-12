package com.sedatsenli.galatasarayapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class gelistiriciGiris extends AppCompatActivity {

    private EditText editEmail, editSifre;
    private String txtEmail, txtSifre;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    Button girisButon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelistirici_giris);

        editEmail = (EditText) findViewById(R.id.email);
        editSifre = (EditText) findViewById(R.id.sifre);

        mAuth = FirebaseAuth.getInstance();
    }

    public void girisButon(View view) {
        txtEmail = editEmail.getText().toString();
        txtSifre = editSifre.getText().toString();

            if(!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtSifre)) {

                mAuth.signInWithEmailAndPassword(txtEmail, txtSifre)
                        .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                mUser = mAuth.getCurrentUser();

                                 girisButon = (Button)findViewById(R.id.girisButon);
                                 girisButon.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent KullaniciArayuzSecimi = new Intent(getApplicationContext(),gelistiriciMenu.class);
                                        startActivity(KullaniciArayuzSecimi);
                                    }
                                });
                                // System.out.println("Kullanici Adi: " + mUser.getDisplayName());
                            }
                        }).addOnFailureListener(this, new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(gelistiriciGiris.this, e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });
            }
            else {
                Toast.makeText(this, "Email ve Sifre Bos Birakilamaz", Toast.LENGTH_SHORT).show();
            }
        }
}
