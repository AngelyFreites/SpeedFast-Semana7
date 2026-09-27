package controlador;

import dao.PedidoDAO;
import modelo.Pedido;

import java.util.List;

public class ControladorPedidos {

    private final PedidoDAO pedidoDAO;

    public ControladorPedidos() {
        this.pedidoDAO = new PedidoDAO();
    }

    public boolean registrarPedido(String direccion, String tipo) {

        Pedido pedido = new Pedido(
                direccion,
                tipo,
                "PENDIENTE"
        );

        return pedidoDAO.guardar(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoDAO.listarTodos();
    }
}