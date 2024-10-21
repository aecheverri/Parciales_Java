package hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private String direccion;
    private float precioHabitacion;
    private int idUltimaHabitacion;
    private int idUltimaReserva;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;

    public Hotel(String nom, String dir) {
        this.nombre = nom;
        this.direccion = dir;
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.idUltimaReserva = 1;
        this.precioHabitacion = 0;
        this.idUltimaHabitacion = 1;
    }

    public void definirPrecioNoche(int costoHabitacion) {
        this.precioHabitacion = costoHabitacion;
    }

    public void agregarHabitacion(int capacidad) {
        habitaciones.add(new Habitacion(idUltimaHabitacion, capacidad));
        this.idUltimaHabitacion++;
    }


    private boolean estaDisponible(Habitacion h, LocalDate fechaInicial, LocalDate fechaFinal) {
        boolean disponible = true;
        boolean habitacionHallada = false;
        int i = 0;
        while (i <  reservas.size() && !habitacionHallada){
            habitacionHallada = h.numeroHabitacion() == reservas.get(i).idHabitacion();
            if (!habitacionHallada){
                i++;
            }
        }
        if(habitacionHallada){
            LocalDate fechaInicialReserva = reservas.get(i).fechaIngreso();
            LocalDate fechaFinalReserva = reservas.get(i).fechaEgreso();
            disponible = fechaFinal.isBefore(fechaInicialReserva) || fechaInicial.isAfter(fechaFinalReserva) 
            || fechaFinal.isEqual(fechaInicialReserva)  || fechaInicial.isEqual(fechaFinalReserva);
        }
        return disponible;
    }


  
    public void consultarDisponibilidad(LocalDate fechaInicial, LocalDate fechaFinal) {
        System.out.println("* Habitaciones disponibles entre " + fechaInicial +" y "+  fechaFinal);
        for (Habitacion h: habitaciones){
            if (estaDisponible(h, fechaInicial, fechaFinal))
                System.out.println("  - " + h);

        }
    }

 

    private List<Habitacion> habitacionesDisponibles(LocalDate fechaCheckIn, LocalDate fechaCheckOut, int cantidadPersonas){
        List<Habitacion> disponibles = new ArrayList<>();
        for(Habitacion h : habitaciones){
            if (estaDisponible(h, fechaCheckIn, fechaCheckOut) || h.capadidadHabitacion() >= cantidadPersonas){
                disponibles.add(h);
            }
        }
        return disponibles;
    }
    

    public void reservarHabitacion(Cliente c, LocalDate fechaCheckIn, LocalDate fechaCheckOut, int cantidadPersonas) {
        List<Habitacion> habitacionesDisponiblesEnIntervalo = habitacionesDisponibles(fechaCheckIn, fechaCheckOut, cantidadPersonas);
        boolean puedeReservar = habitacionesDisponiblesEnIntervalo.size() > 0;
        
        if (!puedeReservar){
            throw new BusinessException("La reserva no puede afectuarse.");
        }
        int nroHabitacion = elegirMejorHabitacion(cantidadPersonas, habitacionesDisponiblesEnIntervalo);
        reservas.add( new Reserva(idUltimaReserva, nroHabitacion, c, fechaCheckIn, fechaCheckOut));
        idUltimaReserva++;     
    }

    

    private int elegirMejorHabitacion(int cantidadPersonas, List<Habitacion> habitacionesDisponiblesEnIntervalo) {
       int nroHabitacion = 0;
       int min = Integer.MAX_VALUE;
       for (Habitacion h: habitacionesDisponiblesEnIntervalo){
            if (h.capadidadHabitacion() < min && cantidadPersonas <= h.capadidadHabitacion()){
                min = h.capadidadHabitacion();
                nroHabitacion = h.numeroHabitacion();
            }
       }
       return nroHabitacion;
    }

    public void mostrarReservasHotel() {
        System.out.println("* Reservas del hotel " + nombre );
        for (Reserva r : reservas){
            int dias = (int) ChronoUnit.DAYS.between(r.fechaIngreso(), r.fechaEgreso());
            float monto =   precioHabitacion * dias;
            System.out.println("** Reserva "+ r.idReserva());
            System.out.println(habitacionReserva(r));
            System.out.println(r);
            System.out.println(" - Cantidad de noches: " + dias);
            System.out.println(" - Monto: $"+ monto);
            
        }

        
    }

    private Habitacion habitacionReserva(Reserva r) {
        int nroHabitacion = r.idHabitacion();
        int i = 0;
        while(i < habitaciones.size() && nroHabitacion != habitaciones.get(i).numeroHabitacion()){
            i++;
        }
        return habitaciones.get(i);
    }

}
