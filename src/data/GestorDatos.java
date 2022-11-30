package data;

import model.Jugador;
import model.Posición;
import model.Selección;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GestorDatos {

    public static ArrayList<Selección> importarSelecciones(String archivo)
            throws Exception {
        ArrayList<Selección> selecciones = new ArrayList<>();
        try {
            String datosSelecciones = leerArchivo(archivo);
            String[] seleccionesRaw = datosSelecciones.split("\\r?\\n");
            for (String seleccionRaw : seleccionesRaw) {
                selecciones.add(importarSelección(seleccionRaw));
            }
            return selecciones;
        } catch (Exception e) {
            throw new Exception("No se pueden importar las selecciones");
        }
    }

    public static Selección importarSelección(String seleccionRaw) throws Exception {
        try {
            String[] datosSeleccion = seleccionRaw.split(";");
            String nombre = datosSeleccion[1];
            int ranking = Integer.parseInt(datosSeleccion[2]);
            String rutaImagen = "datos/" + datosSeleccion[3];
            String tagSeleccion = nombre.toLowerCase().substring(0, 3);
            String rutaJugadores = "datos/" + tagSeleccion + ".txt";
            ArrayList<Jugador> jugadores = importarJugadores(rutaJugadores);
            return new Selección(nombre,
                    ranking,
                    rutaImagen,
                    rutaJugadores,
                    jugadores);
        } catch (Exception e) {
            throw new Exception("Datos no corresponden al de una selección");
        }
    }

    public static ArrayList<Jugador> importarJugadores(String archivo)
            throws Exception {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        try {
            String datosJugadores = leerArchivo(archivo);
            String[] jugadoresRaw = datosJugadores.split("\\r?\\n");
            for (String jugadorRaw : jugadoresRaw) {
                jugadores.add(importarJugador(jugadorRaw));
            }
            return jugadores;
        } catch (Exception e) {
            throw new Exception("No se pueden importar los jugadores");
        }
    }

    public static Jugador importarJugador(String jugadorRaw) throws Exception {
        try {
            String[] datosJugador = jugadorRaw.split(";");
            int numero = Integer.parseInt(datosJugador[0]);
            String nombre = datosJugador[1];
            Posición posición = mapearPosicion(datosJugador[2]);
            return new Jugador(numero, nombre, posición);
        } catch (Exception e) {
            throw new Exception("Datos no corresponden al de un jugador");
        }
    }

    public static String leerArchivo(String ruta) throws Exception {
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
        } catch (IOException e) {
            throw new Exception("No se puede leer este archivo");
        }
        return texto;
    }

    public static Posición mapearPosicion(String tag) throws Exception {
        for (Posición posición : Posición.values()) {
            if (posición.getTag().equals(tag)) {
                return posición;
            }
        }
        throw new Exception("La tag no corresponde a la de una posición");
    }

}
