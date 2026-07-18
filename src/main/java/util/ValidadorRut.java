package util;

import exception.RutInvalido;

public class ValidadorRut {

    public static String validarYFormatear(String rutRaw) throws RutInvalido {
        if (rutRaw == null) {
            throw new RutInvalido("El RUT no puede ser nulo.");
        }


        String limpio = rutRaw.replace(".", "").replace("-", "").replace(" ", "").toUpperCase();

        if (limpio.length() < 8) {
            throw new RutInvalido("El RUT ingresado es demasiado corto.");
        }

        String cuerpo = limpio.substring(0, limpio.length() - 1);
        char dvIngresado = limpio.charAt(limpio.length() - 1);

        try {
            int numCuerpo = Integer.parseInt(cuerpo);
            char dvCalculado = calcularDigitoVerificador(numCuerpo);

            if (dvIngresado != dvCalculado) {
                throw new RutInvalido("El dígito verificador '" + dvIngresado + "' no coincide con el esperado.");
            }


            return numCuerpo + "-" + dvIngresado;

        } catch (NumberFormatException e) {
            throw new RutInvalido("El cuerpo del RUT debe contener únicamente dígitos numéricos.");
        }
    }

    private static char calcularDigitoVerificador(int rut) {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return (char) (s != 0 ? s + 47 : 75);
    }
}
