package com.example.davidebelvedere.rubrica.logic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;

import com.example.davidebelvedere.rubrica.R;
import com.example.davidebelvedere.rubrica.data.Contatto;
import com.example.davidebelvedere.rubrica.data.MainSingleton;
import com.example.davidebelvedere.rubrica.ui.activity.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by davidebelvedere on 15/02/18.
 */

public class Utility {

    public static void initDataSource(Context context) {
        List<Contatto> contactList = new ArrayList<Contatto>();
        contactList.add(new Contatto("Giacomo", "3483222395"));
        contactList.add(new Contatto("Giacomino", "3483222397"));
        contactList.add(new Contatto("Giacometto", "3483222305"));
        contactList.add(new Contatto("Giacomollo", "2483222395"));
        contactList.add(new Contatto("Giacomonello", "3483222315"));
        MainSingleton.getInstance().setContactArray(contactList);
    }

    public static int getColorForPosition(Context context, int position) {
        if (position % 2 == 0) {
            return context.getColor(R.color.light_blue);
        } else {
            return context.getColor(R.color.light_gray);
        }
    }


    public static List<Contatto> getDataSourceItemList() {
        return MainSingleton.getInstance().getContactArray();
    }

    public static void addItem(Contatto contatto) {
        MainSingleton.getInstance().addItem(contatto);
    }

    public static void removeItem(int pos) {
        MainSingleton.getInstance().removeItem(pos);
    }

    public static void writeOnSharedPref(String number, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("preferiti",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Preferito", number);
        editor.commit();
    }

    public static String getFromSharedPref(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("preferiti", Context.MODE_PRIVATE);

        String preferito= sharedPref.getString("Preferito","");
        return preferito;
    }


}
