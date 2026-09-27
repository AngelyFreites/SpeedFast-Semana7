package controlador;

import dao.EntregaDAO;
import dao.PedidoDAO;
import dao.RepartidorDAO;
import modelo.Entrega;
import modelo.Repartidor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ControladorEntregas {

    private final RepartidorDAO repartidorDAO;
    private final EntregaDAO entregaDAO;
    private final PedidoDAO pedidoDAO;

    public ControladorEntregas() {
        this.repartidorDAO = new RepartidorDAO();
        this.entregaDAO = new EntregaDAO();
        this.pedidoDAO = new PedidoDAO();
    }

    public boolean registrarRepartidor(String nombre) {

        Repartidor repartidor = new Repartidor(nombre);
        return repartidorDAO.guardar(repartidor);
    }

    public List<Repartidor> listarRepartidores() {
        return repartidorDAO.listarTodos();
    }

    public boolean registrarEntrega(int idPedido, int idRepartidor) {

        Entrega entrega = new Entrega(
                idPedido,
                idRepartidor,
                LocalDate.now(),
                LocalTime.now()
        );

        boolean guardada = entregaDAO.guardar(entrega);

        if (guardada) {
            pedidoDAO.actualizarEstado(idPedido, "EN_REPARTO");
        }

        return guardada;
    }
}