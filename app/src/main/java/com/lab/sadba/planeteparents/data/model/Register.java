package com.lab.sadba.planeteparents.data.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by sadba on 29-Mar-18.
 */

public class Register extends RealmObject {

    @PrimaryKey
    private String ien;
    private String password;


    public String getIen() {
        return ien;
    }

    public void setIen(String ien) {
        this.ien = ien;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
