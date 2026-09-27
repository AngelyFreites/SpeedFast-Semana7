package vista;

import controlador.ControladorPedidos;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedido extends JFrame {

    private final ControladorPedidos controlador;
    private JTextField txtDireccion;
    private JComboBox<String> cmbTipo;

    public VentanaRegistroPedido(ControladorPedidos controlador) {

        this.controlador = controlador;

        setTitle("Registrar Pedido");
        setSize(400, 220);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblDireccion = new JLabel("Dirección:");
        JLabel lblTipo = new JLabel("Tipo:");

        txtDireccion = new JTextField();

        String[] tipos = {"COMIDA", "ENCOMIENDA", "EXPRESS"};
        cmbTipo = new JComboBox<>(tipos);

        JButton btnGuardar = new JButton("Guardar");

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(lblDireccion);
        panel.add(txtDireccion);

        panel.add(lblTipo);
        panel.add(cmbTipo);

        panel.add(new JLabel(""));
        panel.add(btnGuardar);

        add(panel);

        btnGuardar.addActionListener(e -> guardarPedido());
    }

    private void guardarPedido() {

        String direccion = txtDireccion.getText().trim();
        String tipo = cmbTipo.getSelectedItem().toString();

        if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debes ingresar una dirección.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        boolean guardado = controlador.registrarPedido(direccion, tipo);

        if (guardado) {

            JOptionPane.showMessageDialog(
                    this,
                    "Pedido registrado correctamente."
            );

            txtDireccion.setText("");
            cmbTipo.setSelectedIndex(0);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo registrar el pedido.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
