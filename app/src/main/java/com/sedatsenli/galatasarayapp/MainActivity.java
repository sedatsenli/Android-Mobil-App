 package com.sedatsenli.galatasarayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


 public class MainActivity extends AppCompatActivity {

     Button girisYap;
     Button gelistiriciGiris;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        girisYap = (Button)findViewById(R.id.giris);
        girisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent KullaniciArayuzSecimi = new Intent(getApplicationContext(),menu_activity.class);
                startActivity(KullaniciArayuzSecimi);
            }
        });

        gelistiriciGiris = (Button) findViewById(R.id.gelistiriciGiris);
        gelistiriciGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gelistiriciGiris = new Intent(getApplicationContext(),gelistiriciGiris.class);
                startActivity(gelistiriciGiris);
            }
        });
    }


}