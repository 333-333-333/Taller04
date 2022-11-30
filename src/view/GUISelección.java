package view;

import controller.ControladorJugadores;
import controller.ControladorSelección;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISelección
        extends GUIFactory
        implements ActionListener {

    private JPanel Panel;
    private JLabel RankingFIFA, Imagen, TextoError;
    private JButton Jugadores, Salir;
    private JComboBox ListaSelecciones;
    private ControladorSelección Controlador;


    public GUISelección(ControladorSelección controlador) {
        super(800, 600);
        this.Controlador = controlador;
        crearPanel();
        crearBotones();
        crearLabels();
        cargarElementos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.Jugadores)) {
            this.Controlador.cambiarAGestorJugadores();
        } else if (e.getSource().equals(this.Salir)){
            this.dispose();
        }
    }

    protected void crearPanel() {
        this.Panel = new JPanel();
        this.Panel.setLayout(null);
        this.Panel.setBounds(0,0,800,600);
    }

    @Override
    protected void cargarElementos() {
        this.add(this.Panel);
        this.Panel.add(this.Jugadores);
        this.Panel.add(this.Salir);
        this.Panel.add(this.RankingFIFA);
        //this.add(this.ListaSelecciones);
    }

    @Override
    protected void crearBotones() {
        this.Jugadores = new JButton("Jugadores");
        this.Jugadores.setBounds(200, 500, 150, 50);
        this.Jugadores.addActionListener(this);

        this.Salir = new JButton("Salir");
        this.Salir.setBounds(400, 500, 150, 50);
        this.Salir.addActionListener(this);
    }

    @Override
    protected void crearLabels() {
        this.RankingFIFA = new JLabel("Ranking Fifa :");
        this.RankingFIFA.setBounds(100, 0, 600, 200);
    }

    @Override
    protected void crearComboBox() {

    }


}
