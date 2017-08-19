package com.example.erick.remoteconnection;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Erick on 05/08/2017.
 */

public interface MyFruitService {
    @GET("example/practica.json")
    Call<List<Fruit>> getFruits();
}
