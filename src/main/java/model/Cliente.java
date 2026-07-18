package model;

public class Cliente extends Persona implements Registrable {
    private String nivelFidelidad;

    public Cliente(String rut, String nombre, String email, Direccion direccion, String nivelFidelidad) {
        super(rut, nombre, email, direccion);
        this.nivelFidelidad = nivelFidelidad;
    }

    @Override
    public String mostrarResumen() {
        return "";
    }

    @Override
    public void registrar() {
        System.out.println("[AUDITORÍA] Cliente " + getNombre() + " incorporado al club nivel: " + nivelFidelidad);
    }

    @Override
    public String mostrarDatos() {
        return "[CLIENTE] " + super.toString() + " | Club: " + nivelFidelidad;
    }

    @Override
    public String toString() {
        return mostrarDatos();
    }
}