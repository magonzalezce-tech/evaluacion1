package app;

import model.Direccion;
import model.Persona;
import model.Empleado;
import model.Proveedor;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=======================================================");
        System.out.println("   SISTEMA DE GESTIÓN CENTRALIZADO - LLANQUIHUE TOUR ");
        System.out.println("=======================================================");


        ArrayList<Persona> listaPersonas = new ArrayList<>();


        Direccion dir1 = new Direccion("Av. Vicente Pérez Rosales", "450", "Puerto Varas");
        Direccion dir2 = new Direccion("Calle San Pedro", "1025", "Llanquihue");
        Direccion dir3 = new Direccion("Costanera", "101", "Frutillar");


        listaPersonas.add(new Persona("11.111.111-1", "María Ortega", "maria@email.com", dir1));


        listaPersonas.add(new Empleado("22.222.222-2", "Carlos Pérez", "carlos@llanquihuetour.cl", dir2, "Guía de Turismo", 850000));


        listaPersonas.add(new Proveedor("76.543.210-K", "Transporte Marítimo Lago", "contacto@lago.cl", dir3, "Transporte", "Rupert Allen"));


        System.out.println("\n[REGISTROS EN EL SISTEMA]");
        for (Persona p : listaPersonas) {
            System.out.println("- " + p);
        }


        System.out.println("\n=====================================");
        System.out.println("            FILTRADO DE ROLES         ");
        System.out.println("=====================================");

        System.out.println("\n--> COLABORADORES INTERNOS (EMPLEADOS):");
        for (Persona p : listaPersonas) {
            if (p instanceof Empleado) {
                System.out.println("    * " + p.getNombre() + " | Rol: " + ((Empleado) p).getRol() + ")");
            }
        }

        System.out.println("\n--> SOCIOS COMERCIALES (PROVEEDORES):");
        for (Persona p : listaPersonas) {
            if (p instanceof Proveedor) {
                System.out.println("    * Empresa: " + p.getNombre() + " | Contacto: " + ((Proveedor) p).getNombreContacto());
            }
        }

        System.out.println("\n--> CLIENTES REGISTRADOS:");
        for (Persona p : listaPersonas) {
            // Si es una Persona pura (no es Empleado ni Proveedor)
            if (!(p instanceof Empleado) && !(p instanceof Proveedor)) {
                System.out.println("    * " + p.getNombre() + " | Correo: " + p.getCorreo());
            }
        }
        System.out.println("=================================================");
    }
}