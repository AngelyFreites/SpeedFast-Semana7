package main;

import dao.PedidoDAO;
import modelo.Pedido;

public class PruebaPedidoDAO {

    public static void main(String[] args) {

        Pedido pedido = new Pedido(
                "Av. Valparaíso 123",
                "COMIDA",
                "PENDIENTE"
        );

        PedidoDAO pedidoDAO = new PedidoDAO();

        if (pedidoDAO.guardar(pedido)) {
            System.out.println("Pedido guardado correctamente en MySQL.");
        } else {
            System.out.println("No se pudo guardar el pedido.");
        }
    }
}