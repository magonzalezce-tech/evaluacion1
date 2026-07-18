package data;

import model.Tour;
import java.util.List;

public class GestorTours {
    private List<Tour> inventario;

    public GestorTours(List<Tour> inventario) {
        this.inventario = inventario;
    }

    public void desplegarCatalogo() {
        System.out.println("\n--- CATÁLOGO VIGENTE DE PAQUETES ---");
        for (Tour t : inventario) {
            System.out.println("  • " + t);
        }
    }

    public void filtrarPorCategoria(String categoria) {
        System.out.println("\n--- COINCIDENCIAS PARA LA CATEGORÍA: [" + categoria.toUpperCase() + "] ---");
        boolean hallado = false;
        for (Tour t : inventario) {
            if (t.getTipo().equalsIgnoreCase(categoria)) {
                System.out.println("  -> " + t);
                hallado = true;
            }
        }
        if (!hallado) System.out.println("No se detectaron tours asociados a esa categoría.");
    }
}