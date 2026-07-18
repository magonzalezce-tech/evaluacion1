package model;

public class GuiaTuristico extends Persona implements Registrable {
    private String certificacionSernatur;

    public GuiaTuristico(String rut, String nombre, String email, Direccion direccion, String certificacionSernatur) {
        // Llama al constructor base de la clase abstracta Persona
        super(rut, nombre, email, direccion);
        this.certificacionSernatur = certificacionSernatur;
    }

    public String getCertificacionSernatur() { return certificacionSernatur; }
    public void setCertificacionSernatur(String cert) { this.certificacionSernatur = cert; }

    @Override
    public String mostrarResumen() {
        return "[GUÍA] Nombre: " + getNombre() + " | RUT: " + getRut() + " | Sernatur ID: " + certificacionSernatur;
    }

    @Override
    public void registrar() {

    }

    @Override
    public String mostrarDatos() {
        return "";
    }
}