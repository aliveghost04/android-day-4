package com.example.erick.remoteconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit vinRosa = new Retrofit.Builder()
                .baseUrl("http://vinrosa.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(
                        this, LinearLayoutManager.VERTICAL, false
                )
        );
        MyFruitService fruitService = vinRosa.create(MyFruitService.class);
        fruitService.getFruits().enqueue(new Callback<List<Fruit>>() {
            @Override
            public void onResponse(Call<List<Fruit>> call, Response<List<Fruit>> response) {
                recyclerView.setAdapter(new FruitRecyclerViewAdapter(MainActivity.this, response.body()));
            }

            @Override
            public void onFailure(Call<List<Fruit>> call, Throwable t) {

            }
        });
    }
}
