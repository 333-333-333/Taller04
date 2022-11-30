package controller;

import model.Jugador;
import view.GUIJugadores;

import java.util.ArrayList;

public class ControladorJugadores {

    private ControladorSelección Padre;
    private GUIJugadores Vista;
    private Jugador Modelo;
    private ArrayList<Jugador> Jugadores;

    public ControladorJugadores(ControladorSelección padre) {
        this.Padre = padre;
        this.Vista = new GUIJugadores(this);
    }

    public void iniciar() {
        this.Vista.setVisible(true);
    }

}
