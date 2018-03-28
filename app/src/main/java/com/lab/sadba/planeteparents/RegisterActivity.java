package com.lab.sadba.planeteparents;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.lab.sadba.planeteparents.MainActivity.PREFS_NAME;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText ienStock = findViewById(R.id.register_ien);
/*
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        if (sharedPreferences.contains("ien_Parent")){
            ienStock.setText(String.valueOf(sharedPreferences.getInt()));
        }*/

        String ien = getIntent().getStringExtra("ien_parent");
        Toast.makeText(getApplicationContext(), ien, Toast.LENGTH_LONG).show();


        ienStock.setText(ien, TextView.BufferType.EDITABLE);

    }
}
