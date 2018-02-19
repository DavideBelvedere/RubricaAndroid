package com.example.davidebelvedere.rubrica.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.davidebelvedere.rubrica.R;
import com.example.davidebelvedere.rubrica.logic.Utility;
import com.example.davidebelvedere.rubrica.ui.adapter.CustomArrayAdapter;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {
    private CustomArrayAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utility.initDataSource(MainActivity.this);
        customAdapter = new CustomArrayAdapter(this, Utility.getDataSourceItemList(MainActivity.this));
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

                alertDialogBuilder.setTitle("Elimina contatto").setMessage("Sei sicuro di voler rimuovere questo contatto?").setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Utility.removeItem(position);
                        customAdapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();


            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        customAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

     @Override
     public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()) {
            case R.id.action_add: {
                Intent intent = new Intent(MainActivity.this, ContactDetailActivity.class);
                startActivity(intent);
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }
}
