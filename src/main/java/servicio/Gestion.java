package servicio;

import model.Direccion;
import model.Persona;
import model.Empleado;
import model.Proveedor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Gestion {
    private ArrayList<Persona> listaPersonas;

    public Gestion() {
        this.listaPersonas = new ArrayList<>();
    }

    public boolean existeRut(String rut) {
        for (Persona p : listaPersonas) {
            if (p.getRut().equalsIgnoreCase(rut.trim())) {
                return true;
            }
        }
        return false;
    }

    public void cargarDatosDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int totalLineas = 0;

            while ((linea = br.readLine()) != null) {
                totalLineas++;
                try {
                    String[] datos = linea.split(",");
                    if (datos.length < 7) {
                        throw new Exception("Campos insuficientes en la línea.");
                    }

                    String tipo = datos[0].trim().toUpperCase();
                    String rut = datos[1].trim();
                    String nombre = datos[2].trim();
                    String correo = datos[3].trim();

                    String calle = datos[4].trim();
                    int numero = Integer.parseInt(datos[5].trim());
                    String ciudad = datos[6].trim();
                    Direccion dir = new Direccion(calle, numero, ciudad);

                    if (existeRut(rut)) {
                        System.out.println("❌ Línea " + totalLineas + " omitida: El RUT " + rut + " ya está registrado.");
                        continue;
                    }

                    if (tipo.equals("EMPLEADO")) {
                        String rol = datos[7].trim();
                        double sueldo = Double.parseDouble(datos[8].trim());
                        listaPersonas.add(new Empleado(rut, nombre, correo, dir, rol, sueldo));
                    } else if (tipo.equals("PROVEEDOR")) {
                        String servicio = datos[7].trim();
                        String contacto = datos[8].trim();
                        listaPersonas.add(new Proveedor(rut, nombre, correo, dir, servicio, contacto));
                    } else {
                        listaPersonas.add(new Persona(rut, nombre, correo, dir));
                    }

                } catch (Exception e) {
                    System.out.println("⚠️ Error procesando línea " + totalLineas + ": " + e.getMessage());
                }
            }
            System.out.println("\n✅ Inicialización completada. Registros cargados: " + listaPersonas.size());
        } catch (IOException e) {
            System.out.println("❌ Error al abrir el archivo de registros: " + e.getMessage());
        }
    }

    public void mostrarTodos() {
        if (listaPersonas.isEmpty()) {
            System.out.println("No hay registros en el sistema.");
            return;
        }
        for (Persona p : listaPersonas) {
            System.out.println(p);
        }
    }

    // Búsqueda simple automatizada
    public void buscarPorNombre(String termino) {
        System.out.println("\n--- COINCIDENCIAS PARA: '" + termino + "' ---");
        boolean hallado = false;
        for (Persona p : listaPersonas) {
            if (p.getNombre().toLowerCase().contains(termino.toLowerCase())) {
                System.out.println(p);
                hallado = true;
            }
        }
        if (!hallado) {
            System.out.println("No se encontraron registros con ese nombre.");
        }
    }
}
