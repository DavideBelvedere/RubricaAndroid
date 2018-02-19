package com.example.davidebelvedere.rubrica.logic;

import android.content.Context;

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
        MainSingleton.getInstance().setContactArray(contactList);
    }

    public static int getColorForPosition(Context context, int position) {
        if (position % 2 == 0) {
            return context.getColor(R.color.light_blue);
        } else {
            return context.getColor(R.color.light_gray);
        }
    }


    public static  List <Contatto> getDataSourceItemList(Context context){
        return MainSingleton.getInstance().getContactArray();
    }

    public static void addItem(Contatto contatto){
        MainSingleton.getInstance().addItem(contatto);
    }

    public static void removeItem(int pos){
        MainSingleton.getInstance().removeItem(pos);
    }
}
