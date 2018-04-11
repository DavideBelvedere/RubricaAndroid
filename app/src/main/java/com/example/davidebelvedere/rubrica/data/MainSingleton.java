package com.example.davidebelvedere.rubrica.data;

import com.example.davidebelvedere.rubrica.logic.DbManager;
import com.example.davidebelvedere.rubrica.ui.activity.MainActivity;

import java.util.List;

/**
 * Created by davidebelvedere on 15/02/18.
 */

public class MainSingleton {
    //private static List<Contatto> CONTACTS;
    private static DbManager dbManager;
    private static MainSingleton mySingleton = new MainSingleton();

    private MainSingleton() {

    }

    public static MainSingleton getInstance() {
        return mySingleton;
    }


    public DbManager getDbManager() {
        return dbManager;
    }

    public void setDbManager(DbManager dbManager) {
        MainSingleton.dbManager = dbManager;
    }
}
