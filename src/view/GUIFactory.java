package view;

import javax.swing.*;

public abstract class GUIFactory extends JFrame {

    protected GUIFactory (int ancho, int largo) {
        establecerDimensiones(ancho, largo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void establecerDimensiones(int ancho, int largo) {
        this.setResizable(false);
        this.setSize(ancho, largo);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }

    protected abstract void cargarElementos();

    protected abstract void crearBotones();


    protected abstract void crearLabels();

    protected abstract void crearComboBox();


}
