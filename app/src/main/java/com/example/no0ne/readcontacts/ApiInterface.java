package com.example.no0ne.readcontacts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by no0ne on 1/22/18.
 */

public interface ApiInterface {

    @GET("ContactsApp/readContacts.php") // End point of the base url
    Call<List<Contacts>> getContacts(); // This method is used for making an API call
}
