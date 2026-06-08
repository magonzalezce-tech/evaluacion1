package model;

public class Empleado extends Persona {
    private String rol;
    private double sueldoBase;


    public Empleado(String rut, String nombre, String correo, Direccion direccion, String rol, double sueldoBase) {
        super(rut, nombre, correo, direccion);
        this.rol = rol;
        this.sueldoBase = sueldoBase;
    }


    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public double getSueldoBase() { return sueldoBase; }
    public void setSueldoBase(double sueldoBase) { this.sueldoBase = sueldoBase; }

    @Override
    public String toString() {
        return super.toString() + " | Rol: " + rol + " | Sueldo Base: $" + sueldoBase;
    }
}