/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ConexionBD {
    public static Connection conectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/appvento";
            String user = "root";
            String password = "1234567890"; // cambia según tu configuración
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa.");
            return conn;
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }
}
