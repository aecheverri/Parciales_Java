package torneoFutbol;



public class TestPartido {
    public static void main(String[] args) {
        Partido p = new Partido("Chacarita", "Tigre", 2, 0);
        System.out.println(p.equipoLocal());
        String team = p.equipoLocal();
        team = "Talleres";    
        System.out.println(team);
        System.out.println(p.equipoLocal());
        System.out.println(p.equipoVisitante());
        int goles = p.golesEquipoVisitante();
        goles = -1;
        System.out.println(p.golesEquipoLocal());
        System.out.println(goles);
        System.out.println(p.golesEquipoVisitante());
        System.out.println(p);
        System.out.println(p.resultadoPartido());
    }



}
