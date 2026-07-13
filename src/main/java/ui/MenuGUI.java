package ui;

import javax.swing.JOptionPane;
import java.util.ArrayList;


class Direccion {
    String calle, ciudad;
    public Direccion(String calle, String ciudad) { this.calle = calle; this.ciudad = ciudad; }
    @Override public String toString() { return calle + ", " + ciudad; }
}

abstract class Persona {
    String rut, nombre;
    Direccion direccion;
    public Persona(String rut, String nombre, Direccion dir) { this.rut = rut; this.nombre = nombre; this.direccion = dir; }
}

class Cliente extends Persona {
    String tipoCliente;
    public Cliente(String r, String n, Direccion d, String tc) { super(r, n, d); this.tipoCliente = tc; }
    @Override public String toString() { return "[Cliente] RUT: " + rut + " | Nombre: " + nombre + " | Dir: " + direccion + " | Tipo: " + tipoCliente; }
}

class Trabajador extends Persona {
    String cargo;
    public Trabajador(String r, String n, Direccion d, String c) { super(r, n, d); this.cargo = c; }
    @Override public String toString() { return "[Trabajador] RUT: " + rut + " | Nombre: " + nombre + " | Dir: " + direccion + " | Cargo: " + cargo; }
}

class Proveedor extends Persona {
    String rubro;
    public Proveedor(String r, String n, Direccion d, String rb) { super(r, n, d); this.rubro = rb; }
    @Override public String toString() { return "[Proveedor] RUT: " + rut + " | Nombre: " + nombre + " | Dir: " + direccion + " | Rubro: " + rubro; }
}


class RutaTuristica {
    String destino; int dias;
    public RutaTuristica(String dest, int d) { this.destino = dest; this.dias = d; }
    @Override public String toString() { return "[Ruta] Destino: " + destino + " (" + dias + " días)"; }
}

class Paseo {
    String nombrePaseo; double precio;
    public Paseo(String np, double p) { this.nombrePaseo = np; this.precio = p; }
    @Override public String toString() { return "[Paseo] Nombre: " + nombrePaseo + " | Precio: $" + precio; }
}

class Excursion {
    String guia; boolean incluyeAlmuerzo;
    public Excursion(String g, boolean ia) { this.guia = g; this.incluyeAlmuerzo = ia; }
    @Override public String toString() { return "[Excursión] Guía: " + guia + " | Almuerzo: " + (incluyeAlmuerzo ? "Sí" : "No"); }
}


public class MenuGUI {
    // Listas globales simulando la capa de servicio para almacenamiento temporal
    private static ArrayList<Persona> personas = new ArrayList<>();
    private static ArrayList<RutaTuristica> rutas = new ArrayList<>();
    private static ArrayList<Paseo> paseos = new ArrayList<>();
    private static ArrayList<Excursion> excursiones = new ArrayList<>();

    public static void main(String[] args) {
        String[] opcionesPrincipales = {"Ingresar Datos", "Modificar Datos", "Mostrar Resumen", "Salir"};
        int seleccion;

        do {
            seleccion = JOptionPane.showOptionDialog(null,
                    "Seleccione una acción para el sistema Llanquihue Tour:",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opcionesPrincipales, opcionesPrincipales[0]);

            switch (seleccion) {
                case 0: menuIngreso(); break;
                case 1: menuModificacion(); break;
                case 2: mostrarResumen(); break;
            }
        } while (seleccion != 3 && seleccion != -1);
    }


    private static void menuIngreso() {
        String[] entidades = {"Cliente", "Trabajador", "Proveedor", "Ruta", "Paseo", "Excursión", "Volver"};
        int tipo = JOptionPane.showOptionDialog(null, "Elija el tipo de objeto a registrar:", "Ingresar Datos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, entidades, entidades[0]);

        if (tipo == 6 || tipo == -1) return;


        String rut = "", nombre = "", calle = "", ciudad = "";
        if (tipo >= 0 && tipo <= 2) {
            rut = JOptionPane.showInputDialog("Ingrese RUT:");
            nombre = JOptionPane.showInputDialog("Ingrese Nombre:");
            calle = JOptionPane.showInputDialog("Ingrese Calle:");
            ciudad = JOptionPane.showInputDialog("Ingrese Ciudad:");
        }

        switch (tipo) {
            case 0:
                String tc = JOptionPane.showInputDialog("Tipo de Cliente (Frecuente/Nuevo):");
                personas.add(new Cliente(rut, nombre, new Direccion(calle, ciudad), tc));
                break;
            case 1:
                String cargo = JOptionPane.showInputDialog("Cargo del Trabajador:");
                personas.add(new Trabajador(rut, nombre, new Direccion(calle, ciudad), cargo));
                break;
            case 2:
                String rubro = JOptionPane.showInputDialog("Rubro del Proveedor:");
                personas.add(new Proveedor(rut, nombre, new Direccion(calle, ciudad), rubro));
                break;
            case 3:
                String dest = JOptionPane.showInputDialog("Destino de la Ruta:");
                int dias = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de días:"));
                rutas.add(new RutaTuristica(dest, dias));
                break;
            case 4:
                String np = JOptionPane.showInputDialog("Nombre del Paseo:");
                double pr = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
                paseos.add(new Paseo(np, pr));
                break;
            case 5:
                String guia = JOptionPane.showInputDialog("Nombre del Guía:");
                int resp = JOptionPane.showConfirmDialog(null, "¿Incluye almuerzo?", "Excursión", JOptionPane.YES_NO_OPTION);
                excursiones.add(new Excursion(guia, resp == JOptionPane.YES_OPTION));
                break;
        }
        JOptionPane.showMessageDialog(null, "¡Registro guardado con éxito!");
    }


    private static void menuModificacion() {
        String[] opciones = {"Modificar Persona (RUT)", "Volver"};
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione opción de edición:", "Modificar Datos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == 0) {
            String buscarRut = JOptionPane.showInputDialog("Ingrese el RUT de la persona a modificar:");
            boolean encontrado = false;

            for (Persona p : personas) {
                if (p.rut.equals(buscarRut)) {
                    p.nombre = JOptionPane.showInputDialog("Nuevo Nombre:", p.nombre);
                    p.direccion.calle = JOptionPane.showInputDialog("Nueva Calle:", p.direccion.calle);
                    p.direccion.ciudad = JOptionPane.showInputDialog("Nueva Ciudad:", p.direccion.ciudad);

                    if (p instanceof Cliente) {
                        ((Cliente) p).tipoCliente = JOptionPane.showInputDialog("Nuevo Tipo Cliente:", ((Cliente) p).tipoCliente);
                    } else if (p instanceof Trabajador) {
                        ((Trabajador) p).cargo = JOptionPane.showInputDialog("Nuevo Cargo:", ((Trabajador) p).cargo);
                    } else if (p instanceof Proveedor) {
                        ((Proveedor) p).rubro = JOptionPane.showInputDialog("Nuevo Rubro:", ((Proveedor) p).rubro);
                    }
                    encontrado = true;
                    JOptionPane.showMessageDialog(null, "¡Datos modificados exitosamente!");
                    break;
                }
            }
            if (!encontrado) JOptionPane.showMessageDialog(null, "Persona no encontrada.");
        }
    }


    private static void mostrarResumen() {
        StringBuilder sb = new StringBuilder("=== RESUMEN DE OBJETOS EN SISTEMA ===\n\n");

        sb.append("--- Personas ---\n");
        if (personas.isEmpty()) sb.append("No hay registros.\n");
        for (Persona p : personas) sb.append(p.toString()).append("\n");

        sb.append("\n--- Rutas Turísticas ---\n");
        if (rutas.isEmpty()) sb.append("No hay registros.\n");
        for (RutaTuristica r : rutas) sb.append(r.toString()).append("\n");

        sb.append("\n--- Paseos ---\n");
        if (paseos.isEmpty()) sb.append("No hay registros.\n");
        for (Paseo pas : paseos) sb.append(pas.toString()).append("\n");

        sb.append("\n--- Excursiones ---\n");
        if (excursiones.isEmpty()) sb.append("No hay registros.\n");
        for (Excursion e : excursiones) sb.append(e.toString()).append("\n");

        JOptionPane.showMessageDialog(null, sb.toString(), "Resumen General", JOptionPane.INFORMATION_MESSAGE);
    }
}
