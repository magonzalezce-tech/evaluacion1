package model;

public abstract class Persona {
    private String rut;
    private String nombre;
    private String email;
    private Direccion direccion; // Relación de Composición

    public Persona(String rut, String nombre, String email, Direccion direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
    }

    public String getRut() { return rut; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public Direccion getDireccion() { return direccion; }

    @Override
    public String toString() {
        return "RUT: " + rut + " | Nombre: " + nombre + " | Email: " + email + " | Ubicación: " + direccion;
    }
}