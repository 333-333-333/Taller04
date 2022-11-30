package view;

import controller.ControladorJugadores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIJugadores
        extends GUIFactory
        implements ActionListener {

    private JPanel Panel;

    private JTextField CampoNumero, CampoNombre, CampoPosicion;
    private JButton Guardar, Salir;
    private JComboBox ListaJugadores;
    private ControladorJugadores Controlador;

    public GUIJugadores(ControladorJugadores controlador) {
        super(800, 600);
        this.Controlador = controlador;
        crearBotones();
        crearPanel();
        cargarElementos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.Guardar)) {
        } else if (e.getSource().equals(this.Salir)) {

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
        this.Panel.add(this.Guardar);
        this.Panel.add(this.Salir);

        //this.add(this.ListaSelecciones);
    }

    @Override
    protected void crearBotones() {
        this.Guardar = new JButton("Jugadores");
        this.Guardar.setBounds(200, 500, 150, 50);
        this.Guardar.addActionListener(this);

        this.Salir = new JButton("Salir");
        this.Salir.setBounds(400, 500, 150, 50);
        this.Guardar.addActionListener(this);
    }

    @Override
    protected void crearLabels() {
    }

    @Override
    protected void crearComboBox() {

    }

}
