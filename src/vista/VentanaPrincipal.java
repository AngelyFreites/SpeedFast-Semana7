package vista;

import controlador.ControladorEntregas;
import controlador.ControladorPedidos;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private final ControladorPedidos controladorPedidos;
    private final ControladorEntregas controladorEntregas;

    public VentanaPrincipal(ControladorPedidos controladorPedidos,
                            ControladorEntregas controladorEntregas) {

        this.controladorPedidos = controladorPedidos;
        this.controladorEntregas = controladorEntregas;

        setTitle("SpeedFast - Gestión de Entregas");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnRegistrarPedido =
                new JButton("Registrar pedido");

        JButton btnListarPedidos =
                new JButton("Listar pedidos");

        JButton btnEntregas =
                new JButton("Repartidores / Iniciar entrega");

        JPanel panel = new JPanel(
                new GridLayout(3, 1, 10, 10)
        );

        panel.add(btnRegistrarPedido);
        panel.add(btnListarPedidos);
        panel.add(btnEntregas);

        add(panel, BorderLayout.CENTER);

        btnRegistrarPedido.addActionListener(e ->
                new VentanaRegistroPedido(
                        controladorPedidos
                ).setVisible(true)
        );

        btnListarPedidos.addActionListener(e ->
                new VentanaListaPedidos(
                        controladorPedidos
                ).setVisible(true)
        );

        btnEntregas.addActionListener(e ->
                new VentanaEntregas(
                        controladorEntregas
                ).setVisible(true)
        );
    }
}