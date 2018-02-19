package com.example.davidebelvedere.rubrica.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidebelvedere.rubrica.R;
import com.example.davidebelvedere.rubrica.data.Contatto;
import com.example.davidebelvedere.rubrica.logic.Utility;

import static java.lang.String.valueOf;


/**
 * Created by davidebelvedere on 19/02/18.
 */

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        Intent intent = getIntent();
        String name = intent.getStringExtra("nome");
        final String number = intent.getStringExtra("numero");
        TextView nome = (TextView) findViewById(R.id.nome);
        TextView numero = (TextView) findViewById(R.id.telefono);
        ImageView img = (ImageView) findViewById(R.id.imgDetail);
        Button addFavourite = (Button) findViewById(R.id.favourites);
        nome.setText("Nome: " + name);
        numero.setText("Telefono: " + number);

        addFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.writeOnSharedPref(number, DetailActivity.this);
                finish();
            }
        });
        //#e0e0eb
        //img.setBackgroundColor();

    }
}
