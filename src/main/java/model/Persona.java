package model;

public class Persona {
    private String rut;
    private String nombre;
    private String correo;
    private Direccion direccion;


    public Persona(String rut, String nombre, String correo, Direccion direccion) {
        setRut(rut); // Llama al setter para validar desde el nacimiento del objeto
        this.nombre = nombre;
        setCorreo(correo); // Llama al setter para validar
        this.direccion = direccion;
    }

    public String getRut() { return rut; }


    public void setRut(String rut) {
        String regexRut = "^[0-9]{1,2}\\.?[0-9]{3}\\.?[0-9]{3}-[0-9kK]{1}$";
        if (rut != null && rut.matches(regexRut)) {
            this.rut = rut;
        } else {
            this.rut = "RUT_INVALIDO";
        }
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }


    public void setCorreo(String correo) {
        String regexCorreo = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (correo != null && correo.matches(regexCorreo)) {
            this.correo = correo;
        } else {
            this.correo = "CORREO_INVALIDO";
        }
    }

    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    @Override
    public String toString() {
        return "RUT: " + rut + " | Nombre: " + nombre + " | Correo: " + correo + " | Dirección: [" + direccion + "]";
    }
}