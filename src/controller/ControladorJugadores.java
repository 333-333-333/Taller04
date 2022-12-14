package controller;

import model.Jugador;
import view.GUIJugadores;

import java.util.ArrayList;

public class ControladorJugadores {

    private ControladorSelecciÃ³n Padre;
    private GUIJugadores Vista;
    private Jugador Modelo;
    private ArrayList<Jugador> Jugadores;

    public ControladorJugadores(ControladorSelecciÃ³n padre) {
        this.Padre = padre;
        this.Vista = new GUIJugadores(this);
    }

    public void iniciar() {
        this.Vista.setVisible(true);
    }

}
