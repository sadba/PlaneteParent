package com.lab.sadba.planeteparents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.lab.sadba.planeteparents.adapter.EnfantAdapter;
import com.lab.sadba.planeteparents.data.model.Enfant;
import com.lab.sadba.planeteparents.data.model.EnfantJson;
import com.lab.sadba.planeteparents.data.remote.APIService;
import com.lab.sadba.planeteparents.data.remote.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private EnfantAdapter adapter;
    private ArrayList<Enfant> enfants;
    private APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView =  findViewById(R.id.recyclerView);

        final String ien = getIntent().getStringExtra("ien_parent");
        Toast.makeText(this, ien, Toast.LENGTH_SHORT).show();
        getEnfants(ien);





    }
    private void getEnfants(final String ien){
        apiService = ApiUtils.getAPIService().create(APIService.class);

        apiService.getEnfants(ien).enqueue(new Callback<EnfantJson>() {
            @Override
            public void onResponse(Call<EnfantJson> call, Response<EnfantJson> response) {
                if (response.code() == 200) {


                    int enfantsSize = response.body().getEnfants().length;
                    enfants = new ArrayList<Enfant>();
                    //Toast.makeText(HomeActivity.this, response.body().getCode(), Toast.LENGTH_SHORT).show();
                    for (int i =0; i<response.body().getEnfants().length; i++){

                        Enfant enfant = new Enfant();
                        enfant.setPrenom_eleve(response.body().getEnfants()[i].getPrenom_eleve());
                        enfant.setNom_eleve(response.body().getEnfants()[i].getNom_eleve());
                        enfant.setLibelle_niveau(response.body().getEnfants()[i].getLibelle_niveau());
                        enfants.add(enfant);


                    }


                    // adapter = new EnfantAdapter(enfants, R.layout.row_item, getApplicationContext());
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(new EnfantAdapter(enfants, getApplicationContext()));
                } else {
                    Toast.makeText(HomeActivity.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EnfantJson> call, Throwable t) {
                Toast.makeText(HomeActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });





    }

}
