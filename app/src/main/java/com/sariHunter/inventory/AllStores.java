package com.sariHunter.inventory;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.sariHunter.inventory.Adapters.StoerAdapter;
import com.sariHunter.inventory.Classes.Store;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class AllStores extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_stores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //TODO: 3) create Store Adapter and set all stores from Firebase into it

        List<Store> stores = new ArrayList<>();


        for (int i = 0; i <1000 ; i++) {

            stores.add(new Store("Sari Store library","15/2/2019",50450.5));
            stores.add(new Store("Sari Store electronics","15/2/2019",50450.5));
            stores.add(new Store("Sari app development company","15/2/2019",50450.5));
            stores.add(new Store("Sari recycling factory","15/2/2019",17615451));


        }


        rv = findViewById(R.id.rvStore);


        StoerAdapter adapter = new StoerAdapter(stores,this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        //TODO: 4) go to add Stroe page to add new Store

        //TODO: 7) if a store is clicked user goes to ALL Products in that Store


    }
}
