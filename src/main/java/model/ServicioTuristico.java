package model;

public abstract class ServicioTuristico {
    private String nombre;
    private int duracionHoras;

    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    public String getNombre() { return nombre; }
    public int getDuracionHoras() { return duracionHoras; }

    public abstract void mostrarInformacion();

    @Override
    public String toString() {
        return "Servicio: " + nombre + " (" + duracionHoras + " hrs)";
    }
}