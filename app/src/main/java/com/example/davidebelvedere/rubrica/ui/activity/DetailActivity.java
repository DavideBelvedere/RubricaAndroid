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
import com.example.davidebelvedere.rubrica.data.MainSingleton;
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
        final String name = intent.getStringExtra("nome");
        MainSingleton.getInstance().getDbManager().open();
        boolean preferito;
        final int id = Integer.parseInt(intent.getStringExtra("id"));
        if (intent.getStringExtra("preferito").equals("1")) {
            preferito = true;
        } else {
            preferito = false;
        }
        final String number = intent.getStringExtra("numero");
        TextView nome = (TextView) findViewById(R.id.nome);
        TextView numero = (TextView) findViewById(R.id.telefono);
        ImageView img = (ImageView) findViewById(R.id.imgDetail);
        Button favouriteButton = (Button) findViewById(R.id.favourites);

        if (preferito) {
            favouriteButton.setText("Rimuovi Preferito");
            favouriteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainSingleton.getInstance().getDbManager().updateContact(id,name,number,0);
                }
            });
        } else {
            favouriteButton.setText("Aggiungi Preferito");
            favouriteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainSingleton.getInstance().getDbManager().updateContact(id,name,number,1);
                }
            });

        }
        nome.setText("Nome: " + name);
        numero.setText("Telefono: " + number);


    }
}
