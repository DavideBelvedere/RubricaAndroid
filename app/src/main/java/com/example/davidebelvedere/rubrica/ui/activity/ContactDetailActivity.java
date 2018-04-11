package com.example.davidebelvedere.rubrica.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
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
 * Created by davidebelvedere on 15/02/18.
 */

public class ContactDetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);

        Intent intent = getIntent();
        //String selectedItem = intent.getStringExtra("label");


        // Set onclick listener
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nome = (EditText) findViewById(R.id.nome);
                EditText numero = (EditText) findViewById(R.id.numero);

                MainSingleton.getInstance().getDbManager().open();
                MainSingleton.getInstance().getDbManager().createContact(String.valueOf(nome.getText()),String.valueOf(numero.getText()),0);
                finish();
            }
        });
    }
}
