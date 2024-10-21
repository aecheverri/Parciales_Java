package hotel;

public class Habitacion {
    private int id;
    private int capacidad;
    
    public Habitacion(int id, int capacidad) {
        this.id = id;
        this.capacidad = capacidad;
    }

    public int numeroHabitacion(){
        return id;
    }

    public int capadidadHabitacion(){
        return capacidad;
    }

    @Override
    public String toString() {
        return "- Habitación Base " + id + ", capacidad = " + capacidad + "pax.";
    }

    
    
    

    
}
