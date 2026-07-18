package model;

public class Tour {
    private String nombre;
    private String tipo;
    private int precio;

    public Tour(String nombre, String tipo, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getPrecio() { return precio; }

    @Override
    public String toString() {
        return "Tour: " + nombre + " | Experiencia: " + tipo + " | Valor: $" + precio;
    }
}
