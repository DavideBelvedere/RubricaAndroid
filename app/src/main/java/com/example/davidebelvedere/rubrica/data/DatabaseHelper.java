package com.example.davidebelvedere.rubrica.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;
    // Lo statement SQL di creazione del database
    private static final String DATABASE_CREATE = "CREATE TABLE contact (_id integer primary key autoincrement, nome VARCHAR(255), telefono VARCHR(11), preferito integer);";

    // Costruttore
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    // Questo metodo viene chiamato durante l'upgrade del database,
    // ad esempio quando viene incrementato il numero di versione
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS contact");
        onCreate(database);
    }
}
