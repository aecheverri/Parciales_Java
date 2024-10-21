package torneoFutbol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Torneo {
    private List<Equipo> equipos;
    private Map<LocalDate, Set<Partido>> partidosPorFecha;
    private Map<String, List<Partido>> partidosPorEquipo;  
    
    public Torneo() {
        equipos = new ArrayList<>();
        partidosPorFecha = new HashMap<>();
        partidosPorEquipo = new HashMap<>();
    }

    public void cargarEquipo(String nombre, int cantidadFanaticos){
        Equipo nuevo = new Equipo(nombre, cantidadFanaticos);
        equipos.add(nuevo);
    }

    private void agregarPartido(Map<String, List<Partido> > partidosEquipo ,String equipo, Partido encuentro){
        if(!partidosEquipo.containsKey(equipo)){
            partidosEquipo.put(equipo, new ArrayList<>());
        }
        partidosEquipo.get(equipo).add(encuentro);
    }


    public void cargarPartido(String local, String vistante, LocalDate fecha, int golesLocal, int golesVisitante){
        // que ambos sean equipos del torneo
        //revisar que local != LogolesEgolesLocal y golesLogolesEquipoLocal >= 0 y que ningún equipo haya jugado en esa fecha (?)
        
        Partido nuevo_partido = new Partido(local, vistante, golesLocal, golesVisitante);
        
        if(!partidosPorFecha.containsKey(fecha)){
            partidosPorFecha.put(fecha, new HashSet<>());
        }
        partidosPorFecha.get(fecha).add(nuevo_partido);
        
        agregarPartido(partidosPorEquipo, local, nuevo_partido);
        agregarPartido(partidosPorEquipo, vistante, nuevo_partido);

    }

    private int cantidadPartidosDisputados(String e){
        int partidosJugados = 0;
        if (partidosPorEquipo.containsKey(e)) {
            partidosJugados = partidosPorEquipo.get(e).size();
        }
        return partidosJugados;
    }

    
    public int puntos(String e){
        int ptos = 0;
        if (partidosPorEquipo.containsKey(e)){
            for(Partido p : partidosPorEquipo.get(e)){
                if(p.resultadoPartido().equals(e)){
                    ptos += 3;
                }else if(p.resultadoPartido().equals("Empate")){
                    ptos += 1;
                }
            }
        }
        return ptos;
    }
    
    public int cantidadPartidosGanados(String e){
        int ganados = 0;
        if (partidosPorEquipo.containsKey(e)){
            for(Partido p : partidosPorEquipo.get(e)){
                if(p.resultadoPartido().equals(e)){
                    ganados += 1;
                }
            }
        }
        return ganados;
    }
    
    public int cantidadPartidosEmpatados(String e){
        int empatados = 0;
        if (partidosPorEquipo.containsKey(e)){
            for(Partido p : partidosPorEquipo.get(e)){
                if(p.resultadoPartido().equals("Empate")){
                    empatados += 1;
                }
            }
        }
        return empatados;
    }
    
    public int cantidadPartidosPerdidos(String e){
        int perdidos = 0;
        if (partidosPorEquipo.containsKey(e)){
            for(Partido p : partidosPorEquipo.get(e)){
                if(!p.resultadoPartido().equals("Empate") && !p.resultadoPartido().equals(e)){
                    perdidos += 1;
                }
            }
        }
        return perdidos;
    }
    
    private int buscarGoles(String e, Partido p){
        // perdir que e esté en p
        int goles = 0;
        if (p.equipoLocal().equals(e)){
            goles = p.golesEquipoLocal();
        }else{
            goles = p.golesEquipoVisitante();
        }
        return goles;
    }
    
    public int golesConvertidos(String e){
        int golesAFavor = 0;
        if (partidosPorEquipo.containsKey(e)){
            for(Partido p : partidosPorEquipo.get(e)){
                golesAFavor += buscarGoles(e, p);
            }
        }
        return golesAFavor;
    }
    
    public int golesDelRival(String e, Partido p){
        int goles = 0;
        if (p.equipoLocal().equals(e)){
            goles = p.golesEquipoVisitante();
        }else{
            goles = p.golesEquipoLocal();
        }
        return goles; 
    }
    
    public int golesRecibidos(String e){
        int golesEnContra = 0;
        if (partidosPorEquipo.containsKey(e)){
            for(Partido p : partidosPorEquipo.get(e)){
                golesEnContra += golesDelRival(e, p);
            }
        }
        return golesEnContra;
    }

    public int diferenciaDeGol(String e){
        return golesConvertidos(e) - golesRecibidos(e);
    }


    public void mostrarPartidosFecha(LocalDate f){
        for( Partido p : partidosPorFecha.get(f)){
            System.out.println("Fecha: " + f + ", " + p);
        }
    }

    public String mostrarEstadisticasEquipo(String e) {
        String stats = String.format("%-15s | %5s | %5s | %5s | %5s | %5s | %5s | %5s | %s |",
                e,
                centrar(cantidadPartidosDisputados(e), 5),
                centrar(puntos(e), 5),
                centrar(cantidadPartidosGanados(e), 5),
                centrar(cantidadPartidosEmpatados(e), 5),
                centrar(cantidadPartidosPerdidos(e), 5),
                centrar(golesConvertidos(e), 5),
                centrar(golesRecibidos(e), 5),
                centrarConSigno(diferenciaDeGol(e), 5));  // Centrar la diferencia de gol con signo
    
        return stats;
    }
    
    private String centrar(int number, int width) {
        String str = String.valueOf(number);
        int spaces = width - str.length();
        int padLeft = spaces / 2 + spaces % 2;  // Asegura que si es impar, el lado izquierdo tenga más espacio
        return " ".repeat(padLeft) + str + " ".repeat(spaces - padLeft);
    }
    
    private String centrarConSigno(int number, int width) {
        String str = String.format("%+d", number);  // Asegura que muestre el signo
        int spaces = width - str.length();
        int padLeft = spaces / 2 + spaces % 2;  // Asegura que si es impar, el lado izquierdo tenga más espacio
        return " ".repeat(padLeft) + str + " ".repeat(spaces - padLeft);
    }

    private List<String> ordenarEquipos(){
        List<String> equipos = new ArrayList<>(partidosPorEquipo.keySet());

        int n = equipos.size();
        for (int i = 1; i < n; i++) {
            String key = equipos.get(i);
            int j = i - 1;

            // Mover los elementos que son menores que 'key' a una posición adelante
            while (j >= 0 && (puntos(equipos.get(j)) < puntos(key) || 
                          (puntos(equipos.get(j)) == puntos(key) && 
                           diferenciaDeGol(equipos.get(j)) < diferenciaDeGol(key)))) {
            // Aquí es necesario usar "set" para cambiar el valor de la lista
                equipos.set(j + 1, equipos.get(j));
                j--;
            }
            equipos.set(j + 1, key); // Establecer la clave en la posición correcta
        }
        return equipos;
    }

    public void mostrarTabla(){
        for (String e: ordenarEquipos()){
            System.out.println(mostrarEstadisticasEquipo(e));
        }
    }
}
