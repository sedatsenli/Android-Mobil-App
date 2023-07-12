package com.sedatsenli.galatasarayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class menu_activity extends AppCompatActivity {

    Button fiksturActivity;
    Button puandurumuActivity;
    Button takimimizActivity;
    Button haberlerActivity;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        fiksturActivity = findViewById(R.id.fiksturActivity);

        fiksturActivity.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), fiksturumuz.class));
        });

        puandurumuActivity = findViewById(R.id.puandurumuActivity);

        puandurumuActivity.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), puan_durumu.class));
        });

        takimimizActivity = findViewById(R.id.takimimizActivity);

        takimimizActivity.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), takimimiz.class));
        });

        haberlerActivity = findViewById(R.id.haberlerActivity);

        haberlerActivity.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), haberler.class));
        });
    }

}