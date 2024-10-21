package hotel;

import java.time.LocalDate;

public class Reserva {
    private int id;
    private int nroHabitacion;
    private Cliente cliente;
    private LocalDate fechaIngreso;
    private LocalDate fechaEgreso;
    
    
    public Reserva(int id, int nroHabitacion, Cliente cliente, LocalDate fechaIngreso, LocalDate fechaEgreso) {
        this.id = id;
        this.nroHabitacion = nroHabitacion;
        this.cliente = cliente;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
    }


    public int idReserva() {
        return id;
    }


    public int idHabitacion() {
        return nroHabitacion;
    }


    public Cliente cliente() {
        return new Cliente(this.cliente);
    }


    public LocalDate fechaIngreso() {
        return fechaIngreso;
    }


    public LocalDate fechaEgreso() {
        return fechaEgreso;
    }

    @Override
    public String toString() {
        String salida = " - Cliente: " + cliente().nombreCliente() +"\n";
        salida+= " - Chekin:  " + fechaIngreso() +"\n";
        salida+= " - Chekout:  " + fechaEgreso();
        return salida;
    }


    
}
