package model;

import java.util.ArrayList;

public class Selección {

    private String Nombre, RutaImagen, RutaJugadores;
    private int Ranking;
    private ArrayList<Jugador> Jugadores;

    public Selección(String nombre,
                     int ranking,
                     String rutaImagen,
                     String rutaJugadores,
                     ArrayList<Jugador> jugadores){
        this.Nombre = nombre;
        this.Ranking = ranking;
        this.RutaImagen = rutaImagen;
        this.RutaJugadores = rutaJugadores;
        this.Jugadores = jugadores;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public String getRutaImagen() {
        return this.RutaImagen;
    }

    public String getRutaJugadores() {
        return this.RutaJugadores;
    }

    public int getRanking() {
        return this.Ranking;
    }

    public ArrayList<Jugador> getJugadores() {
        return this.Jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.Jugadores = jugadores;
    }
}
