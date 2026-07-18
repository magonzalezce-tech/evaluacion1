package model;

public class Empleado extends Persona implements Registrable {
    private String rol;
    private double sueldo;

    public Empleado(String rut, String nombre, String email, Direccion direccion, String rol, double sueldo) {
        super(rut, nombre, email, direccion);
        this.rol = rol;
        this.sueldo = sueldo;
    }

    public String getRol() { return rol; }

    @Override
    public String mostrarResumen() {
        return "";
    }

    @Override
    public void registrar() {
        System.out.println("[AUDITORÍA] Alta procesada para el empleado: " + getNombre() + " en el rol de " + rol);
    }

    @Override
    public String mostrarDatos() {
        return "[EMPLEADO] " + super.toString() + " | Cargo: " + rol + " | Sueldo: $" + sueldo;
    }

    @Override
    public String toString() {
        return mostrarDatos();
    }
}