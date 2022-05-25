package com.example.practicasemana9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.practicasemana9.Adaptador.AnimeAdapter;
import com.example.practicasemana9.entites.Anime;
import com.example.practicasemana9.servicios.Service;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Anime> contacts=new ArrayList<>();
    ImageView cargarImagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);
        Call<List<Anime>> call=service.getAnime();
        call.enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {
                if(!response.isSuccessful()){
                    Log.e("APP_VJ20202","Error de aplicacion");
                }else{
                    Log.i("APP_VJ20202","Respuesta correcta");
                    Log.i("APP_VJ20202",new Gson().toJson(response.body()));
                    contacts=response.body();
                    AnimeAdapter adapter = new AnimeAdapter(contacts);
                    RecyclerView rv = findViewById(R.id.rvAnime);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv.setHasFixedSize(true);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Anime>> call, Throwable t) {
                Log.e("APP_VJ20202","No hubo conectividad con el servicio web");
            }
        });
        cargarImagen = findViewById(R.id.miImage);
        Picasso.get()
                .load("https://i.ibb.co/PWBq3ht/fairy-tail.png")
                .error(R.mipmap.ic_launcher_round)
                .into(cargarImagen);
    }
}