package com.sariHunter.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // go to next Registration and sign in activity or to main profile;
                Intent intent = new Intent(getApplication(), Signing.class);
                startActivity(intent);

            }
        },2000);
    }
}
