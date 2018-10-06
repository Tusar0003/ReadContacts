package com.example.no0ne.readcontacts;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by no0ne on 1/22/18.
 */

public class ApiClient {

    // 127.0.0.1
    // 10.0.2.2
    // 192.168.58.1
    public static final String BASE_URL = "http://192.168.0.102:80/Android/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient() {
        Log.e("ApiClient", "getApiClient() is called!");

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
