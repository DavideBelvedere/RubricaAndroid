package com.example.davidebelvedere.rubrica.ui.adapter;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidebelvedere.rubrica.R;
import com.example.davidebelvedere.rubrica.data.Contatto;

import com.example.davidebelvedere.rubrica.data.MainSingleton;
import com.example.davidebelvedere.rubrica.logic.Utility;
import com.example.davidebelvedere.rubrica.ui.activity.DetailActivity;


import java.util.List;

/**
 * Created by davidebelvedere on 15/02/18.
 */


public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<Contatto> values;


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView number;
        ImageView image;
        ImageView favourite;
        int position;
        Context context;

        public MyViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.nome);
            number = (TextView) view.findViewById(R.id.telefono);
            image = (ImageView) view.findViewById(R.id.colore);
            favourite = (ImageView) view.findViewById(R.id.favourite);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Contatto selectedItem = Utility.getDataSourceItemList().get(position);

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("nome", selectedItem.getNome());
            intent.putExtra("numero", selectedItem.getTelefono());

            context.startActivity(intent);
        }
    }

    public MyRecyclerAdapter(List<Contatto> values, Context context) {
        this.values = values;
        this.context = context;
    }

    @Override
    public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }


    @Override
    public void onBindViewHolder(MyRecyclerAdapter.MyViewHolder holder, int position) {
        Contatto currentContact = values.get(position);
        holder.name.setText(currentContact.getNome());
        holder.number.setText(currentContact.getTelefono());
        holder.image.setBackgroundColor(Utility.getColorForPosition(context, position));
        holder.position = position;
        holder.context = context;

    }

    public void updateData() {
        this.values = MainSingleton.getInstance().getContactArray();
        notifyDataSetChanged();
    }
}

