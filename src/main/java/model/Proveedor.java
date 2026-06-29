package model;

/**
 * Modela las empresas y entidades externas subcontratadas que abastecen de servicios
 * (alojamiento, alimentación o transporte) a Llanquihue Tour.
 * Hereda de la clase base Persona para unificar la estructura de datos comerciales.
 *
 * @author Matias Gonzalez
 * @version 1.0
 * @see Persona
 */

public class Proveedor extends Persona {
    /**
     * Tipo de servicio provisto a la agencia (ej: "Transporte Marítimo").
     */
    private String tipoServicio;
    /**
     * Nombre de la persona natural que actúa como contraparte o enlace administrativo.
     */
    private String nombreContacto;

    /**
     * Constructor completo para registrar a un Socio Comercial (Proveedor).
     * Transfiere la identidad base a la superclase Persona.
     *
     * @param rut            RUT comercial de la empresa proveedora.
     * @param nombreEmpresa  Razón social de la empresa.
     * @param correo         Email de contacto comercial.
     * @param Servicio       Giro o rubro del servicio entregado.
     * @param nombreContacto Nombre del ejecutivo de cuentas.
     */

    public Proveedor(String rut, String nombreEmpresa, String correo, String Servicio, String nombreContacto) {
        super(rut, nombreEmpresa, correo);
        this.tipoServicio = Servicio;
        this.nombreContacto = nombreContacto;
    }

    /**
     * Obtiene el rubro o tipo de servicio que provee.
     *
     * @return Tipo de servicio provisto.
     */

    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Modifica el tipo de servicio ofrecido por la empresa externa.
     *
     * @param tipoServicio Nuevo tipo de servicio.
     */

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * Obtiene el nombre del contacto o representante.
     *
     * @return Nombre de la contraparte administrativa.
     */

    public String getNombreContacto() {
        return nombreContacto;
    }

    /**
     * Modifica el nombre del ejecutivo o contacto corporativo.
     *
     * @param nombreContacto Nuevo nombre de contacto.
     */

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    /**
     * Concatena el registro base de empresa junto con sus propiedades específicas de negocio logístico.
     *
     * @return Datos consolidados del socio comercial.
     */

    @Override
    public String toString() {
        return super.toString() + " | Servicio: " + tipoServicio + " | Contacto: " + nombreContacto;
    }

    public String getServicio() {
        return "";
    }

    public void setServicio(String nuevoSer) {
    }
}
