package ui;

import java.util.ArrayList;
import java.util.Scanner;
import data.GestorServicios;
import model.*;

public class Main {
    private static ArrayList<ServicioTuristico> listaServicios = GestorServicios.obtenerServiciosDePrueba();
    private static ArrayList<Persona> listaPersonas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int op = 0;
        inicializarDatos();

        do {
            System.out.println("\n=== MENÚ PRINCIPAL LLANQUIHUE TOUR ===");
            System.out.println("1. Administrar Personas (Clientes, Trabajadores, Proveedores)");
            System.out.println("2. Administrar Servicios Turísticos (Rutas, Paseos, Excursiones)");
            System.out.println("3. Salir");
            System.out.print("Seleccione: ");
            if (teclado.hasNextInt()) {
                op = teclado.nextInt(); teclado.nextLine();
                if (op == 1) menuCRUD(teclado, true);
                else if (op == 2) menuCRUD(teclado, false);
            } else {
                System.out.println("❌ Ingrese un número válido.");
                teclado.nextLine();
            }
        } while (op != 3);

        System.out.println("👋 ¡Sesión cerrada con éxito!");
        teclado.close();
    }

    private static void menuCRUD(Scanner teclado, boolean esPersona) {
        int op = 0;
        do {
            System.out.println("\n--- GESTIÓN DE " + (esPersona ? "PERSONAS" : "SERVICIOS") + " ---");
            System.out.println("1. Mostrar lista\n2. Agregar\n3. Modificar \n4. Eliminar\n5. Volver");
            System.out.print("Seleccione: ");
            if (teclado.hasNextInt()) {
                op = teclado.nextInt(); teclado.nextLine();
                if (op == 1) mostrar(esPersona);
                else if (op == 2) agregar(teclado, esPersona);
                else if (op == 3) modificar(teclado, esPersona);
                else if (op == 4) eliminar(teclado, esPersona);
            } else {
                System.out.println("❌ Opción inválida.");
                teclado.nextLine();
            }
        } while (op != 5);
    }

    private static void mostrar(boolean esPersona) {
        System.out.println("\n--- LISTADO REGISTRADO ---");
        int tamano = esPersona ? listaPersonas.size() : listaServicios.size();
        if (tamano == 0) { System.out.println("No hay registros en esta sección."); return; }

        for (int i = 0; i < tamano; i++) {
            Object obj = esPersona ? listaPersonas.get(i) : listaServicios.get(i);
            System.out.println("[" + (i + 1) + "] " + obj.toString());
        }
    }

    private static void agregar(Scanner teclado, boolean esPersona) {
        if (esPersona) {
            System.out.println("\nTipo: 1. Cliente | 2. Trabajador/Empleado | 3. Proveedor");
            int t = teclado.nextInt(); teclado.nextLine();
            System.out.print("RUT: "); String r = teclado.nextLine();
            System.out.print("Nombre: "); String n = teclado.nextLine();
            System.out.print("Correo: "); String c = teclado.nextLine();

            if (t == 1) {
                listaPersonas.add(new Persona(r, n, c));
            } else if (t == 2) {
                System.out.print("Rol/Puesto: "); String rol = teclado.nextLine();
                System.out.print("Sueldo Base: "); double s = teclado.nextDouble(); teclado.nextLine();
                listaPersonas.add(new Empleado(r, n, c, rol, s));
            } else if (t == 3) {
                System.out.print("Tipo de Servicio Comercial: "); String ser = teclado.nextLine();
                System.out.print("Nombre de Contacto: "); String con = teclado.nextLine();
                listaPersonas.add(new Proveedor(r, n, c, ser, con));
            }
        } else {
            System.out.println("\nTipo: 1. Gastronomía | 2. Lacustre | 3. Cultural");
            int t = teclado.nextInt(); teclado.nextLine();
            System.out.print("Nombre del Servicio: "); String n = teclado.nextLine();
            System.out.print("Duración (hrs): "); int d = teclado.nextInt(); teclado.nextLine();

            if (t == 1) {
                System.out.print("Número de paradas: "); int p = teclado.nextInt(); teclado.nextLine();
                listaServicios.add(new RutaGastronomica(n, d, p));
            } else if (t == 2) {
                System.out.print("Tipo de Embarcación: "); String e = teclado.nextLine();
                listaServicios.add(new PaseoLacustre(n, d, e));
            } else if (t == 3) {
                System.out.print("Lugar Histórico: "); String l = teclado.nextLine();
                listaServicios.add(new ExcursionCultural(n, d, l));
            }
        }
        System.out.println("✅ Registro creado exitosamente.");
    }


    private static void modificar(Scanner teclado, boolean esPersona) {
        mostrar(esPersona);
        int max = esPersona ? listaPersonas.size() : listaServicios.size();
        if (max == 0) return;

        System.out.print("Número del elemento a modificar: ");
        int ind = teclado.nextInt() - 1; teclado.nextLine();

        if (ind < 0 || ind >= max) { System.out.println("❌ Índice fuera de rango."); return; }

        System.out.println("👉 (Presione ENTER directo para mantener el valor actual del campo)");

        if (esPersona) {
            Persona p = listaPersonas.get(ind);


            System.out.print("Nuevo RUT (Actual: " + p.getRut() + "): ");
            String nuevoRut = teclado.nextLine();
            if (!nuevoRut.trim().isEmpty()) p.setRut(nuevoRut);

            System.out.print("Nuevo Nombre/Empresa (Actual: " + p.getNombre() + "): ");
            String nuevoNom = teclado.nextLine();
            if (!nuevoNom.trim().isEmpty()) p.setNombre(nuevoNom);

            System.out.print("Nuevo Correo (Actual: " + p.getCorreo() + "): ");
            String nuevoCor = teclado.nextLine();
            if (!nuevoCor.trim().isEmpty()) p.setCorreo(nuevoCor);

            System.out.print("Nueva Dirección (Actual: " + p.getDireccion() + "): ");
            String nuevaDir = teclado.nextLine();
            if (!nuevaDir.trim().isEmpty()) p.setDireccion(nuevaDir);


            if (p instanceof Empleado) {
                Empleado emp = (Empleado) p;
                System.out.print("Nuevo Rol/Puesto (Actual: " + emp.getRol() + "): ");
                String nuevoRol = teclado.nextLine();
                if (!nuevoRol.trim().isEmpty()) emp.setRol(nuevoRol);
            } else if (p instanceof Proveedor) {
                Proveedor prov = (Proveedor) p;
                System.out.print("Nuevo Servicio Ofrecido (Actual: " + prov.getServicio() + "): ");
                String nuevoSer = teclado.nextLine();
                if (!nuevoSer.trim().isEmpty()) prov.setServicio(nuevoSer);

                System.out.print("Nuevo Nombre de Contacto (Actual: " + prov.getNombreContacto() + "): ");
                String nuevoCon = teclado.nextLine();
                if (!nuevoCon.trim().isEmpty()) prov.setNombreContacto(nuevoCon);
            }
        } else {
            ServicioTuristico s = listaServicios.get(ind);


            System.out.print("Nuevo Nombre Servicio (Actual: " + s.getNombre() + "): ");
            String nuevoNom = teclado.nextLine();
            if (!nuevoNom.trim().isEmpty()) s.setNombre(nuevoNom);

            System.out.print("Nueva Duración Horas (Actual: " + s.getDuracionHoras() + " hrs): ");
            String nuevaDurStr = teclado.nextLine();
            if (!nuevaDurStr.trim().isEmpty()) s.setDuracionHoras(Integer.parseInt(nuevaDurStr));


            if (s instanceof RutaGastronomica) {
                RutaGastronomica ruta = (RutaGastronomica) s;
                System.out.print("Nuevo Número de Paradas (Actual: " + ruta.getNumeroDeParadas() + "): ");
                String nuevasParStr = teclado.nextLine();
                if (!nuevasParStr.trim().isEmpty()) ruta.setNumeroDeParadas(Integer.parseInt(nuevasParStr));
            } else if (s instanceof PaseoLacustre) {
                PaseoLacustre paseo = (PaseoLacustre) s;
                System.out.print("Nuevo Tipo Embarcación (Actual: " + paseo.getTipoEmbarcacion() + "): ");
                String nuevaEmb = teclado.nextLine();
                if (!nuevaEmb.trim().isEmpty()) paseo.setTipoEmbarcacion(nuevaEmb);
            } else if (s instanceof ExcursionCultural) {
                ExcursionCultural exc = (ExcursionCultural) s;
                System.out.print("Nuevo Lugar Histórico (Actual: " + exc.getLugarHistorico() + "): ");
                String nuevoLug = teclado.nextLine();
                if (!nuevoLug.trim().isEmpty()) exc.setLugarHistorico(nuevoLug);
            }
        }
        System.out.println("✅ Modificación estructural completada con éxito.");
    }

    private static void eliminar(Scanner teclado, boolean esPersona) {
        mostrar(esPersona);
        int max = esPersona ? listaPersonas.size() : listaServicios.size();
        if (max == 0) return;

        System.out.print("Número del elemento a eliminar: ");
        int ind = teclado.nextInt() - 1; teclado.nextLine();

        if (ind >= 0 && ind < max) {
            if (esPersona) listaPersonas.remove(ind);
            else listaServicios.remove(ind);
            System.out.println("🗑️ Registro removido de la memoria dinámica.");
        } else {
            System.out.println("❌ Índice incorrecto.");
        }
    }

    private static void inicializarDatos() {
        listaPersonas.add(new Persona("11.111.111-1", "María Ortega (Cliente)", "maria@email.com"));
        listaPersonas.add(new Empleado("22.222.222-2", "Carlos Pérez", "carlos@llanquihuetour.cl", "Guía", 850000.0));
        listaPersonas.add(new Proveedor("76.543.210-K", "Transporte Marítimo S.A.", "contacto@lago.cl", "Botes", "Rupert Allen"));
    }
}
