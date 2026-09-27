package main;

import dao.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {

    public static void main(String[] args) {

        try (Connection conexion = ConexionBD.obtenerConexion()) {

            if (conexion != null) {
                System.out.println("Conexión exitosa a speedfast_db.");
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            System.out.println(e.getMessage());
        }
    }
}