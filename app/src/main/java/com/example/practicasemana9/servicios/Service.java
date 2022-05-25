package com.example.practicasemana9.servicios;

import com.example.practicasemana9.entites.Anime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/v3/6bb76d33-aee8-49ee-b140-4457fe1254c2")
    Call<List<Anime>> getAnime();
}
