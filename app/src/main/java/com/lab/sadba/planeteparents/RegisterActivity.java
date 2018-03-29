package com.lab.sadba.planeteparents;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lab.sadba.planeteparents.data.model.Register;

import java.util.Objects;

import io.realm.Realm;

import static com.lab.sadba.planeteparents.MainActivity.PREFS_NAME;

public class RegisterActivity extends AppCompatActivity {

    Realm realm;
    private Register register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Realm.init(this);
        realm = Realm.getDefaultInstance();


        final EditText ienStock = findViewById(R.id.register_ien);
        final EditText password = findViewById(R.id.register_password);
        final EditText cpassword = findViewById(R.id.confirm_password);
        Button signup = (Button) findViewById(R.id.btn_verif);
/*
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        if (sharedPreferences.contains("ien_Parent")){
            ienStock.setText(String.valueOf(sharedPreferences.getInt()));
        }*/

        String ien = getIntent().getStringExtra("ien_parent");
        Toast.makeText(getApplicationContext(), ien, Toast.LENGTH_LONG).show();


        ienStock.setText(ien, TextView.BufferType.EDITABLE);


        signup.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                String verif_password = password.getText().toString();
                String c_password = cpassword.getText().toString();

                if (Objects.equals(verif_password, c_password)){
                    try{
                        register= new Register();
                        realm.beginTransaction();
                        register.setIen(ienStock.getText().toString());
                        register.setPassword(password.getText().toString());
                        realm.copyToRealmOrUpdate(register);
                        realm.commitTransaction();
                        Toast.makeText(getApplicationContext(), "Insertion reussi", Toast.LENGTH_LONG).show();

                    } catch (Exception e){
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Les mots de passent different", Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}
