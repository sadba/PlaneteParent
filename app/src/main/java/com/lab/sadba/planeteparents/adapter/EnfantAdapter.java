package com.lab.sadba.planeteparents.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lab.sadba.planeteparents.R;
import com.lab.sadba.planeteparents.data.model.Enfant;

import java.util.List;

/**
 * Created by sadba on 02-Apr-18.
 */

public class EnfantAdapter extends RecyclerView.Adapter<EnfantAdapter.MyViewHolder> {

    private List<Enfant> enfants;
    private Context context;
    public EnfantAdapter(List<Enfant> enfants,  Context context){
        this.enfants = enfants;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.PRENOM.setText(enfants.get(position).getPrenom_eleve());
        holder.NOM.setText(enfants.get(position).getNom_eleve());
        holder.CLASSE.setText(enfants.get(position).getLibelle_niveau());

    }

    @Override
    public int getItemCount() {
        return enfants.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView PRENOM,NOM, CLASSE;
        public MyViewHolder(View itemView) {
            super(itemView);
            PRENOM = (TextView)itemView.findViewById(R.id.enfant_prenom);
            NOM = (TextView)itemView.findViewById(R.id.enfant_nom);
            CLASSE = (TextView)itemView.findViewById(R.id.enfant_classe);
        }
    }


}
