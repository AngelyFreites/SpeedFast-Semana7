package main;

import controlador.ControladorEntregas;
import controlador.ControladorPedidos;
import vista.VentanaPrincipal;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ControladorPedidos controladorPedidos =
                    new ControladorPedidos();

            ControladorEntregas controladorEntregas =
                    new ControladorEntregas();

            VentanaPrincipal ventana =
                    new VentanaPrincipal(
                            controladorPedidos,
                            controladorEntregas
                    );

            ventana.setVisible(true);
        });
    }
}