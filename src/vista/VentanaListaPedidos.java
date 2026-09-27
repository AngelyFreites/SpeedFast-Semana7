package vista;

import controlador.ControladorPedidos;
import modelo.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaListaPedidos extends JFrame {

    private final ControladorPedidos controlador;
    private DefaultTableModel modeloTabla;

    public VentanaListaPedidos(ControladorPedidos controlador) {

        this.controlador = controlador;

        setTitle("Lista de Pedidos");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnas = {
                "ID",
                "Dirección",
                "Tipo",
                "Estado"
        };

        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tablaPedidos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaPedidos);

        JButton btnRefrescar = new JButton("Refrescar");

        JPanel panelInferior = new JPanel();
        panelInferior.add(btnRefrescar);

        add(scrollPane, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        btnRefrescar.addActionListener(e -> cargarPedidos());

        cargarPedidos();
    }

    private void cargarPedidos() {

        modeloTabla.setRowCount(0);

        for (Pedido pedido : controlador.listarPedidos()) {

            Object[] fila = {
                    pedido.getId(),
                    pedido.getDireccion(),
                    pedido.getTipo(),
                    pedido.getEstado()
            };

            modeloTabla.addRow(fila);
        }
    }
}