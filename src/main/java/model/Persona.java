package model;

/**
 * Clase base del dominio que representa a cualquier individuo o entidad general
 * vinculada con Llanquihue Tour (clientes, colaboradores o proveedores).
 * Aplica encapsulamiento y validación nativa de datos comerciales mediante expresiones regulares.
 *
 * @author Matias Gonzalez
 * @version 1.0
 */

public class Persona {
    /**
     * Cédula de identidad o Rol Único Tributario (RUT) de la persona.
     */
    private String rut;
    /**
     * Nombre completo o razón social de la entidad.
     */
    private String nombre;
    /**
     * Dirección de correo electrónico de contacto.
     */
    private String correo;
    /**
     * Relación de composición: Dirección física asociada a la persona.
     */
    private Direccion direccion;

    /**
     * Constructor completo para registrar una Persona.
     * Invoca automáticamente a los métodos setter para sanitizar RUT y Correo desde el origen.
     *
     * @param rut       Cédula de identidad (ej: 12.345.678-9).
     * @param nombre    Nombre completo o razón social.
     * @param correo    Email de contacto (ej: usuario@dominio.com).
     * @param direccion Instancia previa del objeto Direccion asignado.
     */

    public Persona(String rut, String nombre, String correo, Direccion direccion) {
        setRut(rut); // Llama al setter para validar desde el nacimiento del objeto
        this.nombre = nombre;
        setCorreo(correo); // Llama al setter para validar
        this.direccion = direccion;
    }

    /**
     * Obtiene el RUT de la persona.
     *
     * @return El RUT actual o "RUT_INVALIDO" si falló la validación.
     */

    public String getRut() {
        return rut;
    }

    /**
     * Registra el RUT evaluando su estructura chilena estándar mediante expresiones regulares.
     * Admite formatos con o sin puntos, guion obligatorio y dígito verificador numérico o K.
     * En caso de no cumplir con el formato, asigna el valor "RUT_INVALIDO".
     *
     * @param rut Cadena de texto que representa el RUT a evaluar.
     */

    public void setRut(String rut) {
        String regexRut = "^[0-9]{1,2}\\.?[0-9]{3}\\.?[0-9]{3}-[0-9kK]{1}$";
        if (rut != null && rut.matches(regexRut)) {
            this.rut = rut;
        } else {
            this.rut = "RUT_INVALIDO";
        }
    }

    /**
     * Obtiene el nombre completo.
     *
     * @return Nombre de la persona.
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre completo de la persona.
     *
     * @param nombre Nuevo nombre a asignar.
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo electrónico.
     *
     * @return El correo electrónico o "CORREO_INVALIDO" si falló la validación.
     */

    public String getCorreo() {
        return correo;
    }

    /**
     * Registra el correo electrónico validando que contenga una sintaxis estándar (presencia de @ y dominio).
     * En caso de no cumplir con el patrón Regex, asigna el valor "CORREO_INVALIDO".
     *
     * @param correo Cadena de texto con el correo electrónico a evaluar.
     */

    public void setCorreo(String correo) {
        String regexCorreo = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (correo != null && correo.matches(regexCorreo)) {
            this.correo = correo;
        } else {
            this.correo = "CORREO_INVALIDO";
        }
    }

    /**
     * Obtiene el objeto Dirección compuesto de la persona.
     * @return Instancia de la dirección asociada.
     */

    public Direccion getDireccion() { return direccion; }

    /**
     * Modifica de forma directa el objeto Dirección.
     * @param direccion Nueva instancia de la dirección.
     */

    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    /**
     * Serializa los atributos base de la persona en una cadena de texto legible.
     * @return Resumen del registro de la persona.
     */

    @Override
    public String toString() {
        return "RUT: " + rut + " | Nombre: " + nombre + " | Correo: " + correo + " | Dirección: [" + direccion + "]";
    }
}