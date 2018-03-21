package com.example.no0ne.readcontacts;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

/**
 * Created by no0ne on 1/22/18.
 */

public class Contacts {

    @SerializedName("name")
    private String Name;

    @SerializedName("email")
    private String Email;

    public Contacts(String name, String email) {
        Log.e("Contacts", "Contacts() is called!");
        this.Name = name;
        this.Email = email;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }
}
