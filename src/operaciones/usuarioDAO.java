/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import conexion.ConexionBD;
import java.sql.*;

public class usuarioDAO {
    Connection conn = ConexionBD.conectar();

    public void insertarUsuario(String nombre, String correo) {
        try {
            String sql = "INSERT INTO usuarios (nombre, correo) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.executeUpdate();
            System.out.println("Usuario insertado.");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public void listarUsuarios() {
        try {
            String sql = "SELECT * FROM usuarios";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   " | Nombre: " + rs.getString("nombre") +
                                   " | Correo: " + rs.getString("correo"));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }

    public void actualizarUsuario(int id, String nombre, String correo) {
        try {
            String sql = "UPDATE usuarios SET nombre = ?, correo = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Usuario actualizado.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminarUsuario(int id) {
        try {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuario eliminado.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}

