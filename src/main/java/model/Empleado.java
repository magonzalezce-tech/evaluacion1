package model;

/**
 * Modela el comportamiento y los datos particulares de la fuerza laboral interna
 * (como guías de turismo u operadores logísticos) de Llanquihue Tour.
 * Esta clase hereda todos los atributos y lógica de validación de la clase Persona.
 *
 * @author Matias Gonzalez
 * @version 1.0
 * @see Persona
 */

public class Empleado extends Persona {
    /**
     * Cargo técnico u operacional que desempeña en la empresa.
     */
    private String rol;
    /**
     * Remuneración base asignada contractualmente al trabajador.
     */
    private double sueldoBase;

    /**
     * Constructor completo para dar de alta a un Empleado en el sistema.
     * Envía los datos comunes al constructor de la superclase mediante la instrucción {@code super}.
     *
     * @param rut    Cédula de identidad.
     * @param nombre Nombre completo del colaborador.
     * @param correo Email corporativo.
     * @param rol    Puesto de trabajo específico.
     * @param sueldo Salario líquido contractual.
     */

    public Empleado(String rut, String nombre, String correo, String rol, double sueldo) {
        super(rut, nombre, correo);
        this.rol = rol;
        setSueldoBase(sueldo);
    }

    /**
     * Obtiene el rol del empleado.
     *
     * @return Cargo actual del empleado.
     */

    public String getRol() {
        return rol;
    }

    /**
     * Modifica el rol o cargo laboral del empleado.
     *
     * @param rol Nuevo cargo a asignar.
     */

    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Obtiene el sueldo base del empleado.
     *
     * @return El sueldo líquido actual.
     */

    public double getSueldoBase() {
        return sueldoBase;
    }

    /**
     * Modifica la asignación del sueldo base.
     *
     * @param sueldoBase Nuevo monto salarial.
     */

    public void setSueldoBase(double sueldoBase) {
        try {
            if (sueldoBase < 0) {
                throw new IllegalArgumentException("El sueldo no puede ser negativo.");
            }
            this.sueldoBase = sueldoBase;
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Error en sueldo de " + getNombre() + ": " + e.getMessage());
            this.sueldoBase = 0;
        }
    }

    /**
     * Concatena la información base heredada junto con las métricas propias del Empleado.
     *
     * @return Datos consolidados del colaborador.
     */

    @Override
    public String toString() {
        return super.toString() + " | Rol: " + rol + " | Sueldo Base: $" + sueldoBase;
    }

    public String getSueldo() {
        return null;
    }

    public double setSueldo() {
        return 0;
    }

}