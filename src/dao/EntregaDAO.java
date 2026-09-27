package dao;

import modelo.Entrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EntregaDAO {

    public boolean guardar(Entrega entrega) {

        String sql = "INSERT INTO entrega " +
                "(id_pedido, id_repartidor, fecha, hora) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setInt(1, entrega.getIdPedido());
            statement.setInt(2, entrega.getIdRepartidor());
            statement.setDate(3, java.sql.Date.valueOf(entrega.getFecha()));
            statement.setTime(4, java.sql.Time.valueOf(entrega.getHora()));

            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al guardar la entrega: " + e.getMessage());
            return false;
        }
    }
}