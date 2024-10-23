package poliza;

import java.time.LocalDate;

public abstract class Poliza {
    private Cliente cliente;
    private LocalDate fechaInicio;
    private LocalDate fechaFinalizacion;
    
    public Poliza(Cliente c, LocalDate fechaInicio, LocalDate fechaFinalizacion) {
        this.cliente = c;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public void cambiarCliente(Cliente c){
        this.cliente = c;
    }

    public Cliente cliente() {
        return cliente;
    }

    public LocalDate fechaInicio() {
        return fechaInicio;
    }

    public LocalDate fechaFinalizacion() {
        return fechaFinalizacion;
    }

    public abstract Float costoAnual();

    public boolean estaVigente(){
        return fechaFinalizacion.isBefore(LocalDate.now());
    }
    

    
}
