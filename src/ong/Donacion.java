package ong;

import java.time.LocalDate;

public class Donacion implements Comparable<Donacion>{
    private enum  Estado {PENDIENTE, COBRADA, RECHADAZADA};
    private int id;
    private Donante donante;
    private LocalDate fechaDonacion;
    private float montoDonancion;
    private Estado estadoDonacion;
    
    
    public Donacion(int id, Donante donante, LocalDate fechaDonacion, float montoDonancion) {
        this.id = id;
        this.donante = donante;
        this.fechaDonacion = fechaDonacion;
        this.montoDonancion = montoDonancion;
        this.estadoDonacion = Estado.PENDIENTE;
    }

    public void setCobrada(){
        estadoDonacion = Estado.COBRADA;
    }

    public void setRechazada(){
        estadoDonacion = Estado.RECHADAZADA;
    }

    public boolean estaCobrada(){
        return estadoDonacion.equals(Estado.COBRADA);
    }

    public boolean estaPendiente(){
        return estadoDonacion.equals(Estado.PENDIENTE);
    }
    
    public boolean estaRechazada(){
        return estadoDonacion.equals(Estado.RECHADAZADA);
    }



    public Donante donante() {
        return donante;
    }

    public LocalDate fechaDonacion() {
        return fechaDonacion;
    }

    public float montoDonancion() {
        return montoDonancion;
    }
    
    public boolean tieneFechaMenorOIgual(LocalDate fecha){
        return fechaDonacion.isBefore(fecha) || fechaDonacion.equals(fecha);
    }



    @Override
    public int compareTo(Donacion otraDonacion) {
        return fechaDonacion.compareTo(otraDonacion.fechaDonacion);
    }

    @Override
    public String toString() {
        String salida = "Donación " + id + "\n";
        salida += " - Donante: " + donante.toString() + "\n";
        salida += " - Fecha: " + fechaDonacion + "\n";
        salida += " - Estado: " + estadoDonacion + "\n";
        salida += " - Monto: $ " + montoDonancion;
        return salida;
    }


    

    
    

    
    


}
