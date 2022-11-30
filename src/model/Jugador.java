package model;

import java.util.ArrayList;

public class Jugador {

    private int Número;
    private String Nombre;
    private Posición Posición;


    public Jugador(int número,
                   String nombre,
                   Posición posición) {
        this.Número = número;
        this.Nombre = nombre;
        this.Posición = posición;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public int getNúmero() {
        return this.Número;
    }

    public void setNúmero(int número) {
        this.Número = número;
    }

    public Posición getPosición() {
        return this.Posición;
    }

    public void setPosición(Posición posición) {
        this.Posición = posición;
    }

}
