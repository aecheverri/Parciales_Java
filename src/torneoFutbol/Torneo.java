package torneoFutbol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Torneo {
    private List<Equipo> equipos;
    private Map<LocalDate, Set<Partido>> partidos;
    
    public Torneo() {
        equipos = new ArrayList<>();
        partidos = new HashMap<>();
    }

    public void cargarEquipo(String nombre, int cantidadFanaticos){
        Equipo nuevo = new Equipo(nombre, cantidadFanaticos);
        // revisar que no está ingresado
        equipos.add(nuevo);
    }

    public void cargarPartido(String local, String visitante, LocalDate fecha, int golesLocal, int golesVisitante){
        
    }

    
}
