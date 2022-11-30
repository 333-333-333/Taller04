package controller;

import data.GestorDatos;
import model.Selección;
import view.GUIFactory;
import view.GUISelección;

import java.util.ArrayList;

public class ControladorSelección {

    private ArrayList<Selección> Selecciones;
    private Selección Modelo;
    private ControladorJugadores GestorJugadores;
    private GUISelección Vista;

    public ControladorSelección() {
        try {
            //this.Selecciones = GestorDatos.importarSelecciones();
            this.GestorJugadores = new ControladorJugadores(this);
            this.Vista = new GUISelección(this);
            this.Vista.setVisible(true);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void cambiarAGestorJugadores() {
        this.Vista.setVisible(false);
        this.GestorJugadores.iniciar();
    }
/*
    public ArrayList<String> obtenerNombresSelecciones() throws Exception {
        ArrayList<String> nombresSelecciones = new ArrayList<>();
        try {
            for (Selección selección : this.Selecciones) {
                nombresSelecciones.add(selección.getNombre());
            }
            return nombresSelecciones;
        } catch (Exception e) {
            throw new Exception("No se pueden importar las selecciones");
        }
    }
*/
}
