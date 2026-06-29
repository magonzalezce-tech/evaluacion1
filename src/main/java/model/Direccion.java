package model;
/**
 * Representa la ubicación geográfica de una persona involucrada en los procesos de Llanquihue Tour.
 * Esta clase se utiliza bajo el principio de composición dentro de la clase Persona.
 *
 * @author Matias Gonzalez
 * @version 1.0
 */
public class Direccion {
    /** Nombre de la calle o pasaje del domicilio. */
    private String calle;
    /** Número domiciliario, kilómetro o indicador sin número (S/N). */
    private int numero;
    /** Ciudad, comuna o localidad de residencia. */
    private String ciudad;

    /**
     * Constructor completo para inicializar una nueva dirección.
     *
     * @param calle  Nombre de la calle.
     * @param numero Número de la propiedad o indicador de ruta.
     * @param ciudad Nombre de la comuna o ciudad.
     */

    public Direccion(String calle, int numero, String ciudad) {
        this.calle = calle;
        setNumero(numero);
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el nombre de la calle.
     * @return El nombre de la calle.
     */

    public String getCalle() { return calle; }

    /**
     * Obtiene el número del domicilio.
     */

    public void setCalle(String calle) { this.calle = calle; }

    /**
     * Obtiene el número del domicilio.
     * @return El número o indicador domiciliario.
     */

    public int getNumero() { return numero; }

    /**
     * Modifica el número del domicilio.
     * @param numero Nuevo número a asignar.
     */

    public void setNumero(int numero) {
        try {
            if (numero <= 0) {
                throw new IllegalArgumentException("El número de casa/calle debe ser mayor a 0.");
            }
            this.numero = numero;
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Error en dirección: " + e.getMessage());
            this.numero = 1;
        }
    }

    /**
     * Obtiene la ciudad de la dirección.
     * @return El nombre de la ciudad o comuna.
     */

    public String getCiudad() { return ciudad; }

    /**
     * Modifica la ciudad de la dirección.
     * @param ciudad Nueva ciudad a asignar.
     */
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    /**
     * Devuelve una representación en texto formateado de la dirección.
     * @return Cadena con el formato "Calle N° Numero, Ciudad".
     */

    @Override
    public String toString() {
        return calle + " N° " + numero + ", " + ciudad;
    }
}