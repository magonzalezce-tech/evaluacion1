package Servicios;

import model.Tour;
import java.util.ArrayList;

public class TourService {
    private ArrayList<Tour> inventarioTours;

    public TourService(ArrayList<Tour> inventarioTours) {
        this.inventarioTours = inventarioTours;
    }

 
    public void mostrarCatalogoCompleto() {
        if (inventarioTours.isEmpty()) {
            System.out.println("El catálogo está vacío.");
            return;
        }
        for (Tour t : inventarioTours) {
            System.out.println(" ↳ " + t);
        }
    }

   
    public void buscarTourPorNombre(String terminoBusqueda) {
        boolean encontrado = false;
        for (Tour t : inventarioTours) {
            if (t.getNombre().toLowerCase().contains(terminoBusqueda.toLowerCase())) {
                System.out.println(" [Encontrado] " + t);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron tours que coincidan con: '" + terminoBusqueda + "'");
        }
    }

  
    public void filtrarToursPorTipo(String tipoFiltro) {
        boolean coincidencia = false;
        for (Tour t : inventarioTours) {
            if (t.getTipo().equalsIgnoreCase(tipoFiltro)) {
                System.out.println(" -> " + t);
                coincidencia = true;
            }
        }
        if (!coincidencia) {
            System.out.println("No hay tours disponibles bajo la categoría: " + tipoFiltro);
        }
    }
}
