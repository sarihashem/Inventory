package com.sariHunter.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStore extends AppCompatActivity {

    final String DATABASE_NAME = "stores";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_store);



        //TODO: 5) Add new Store using firebase

        //TODO: 6)create CRUD for stores to save read delete or update a store






    }

    @Override
    protected void onStart() {
        super.onStart();

        //user ID

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

        if(user == null)
            return;



        String uid = user.getUid();

        //reference to new item (node) in stores || used .push() for new item
        DatabaseReference stores = FirebaseDatabase.getInstance().getReference().child(DATABASE_NAME).child(uid).push();

        // to make new node Like new raw in DBSQL we use .push()


    }
}
