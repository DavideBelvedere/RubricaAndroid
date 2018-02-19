package com.example.davidebelvedere.rubrica.data;

import java.util.List;

/**
 * Created by davidebelvedere on 15/02/18.
 */

public class MainSingleton {
    private static List<Contatto> CONTACTS;
    private static MainSingleton mySingleton = new MainSingleton();

    private MainSingleton() {

    }

    public static MainSingleton getInstance() {
        return mySingleton;
    }

    public  List<Contatto> getContactArray() {
        return CONTACTS;
    }

    public  void setContactArray(List<Contatto> array) {
        CONTACTS = array;
    }

    public void addItem(Contatto newContact){
        CONTACTS.add(newContact);
    }

    public void removeItem(int position){
        CONTACTS.remove(position);
    }
}
