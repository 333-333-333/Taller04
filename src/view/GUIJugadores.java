package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIJugadores extends GUIFactory implements ActionListener {

    private JLabel EscogerSeleccion, RankingFIFA, Imagen;
    private JButton Jugadores, Salir;
    private JPanel PanelLista;
    private JScrollPane PanelScroll;

    public GUIJugadores() {
        super(800, 600);
    }

    @Override
    protected void crearBotones() {

    }


    protected void crearImagen() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
