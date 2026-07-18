package util;

import model.Tour;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivos {

    public static List<Tour> leerToursDesdeArchivo(String ruta) {
        List<Tour> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;

                String[] token = linea.split(";");
                if (token.length == 3) {
                    try {
                        String nombre = token[0].trim();
                        String tipo = token[1].trim();
                        int precio = Integer.parseInt(token[2].trim());

                        lista.add(new Tour(nombre, tipo, precio));
                    } catch (NumberFormatException e) {
                        System.err.println("[EXCEPCIÓN LECTURA] Formato numérico corrompido en el precio.");
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("[FALLO CRÍTICO] Archivo de datos inaccesible: " + e.getMessage());
        }
        return lista;
    }
}