package app;

import servicio.Gestion;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Gestion servicio = new Gestion();
        Scanner scanner = new Scanner(System.in);


            System.out.println("=================================================");
            System.out.println("   SISTEMA DE GESTIÓN CENTRALIZADO - LLANQUIHUE  ");
            System.out.println("=================================================");
            servicio.cargarDatosDesdeArchivo("personas.txt");

        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ DE CONTROL ---");
            System.out.println("1. Mostrar todos los registros");
            System.out.println("2. Buscar registro por nombre");
            System.out.println("3. Salir del sistema");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- LISTADO GENERAL ---");
                        servicio.mostrarTodos();
                        break;
                    case 2:
                        System.out.print("\nIngrese el nombre a consultar: ");
                        String busqueda = scanner.nextLine();
                        servicio.buscarPorNombre(busqueda);
                        break;
                    case 3:
                        System.out.println("Saliendo y cerrando módulos de forma segura...");
                        break;
                    default:
                        System.out.println("❌ Opción inválida. Ingrese un valor de 1 a 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Ingrese exclusivamente un número entero.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}

