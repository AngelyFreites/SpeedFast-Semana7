package vista;

import controlador.ControladorEntregas;
import modelo.Repartidor;

import javax.swing.*;
import java.awt.*;

public class VentanaEntregas extends JFrame {

    private final ControladorEntregas controlador;

    private JTextField txtNombreRepartidor;
    private JTextField txtIdPedido;
    private JComboBox<Repartidor> cmbRepartidores;

    public VentanaEntregas(ControladorEntregas controlador) {

        this.controlador = controlador;

        setTitle("Gestión de Entregas");
        setSize(500, 320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtNombreRepartidor = new JTextField();
        txtIdPedido = new JTextField();
        cmbRepartidores = new JComboBox<>();

        JButton btnRegistrarRepartidor =
                new JButton("Registrar repartidor");

        JButton btnRegistrarEntrega =
                new JButton("Asignar repartidor / Iniciar entrega");

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Nombre del repartidor:"));
        panel.add(txtNombreRepartidor);

        panel.add(new JLabel(""));
        panel.add(btnRegistrarRepartidor);

        panel.add(new JLabel("ID del pedido:"));
        panel.add(txtIdPedido);

        panel.add(new JLabel("Repartidor:"));
        panel.add(cmbRepartidores);

        panel.add(new JLabel(""));
        panel.add(btnRegistrarEntrega);

        add(panel);

        btnRegistrarRepartidor.addActionListener(
                e -> registrarRepartidor()
        );

        btnRegistrarEntrega.addActionListener(
                e -> registrarEntrega()
        );

        cargarRepartidores();
    }

    private void registrarRepartidor() {

        String nombre = txtNombreRepartidor.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debes ingresar el nombre del repartidor.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (controlador.registrarRepartidor(nombre)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Repartidor registrado correctamente."
            );

            txtNombreRepartidor.setText("");
            cargarRepartidores();

        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo registrar el repartidor.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void cargarRepartidores() {

        cmbRepartidores.removeAllItems();

        for (Repartidor repartidor :
                controlador.listarRepartidores()) {

            cmbRepartidores.addItem(repartidor);
        }
    }

    private void registrarEntrega() {

        try {

            int idPedido =
                    Integer.parseInt(txtIdPedido.getText().trim());

            Repartidor repartidor =
                    (Repartidor) cmbRepartidores.getSelectedItem();

            if (repartidor == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "Debes seleccionar un repartidor.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            if (controlador.registrarEntrega(
                    idPedido,
                    repartidor.getId())) {

                JOptionPane.showMessageDialog(
                        this,
                        "Entrega registrada correctamente."
                );

                txtIdPedido.setText("");

            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "No se pudo registrar la entrega.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "El ID del pedido debe ser un número.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
