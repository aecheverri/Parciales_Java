package ong;

import java.util.Objects;

public class Donante {
    private String nombre;
    private String apellido;
    private int id;
    
    
    public Donante(String nombre, String apellido, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        
        Donante other = (Donante) obj;
      
        return this.nombre.equals(other.nombre) 
                && this.apellido.equals(other.apellido);
    }


    public String nombreDonante() {
        return nombre;
    }


    public String apellidoDonante() {
        return apellido;
    }


    public int idDonante() {
        return id;
    }


    @Override
    public String toString() {
        return "("+ id +")" + apellido + ", " + nombre ;
    }

        
}
