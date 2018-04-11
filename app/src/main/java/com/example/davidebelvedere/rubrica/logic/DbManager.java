package com.example.davidebelvedere.rubrica.logic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.davidebelvedere.rubrica.data.DatabaseHelper;

public class DbManager {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private Context context;


    private static final String DATABASE_TABLE = "contact";
    public static final String KEY_CONTACTID = "_id";
    public static final String KEY_NAME = "nome";
    public static final String KEY_PHONE = "telefono";
    public static final String KEY_FAVOURITE = "preferito";

    public DbManager(Context context) {
        this.context = context;
    }
    public DbManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentValues(String name, String phone, int favourite) {
        ContentValues values = new ContentValues();
        values.put( KEY_NAME, name );
        values.put( KEY_PHONE, phone );
        values.put( KEY_FAVOURITE, favourite );
        return values;
    }

    //create a contact
    public long createContact(String name, String phone, int favourite ) {
        ContentValues initialValues = createContentValues(name, phone, favourite);
        return database.insertOrThrow(DATABASE_TABLE, null, initialValues);
    }
    //update a contact
    public boolean updateContact( long contactID, String name, String phone, int favourite ) {
        ContentValues updateValues = createContentValues(name, phone, favourite);
        return database.update(DATABASE_TABLE, updateValues, KEY_CONTACTID + "=" + contactID, null) > 0;
    }
    //delete a contact
    public boolean deleteContact(long contactID) {
        return database.delete(DATABASE_TABLE, KEY_CONTACTID + "=" + contactID, null) > 0;
    }
    //fetch all contacts
    public Cursor fetchAllContacts() {
        return database.query(DATABASE_TABLE, new String[] { KEY_CONTACTID, KEY_NAME, KEY_PHONE, KEY_FAVOURITE}, null, null,null,null,null);
    }
}
