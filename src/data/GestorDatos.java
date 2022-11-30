package data;

import model.Jugador;
import model.Posición;
import model.Selección;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class GestorDatos {

    public static void guardarJugadores(Selección selección) throws Exception {
        try {
            String rutaJugadores = selección.getRutaJugadores();
            String contenido = "";
            for (Jugador j : selección.getJugadores()) {
                contenido += j.toString() + "\n";
            }
            crearArchivo(rutaJugadores, contenido);
        } catch (Exception e) {
            throw new Exception("No se puede crear el archivo de jugadores");
        }
    }

    public static ArrayList<Selección> importarSelecciones()
            throws Exception {
        ArrayList<Selección> selecciones = new ArrayList<>();
        String archivo = "datos/teams.txt";
        try {
            String datosSelecciones = leerArchivo(archivo);
            String[] seleccionesRaw = datosSelecciones.split("\\r?\\n");
            for (String seleccionRaw : seleccionesRaw) {
                selecciones.add(importarSelección(seleccionRaw));
            }
            return selecciones;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
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
            String error = "Datos no corresponden al de una selección";
            throw new Exception(e.getMessage());
        }
    }

    public static ArrayList<Jugador> importarJugadores(String archivo)
            throws Exception {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        try {
            String datosJugadores = leerArchivo(archivo);
            String[] jugadoresRaw = datosJugadores.split("\n");
            for (String jugadorRaw : jugadoresRaw) {
                System.out.println(jugadorRaw);
                jugadores.add(importarJugador(jugadorRaw));
            }
            return jugadores;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Jugador importarJugador(String jugadorRaw) throws Exception {
        try {
            String[] datosJugador = jugadorRaw.split(";");
            String numeroStr = datosJugador[0];
            int numero = Integer.parseInt(numeroStr);
            String nombre = datosJugador[1];
            Posición posición = mapearPosicion(datosJugador[2]);

            return new Jugador(numero, nombre, posición);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Posición mapearPosicion(String tag) throws Exception {
        for (Posición posición : Posición.values()) {
            if (Objects.equals(posición.getTag(), tag)) {
                return posición;
            }
        }
        throw new Exception("La tag no corresponde a la de una posición");
    }

    public static String leerArchivo(String ruta) throws IOException {
        Path archivo = Paths.get(ruta);
        String texto = "";

        texto = new String(Files.readAllBytes(archivo));

        return texto;
    }

    public static void crearArchivo(String archivo, String contenido)
            throws Exception {
        try {
            Path rutaArchivo = Paths.get(archivo);
            Files.write(rutaArchivo, contenido.getBytes());
        } catch (IOException e) {
            throw new IOException("No se puede crear el archivo");
        }
    }
    

}
