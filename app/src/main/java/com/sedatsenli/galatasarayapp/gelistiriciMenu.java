package com.sedatsenli.galatasarayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class gelistiriciMenu extends AppCompatActivity {
    private Button fiksturEdit, puandurumuEdit, takimimizEdit, haberlerEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelistirici_menu);

        fiksturEdit = findViewById(R.id.fiksturEdit);

        fiksturEdit.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), fiksturEdit.class));
        });

        puandurumuEdit = findViewById(R.id.puandurumuEdit);

        puandurumuEdit.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), puandurumuEdit.class));
        });

        takimimizEdit = findViewById(R.id.takimimizEdit);

        takimimizEdit.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), takimEdit.class));
        });

        haberlerEdit = findViewById(R.id.haberlerEdit);

        haberlerEdit.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), takimdanhaberlerEdit.class));
        });

    }
}