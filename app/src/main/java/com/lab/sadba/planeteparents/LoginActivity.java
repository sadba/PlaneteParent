package com.lab.sadba.planeteparents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lab.sadba.planeteparents.data.model.Login;
import com.lab.sadba.planeteparents.data.model.Register;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity {

    Realm realm;
    private Register register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Realm.init(this);
        realm = Realm.getDefaultInstance();

        try {
        } catch (Exception e) {
            e.printStackTrace();
        }



        final EditText ienLogin = findViewById(R.id.login_ien);
        final EditText passwordLogin = findViewById(R.id.login_password);
        Button login = (Button) findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Login login1 = new Login();

                String ien = ienLogin.getText().toString().trim();
                String pwd = passwordLogin.getText().toString().trim();
                    Register registers = realm.where(Register.class).findFirst();
                    Register register = new Register();
                    //Toast.makeText(getApplicationContext(), registers.getPassword(), Toast.LENGTH_LONG).show();
                if (ien.equals(registers.getIen()) && pwd.equals(registers.getPassword())) {
                    //Toast.makeText(getApplicationContext(), "login reussi", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }
                }
            });
        }
    }

    /*public void sendLogin(String ien, String pwd){



}*/

