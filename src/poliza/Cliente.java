package poliza;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Cliente {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    
    public Cliente(String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer edad(){
        return Integer.valueOf((int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now()));
    }


    public String nombre() {
        return nombre;
    }

    public String apellido() {
        return apellido;
    }

    public LocalDate fechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public int hashCode() {
        
        return Objects.hash(nombre, apellido,fechaNacimiento);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        
        Cliente other = (Cliente) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (apellido == null) {
            if (other.apellido != null)
                return false;
        } else if (!apellido.equals(other.apellido))
            return false;
        if (fechaNacimiento == null) {
            if (other.fechaNacimiento != null)
                return false;
        } else if (!fechaNacimiento.equals(other.fechaNacimiento))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "@@@@@ Cliente: " +  nombre +" " + apellido + " ("+ edad() +") @@@@@" ;
    }

    
    

    
    
}
