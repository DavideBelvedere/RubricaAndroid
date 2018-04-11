package com.example.davidebelvedere.rubrica.ui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.davidebelvedere.rubrica.R;
import com.example.davidebelvedere.rubrica.logic.DbManager;
import com.example.davidebelvedere.rubrica.logic.Utility;

import android.widget.ImageView;
import android.widget.TextView;

public class MyCursorAdapter extends CursorAdapter {
    public MyCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.contact_layout, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView name = (TextView) view.findViewById(R.id.nome);
        TextView phone = (TextView) view.findViewById(R.id.telefono);
        ImageView favourite = (ImageView) view.findViewById((R.id.favourite));
        ImageView color = (ImageView) view.findViewById(R.id.colore);

        name.setText(cursor.getString(cursor.getColumnIndexOrThrow(DbManager.KEY_NAME)));
        phone.setText(cursor.getString(cursor.getColumnIndexOrThrow(DbManager.KEY_PHONE)));
        color.setBackgroundColor(Utility.getColorForPosition(context, cursor.getPosition()));
        if (cursor.getInt(cursor.getColumnIndexOrThrow(DbManager.KEY_FAVOURITE)) == 1) {
            favourite.setVisibility(View.VISIBLE);
        } else {
            favourite.setVisibility(View.GONE);
        }

    }


}
