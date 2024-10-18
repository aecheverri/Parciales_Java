package torneoFutbol;



public class Partido {       
    private String local;
    private String visitante;
    private int goles_local;
    private int goles_visitante;
    
    
    public Partido(String local, String visitante, int goles_local, int goles_visitante) {
        this.local = local;
        this.visitante = visitante;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
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
    public String toString(){
        String salida =  equipoLocal() + " " + golesEquipoLocal() + " - ";
        salida +=  equipoVisitante() + " " + golesEquipoVisitante();
        return salida;
    }

   public String resultadoPartido(){
        String resultado = "Empate";
        if (goles_local > goles_visitante){
            resultado = local;
        }else if(goles_local < goles_visitante){
            resultado = visitante;
        }
        return resultado;
   }
    
}
