package data;

import model.ServicioTuristico;
import model.RutaGastronomica;
import model.PaseoLacustre;
import model.ExcursionCultural;

import java.util.ArrayList;
import java.util.List;

public class GestorServicios {


    public List<ServicioTuristico> obtenerCatalogoPolimorfico() {
        List<ServicioTuristico> servicios = new ArrayList<>();


        servicios.add(new RutaGastronomica("Sabores de Frutillar", 4, 3));
        servicios.add(new PaseoLacustre("Navegación Todos los Santos", 3, "Catamarán"));
        servicios.add(new ExcursionCultural("Vestigios de Colonos Alemanes", 5, "Museo Colonial"));
        servicios.add(new RutaGastronomica("Circuito de Curantos en Calbuco", 6, 2));
        servicios.add(new PaseoLacustre("Cruce Lago Llanquihue", 2, "Lancha Motorizada"));

        return servicios;
    }
}
