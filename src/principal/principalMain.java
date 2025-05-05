/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author User
 */

package principal;

import operaciones.usuarioDAO;
import java.util.Scanner;

public class principalMain {
    public static void main(String[] args) {
        usuarioDAO dao = new usuarioDAO();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ USUARIOS ---");
            System.out.println("1. Insertar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();
                    dao.insertarUsuario(nombre, correo);
                    break;
                case 2:
                    dao.listarUsuarios();
                    break;
                case 3:
                    System.out.print("ID a actualizar: ");
                    int idAct = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nuevo correo: ");
                    String nuevoCorreo = sc.nextLine();
                    dao.actualizarUsuario(idAct, nuevoNombre, nuevoCorreo);
                    break;
                case 4:
                    System.out.print("ID a eliminar: ");
                    int idDel = sc.nextInt();
                    dao.eliminarUsuario(idDel);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}


