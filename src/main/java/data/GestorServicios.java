package data;

import java.util.ArrayList;
import model.ServicioTuristico;
import model.RutaGastronomica;
import model.PaseoLacustre;
import model.ExcursionCultural;

public class GestorServicios {


    public static ArrayList<ServicioTuristico> obtenerServiciosDePrueba() {
        ArrayList<ServicioTuristico> lista = new ArrayList<>();

        lista.add(new RutaGastronomica("Ruta del Kuchen Frutillar", 3, 4));
        lista.add(new RutaGastronomica("Sabores de Puerto Varas", 4, 5));
        lista.add(new PaseoLacustre("Navegación Lago Llanquihue", 2, "Catamarán"));
        lista.add(new PaseoLacustre("Vuelta a la Isla en Lancha", 1, "Lancha a Motor"));
        lista.add(new ExcursionCultural("Ruta Iglesias de Chiloé", 8, "Iglesia de Castro"));
        lista.add(new ExcursionCultural("Tour Patrimonial Puerto Varas", 2, "Barrio Histórico"));

        return lista;
    }
}