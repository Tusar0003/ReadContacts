package com.example.no0ne.readcontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private RecyclerAdapter adapter;
    private ApiInterface apiInterface;
    private List<Contacts> contactsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("MainActivity", "onCreate is called!");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Contacts>> call = apiInterface.getContacts();
        Log.e("MainActivity", "Call<> is called!");

        call.enqueue(new Callback<List<Contacts>>() {
            @Override
            public void onResponse(Call<List<Contacts>> call, Response<List<Contacts>> response) {
                Log.e("MainActivity", "onResponse is called!");

                contactsList = response.body();
                adapter = new RecyclerAdapter(contactsList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Contacts>> call, Throwable t) {
                Log.e("MainActivity", "onFailure() is called!" + t.toString());
            }
        });
    }
}
