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

        MainSingleton.getInstance().setDbManager(new DbManager(context));
        Utility.getDbManager().open();


    }

    public static int getColorForPosition(Context context, int position) {
        if (position % 2 == 0) {
            return context.getColor(R.color.light_blue);
        } else {
            return context.getColor(R.color.light_gray);
        }
    }

    public static DbManager getDbManager() {
        return MainSingleton.getInstance().getDbManager();
    }


}
