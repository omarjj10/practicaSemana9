package com.example.practicasemana9.entites;

public class Anime {
    public int id;
    public String name;
    public String descripcion;

    public Anime() {
    }

    public Anime(String name, String descripcion) {
        this.name = name;
        this.descripcion = descripcion;
    }

    public Anime(int id, String name, String descripcion) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
    }
}
