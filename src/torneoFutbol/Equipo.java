package torneoFutbol;

import java.util.Objects;

public class Equipo {
    private String nombre;
    private int cantidadFans;
    
    
    public Equipo(String nombreEquipo, int numeroFans) {
        this.nombre = nombreEquipo;
        this.cantidadFans = numeroFans;
    }

    private void validarEquipo(String nombreEquipo, int numeroFans){
   
        
        if(nombreEquipo.equals("")){
            throw new EquipoVacioException("El nombre del equipo no puede ser vacío.");
        }

    

        if(numeroFans <= 0){
            throw new IllegalArgumentException("La cantidad de fanáticos debe ser un entero superior a 0.");
        }

        

    }

    public String verNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro){
            return true;
        }
        if (otro == null || this.getClass() != otro.getClass()){
            return false;
        }
        Equipo otroEquipo = (Equipo) otro;

        return this.nombre.equals(otroEquipo.nombre) && this.cantidadFans == otroEquipo.cantidadFans;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, cantidadFans);
    }
    
}
