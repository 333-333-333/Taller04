package model;

import java.util.ArrayList;

public class Jugador {

    private String Nombre;
    private int Número;
    private Posición Posición;
    private ArrayList<Jugador> Jugadores;

    public Jugador(String nombre,
                   int número,
                   Posición posición,
                   ArrayList<Jugador> jugadores) {
        this.Nombre = nombre;
        this.Número = número;
        this.Posición = posición;
        this.Jugadores = jugadores;
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

    public ArrayList<Jugador> getJugadores() {
        return this.Jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.Jugadores = jugadores;
    }
}
