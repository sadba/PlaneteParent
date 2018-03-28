package com.lab.sadba.planeteparents.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sadba on 28-Mar-18.
 */

public class VerifParent {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("resultats")
    @Expose
    private List<Resultat> resultats;

    public VerifParent() {
    }

    public VerifParent(String code, String status, String message, List<Resultat> resultats) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.resultats = resultats;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Resultat> getResultats() {
        return resultats;
    }

    public void setResultats(List<Resultat> resultats) {
        this.resultats = resultats;
    }
}
