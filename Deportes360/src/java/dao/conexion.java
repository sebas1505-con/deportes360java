package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/deportes_360";
    private static final String USER = "root";
    private static final String PASSWORD = "TU_CONTRASEÑA";  // cámbiala

    public Connection getConexion() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a MySQL");
        } catch (Exception e) {
            System.out.println("Error en conexión: " + e.getMessage());
        }

        return con;
    }
}
