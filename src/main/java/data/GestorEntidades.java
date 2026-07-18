package data;

import model.Registrable;
import model.GuiaTuristico;
import model.Vehiculo;
import java.util.ArrayList;

public class GestorEntidades {
    private ArrayList<Registrable> listaRegistrables;

    public GestorEntidades() {
        this.listaRegistrables = new ArrayList<>();
    }


    public void agregarEntidad(Registrable entidad) {
        this.listaRegistrables.add(entidad);
    }

    public ArrayList<Registrable> getListaRegistrables() {
        return listaRegistrables;
    }


    public String procesarYContarEntidades() {
        StringBuilder reporte = new StringBuilder();
        int conteoGuias = 0;
        int conteoVehiculos = 0;

        reporte.append("--- INFORME METODOLÓGICO DE REGISTROS ---\n");

        for (Registrable r : listaRegistrables) {

            reporte.append(r.mostrarResumen());


            if (r instanceof GuiaTuristico) {
                conteoGuias++;
                GuiaTuristico guia = (GuiaTuristico) r;
                reporte.append(" -> (Estado: Operador habilitado con credencial: ")
                        .append(guia.getCertificacionSernatur()).append(")\n");
            }
            else if (r instanceof Vehiculo) {
                conteoVehiculos++;
                Vehiculo v = (Vehiculo) r;
                reporte.append(" -> (Logística: Requiere revisión técnica de patente: ")
                        .append(v.getPatente()).append(")\n");
            }
        }

        reporte.append("\n[Resumen Total] Guías registrados: ").append(conteoGuias)
                .append(" | Vehículos operativos: ").append(conteoVehiculos);

        return reporte.toString();
    }

    public void listarYAnalizarEstructuras() {

    }
}