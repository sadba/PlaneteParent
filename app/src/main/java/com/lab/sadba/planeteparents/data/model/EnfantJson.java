package com.lab.sadba.planeteparents.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sadba on 02-Apr-18.
 */

public class EnfantJson {


    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("enfants")
    @Expose
    private Enfant[] enfants;

    public EnfantJson() {
    }

    public EnfantJson(String code, String status, String message, Enfant[] enfants) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.enfants = enfants;
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

    public Enfant[] getEnfants() {
        return enfants;
    }

    public void setEnfants(Enfant[] enfants) {
        this.enfants = enfants;
    }
}
