package data;

import model.Tour;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestorDatos {

    public ArrayList<Tour> leerToursDesdeArchivo(String rutaArchivo) {
        ArrayList<Tour> listaTours = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Saltar líneas vacías si las hay
                if (linea.trim().isEmpty()) continue;

                // Separar datos por punto y coma
                String[] datos = linea.split(";");

                if (datos.length == 3) {
                    String nombre = datos[0].trim();
                    String tipo = datos[1].trim();
                    int precio = Integer.parseInt(datos[2].trim());

                    // Crear objeto y añadir a la lista
                    Tour tour = new Tour(nombre, tipo, precio);
                    listaTours.add(tour);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato numérico del precio: " + e.getMessage());
        }

        return listaTours;
    }
}