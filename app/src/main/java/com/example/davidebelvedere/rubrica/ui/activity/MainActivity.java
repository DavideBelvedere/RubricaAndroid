package com.example.davidebelvedere.rubrica.ui.activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.davidebelvedere.rubrica.R;
import com.example.davidebelvedere.rubrica.data.Contatto;
import com.example.davidebelvedere.rubrica.data.MainSingleton;
import com.example.davidebelvedere.rubrica.logic.DbManager;
import com.example.davidebelvedere.rubrica.logic.Utility;
import com.example.davidebelvedere.rubrica.ui.adapter.MyCursorAdapter;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {
    private MyCursorAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utility.initDataSource(this);

        customAdapter = new MyCursorAdapter(this, MainSingleton.getInstance().getDbManager().fetchAllContacts());
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(customAdapter);

        /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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
        });*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                Cursor c = (Cursor) customAdapter.getItem(position);
                intent.putExtra("nome", c.getString(c.getColumnIndexOrThrow(DbManager.KEY_NAME)));
                intent.putExtra("numero", c.getString(c.getColumnIndexOrThrow(DbManager.KEY_PHONE)));
                intent.putExtra("preferito", ""+c.getInt(c.getColumnIndexOrThrow(DbManager.KEY_FAVOURITE)));
                intent.putExtra("id", ""+c.getInt(c.getColumnIndexOrThrow(DbManager.KEY_CONTACTID)));


                startActivity(intent);

            }
        });
    }

    protected void onResume() {
        super.onResume();

        customAdapter.changeCursor(MainSingleton.getInstance().getDbManager().fetchAllContacts());
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MainSingleton.getInstance().getDbManager().close();
    }
}
