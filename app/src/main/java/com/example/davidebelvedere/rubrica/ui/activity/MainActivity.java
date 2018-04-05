package com.example.davidebelvedere.rubrica.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.example.davidebelvedere.rubrica.R;
import com.example.davidebelvedere.rubrica.logic.Utility;
import com.example.davidebelvedere.rubrica.ui.adapter.MyRecyclerAdapter;


public class MainActivity extends AppCompatActivity {
    private MyRecyclerAdapter customAdapter;
    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utility.initDataSource(MainActivity.this);
        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        customAdapter = new MyRecyclerAdapter(Utility.getDataSourceItemList(), this);
        myRecyclerView.setAdapter(customAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        customAdapter.updateData();
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
