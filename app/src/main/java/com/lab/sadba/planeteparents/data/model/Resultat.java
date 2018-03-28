package com.lab.sadba.planeteparents.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sadba on 28-Mar-18.
 */

public class Resultat {


    @SerializedName("ien_parent")
    @Expose
    String ien_parent;
    @SerializedName("prenom_parent")
    @Expose
    String prenom_parent;
    @SerializedName("nom_parent")
    @Expose
    String nom_parent;
    @SerializedName("type_affiliation")
    @Expose
    String type_affiliation;


    public Resultat() {
    }

    public Resultat(String ien_parent, String prenom_parent, String nom_parent, String type_affiliation) {
        this.ien_parent = ien_parent;
        this.prenom_parent = prenom_parent;
        this.nom_parent = nom_parent;
        this.type_affiliation = type_affiliation;
    }

    public String getIen_parent() {
        return ien_parent;
    }

    public void setIen_parent(String ien_parent) {
        this.ien_parent = ien_parent;
    }

    public String getPrenom_parent() {
        return prenom_parent;
    }

    public void setPrenom_parent(String prenom_parent) {
        this.prenom_parent = prenom_parent;
    }

    public String getNom_parent() {
        return nom_parent;
    }

    public void setNom_parent(String nom_parent) {
        this.nom_parent = nom_parent;
    }

    public String getType_affiliation() {
        return type_affiliation;
    }

    public void setType_affiliation(String type_affiliation) {
        this.type_affiliation = type_affiliation;
    }
}
