package com.example.davidebelvedere.rubrica.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidebelvedere.rubrica.R;
import com.example.davidebelvedere.rubrica.data.Contatto;
import com.example.davidebelvedere.rubrica.logic.Utility;

import java.util.List;

/**
 * Created by davidebelvedere on 15/02/18.
 */

public class CustomArrayAdapter extends ArrayAdapter<Contatto> {
    private final Context context;
    private final List<Contatto> values;

    public CustomArrayAdapter(Context context, List<Contatto> values) {
        super(context, R.layout.contact_layout, values);
        this.context = context;
        this.values = values;
    }

    /*public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);//converrte un layout in un oggetto di tipo view
        View rowView = inflater.inflate(R.layout.contact_layout, parent, false);
        TextView nameTextView = (TextView) rowView.findViewById(R.id.nome);
        TextView telTextView = (TextView) rowView.findViewById(R.id.telefono);
        ImageView colorView = (ImageView) rowView.findViewById(R.id.colore);
        Contatto currentItem = this.values.get(position);
        nameTextView.setText(currentItem.getNome());
        telTextView.setText(currentItem.getTelefono());
        colorView.setBackgroundColor(Utility.getColorForPosition(this.context, position));
        return rowView;
    }*/

    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewOptimize(position, convertView, parent);
    }

    public View getViewOptimize(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.contact_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.nome);
            viewHolder.number = (TextView) convertView.findViewById(R.id.telefono);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.colore);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Contatto contatto = this.values.get(position);
        viewHolder.name.setText(contatto.getNome());
        viewHolder.number.setText(contatto.getTelefono());
        viewHolder.image.setBackgroundColor(Utility.getColorForPosition(this.context, position));
        return convertView;
    }

    private class ViewHolder {
        public TextView name;
        public TextView number;
        public ImageView image;
    }


}
