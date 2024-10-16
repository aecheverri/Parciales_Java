package torneoFutbol;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Partido {
    private LocalDate fecha;            
    private String local;
    private String visitante;
    private int goles_local;
    private int goles_visitante;
    
    
    public Partido(LocalDate fecha, String local, String visitante, int goles_local, int goles_visitante) {
        this.fecha = fecha;
        this.local = local;
        this.visitante = visitante;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
    }


    public LocalDate fechaPartido() {
        return (LocalDate)(fecha);
    }


    public String equipoLocal() {
        return (String)(local);
    }


    public String equipoVisitante() {
        return (String)visitante;
    }


    public int golesEquipoLocal() {
        return goles_local;
    }


    public int golesEquipoVisitante() {
        return goles_visitante;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String salida = "Fecha: " + fechaPartido().format(formatoFecha) + " | ";
        salida +=  "(L) "+equipoLocal() + " " + golesEquipoLocal() + " - ";
        salida +=  "(V) "+equipoVisitante() + " " + golesEquipoVisitante() + " | ";
        return salida;

    }

    
}
