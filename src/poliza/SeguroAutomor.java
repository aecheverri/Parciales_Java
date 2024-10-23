package poliza;

import java.time.LocalDate;


public class SeguroAutomor extends Poliza {
    private Vehiculo vehiculo;

    public SeguroAutomor(Cliente c, Vehiculo v, LocalDate fechaInicio, LocalDate fechaFinalizacion) {
        super(c, fechaInicio, fechaFinalizacion);
        this.vehiculo = v;
    }

    public Float montoAsegurado(){
        Integer antiguedad = Integer.valueOf(LocalDate.now().getYear()- vehiculo.anioCompra() );
        return ( 1 - antiguedad * 0.05f) * vehiculo.montoCompra();
    }
    

    public Float costoAnual(){
        Float costoAnual = 0f;
        if (cliente().edad() < 30){
            costoAnual = montoAsegurado() * 0.2f;
        }else{
            costoAnual = montoAsegurado() * 0.1f;
        }
        return costoAnual;
    }

    @Override
    public String toString() {
        String vigente = estaVigente() ? "SI" : "NO";
        String salida = "*** Seguro Automotor ***\n";
        salida += vehiculo.toString();
        salida += " - Monto asegurado: " + montoAsegurado() + "\n";
        salida += " - Costo Anual: " + costoAnual() + "\n";
        salida += " - Vigencia desde: " + fechaInicio() + "\n";
        salida += " - Vigencia hasta: " + fechaFinalizacion() + "\n";
        salida += " - Esta vigente: " + vigente;
        return salida;
    }

    

}
