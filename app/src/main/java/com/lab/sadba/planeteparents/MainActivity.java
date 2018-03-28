package com.lab.sadba.planeteparents;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lab.sadba.planeteparents.data.model.VerifParent;
import com.lab.sadba.planeteparents.data.model.Resultat;
import com.lab.sadba.planeteparents.data.model.postuser;
import com.lab.sadba.planeteparents.data.remote.APIService;
import com.lab.sadba.planeteparents.data.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private APIService mAPIService;
    public static final String PREFS_NAME = "PREFS_NAME";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText cniEt =  findViewById(R.id.input_cni);
        final EditText ienEt =  findViewById(R.id.input_ien);
        Button submitBtn = (Button) findViewById(R.id.btn_verif);


        mAPIService = ApiUtils.getAPIService();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cni = cniEt.getText().toString().trim();
                String ien = ienEt.getText().toString().trim();
                if (!TextUtils.isEmpty(cni) && !TextUtils.isEmpty(ien)) {
                    sendPost(cni,ien);
                }
            }
        });
    }

    public void sendPost(String cni,String ien){

        postuser user = new postuser();
        user.setCni(cni);
        user.setIen(ien);
        mAPIService.saveUser(user).enqueue(new Callback<VerifParent>() {
            @Override
            public void onResponse(Call<VerifParent> call, Response<VerifParent> response) {
                if (response.isSuccessful()){
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    intent.putExtra("ien_parent", response.body().getResultats().get(0).getIen_parent());
                    startActivity(intent);

                  /*  SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("ien_Parent", response.body().getResultats().get(0).getIen_parent());
                    editor.apply();*/

                }
            }

            @Override
            public void onFailure(Call<VerifParent> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }



}
