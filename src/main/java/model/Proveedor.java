package model;

public class Proveedor extends Persona {
    private String tipoServicio;
    private String nombreContacto;


    public Proveedor(String rut, String nombreEmpresa, String correo, Direccion direccion, String tipoServicio, String nombreContacto) {
        super(rut, nombreEmpresa, correo, direccion);
        this.tipoServicio = tipoServicio;
        this.nombreContacto = nombreContacto;
    }

    public String getTipoServicio() { return tipoServicio; }
    public void setTipoServicio(String tipoServicio) { this.tipoServicio = tipoServicio; }

    public String getNombreContacto() { return nombreContacto; }
    public void setNombreContacto(String nombreContacto) { this.nombreContacto = nombreContacto; }

    @Override
    public String toString() {
        return super.toString() + " | Servicio: " + tipoServicio + " | Contacto: " + nombreContacto;
    }
}