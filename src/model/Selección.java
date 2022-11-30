package model;

public class Selección {

    private String Nombre, RutaImagen;
    private int Ranking;

    public Selección(String nombre, String rutaImagen, int ranking) {
        this.Nombre = nombre;
        this.RutaImagen = rutaImagen;
        this.Ranking = ranking;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public String getRutaImagen() {
        return this.RutaImagen;
    }

    public int getRanking() {
        return this.Ranking;
    }

}
