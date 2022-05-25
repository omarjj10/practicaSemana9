package com.example.practicasemana9.Adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicasemana9.R;
import com.example.practicasemana9.entites.Anime;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>{
    List<Anime> animes;
    public AnimeAdapter(List<Anime> animes){
        this.animes=animes;
    }
    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime,parent,false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder vh, int position) {
        View itemView = vh.itemView;
        Anime anime=animes.get(position);
        TextView tvTitulo = itemView.findViewById(R.id.tvTitulo);
        TextView tvDes = itemView.findViewById(R.id.tvDescripcion);
        tvTitulo.setText(anime.name);
        tvDes.setText(anime.descripcion);
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    class AnimeViewHolder extends RecyclerView.ViewHolder{

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
