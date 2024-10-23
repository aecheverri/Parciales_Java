package poliza;

import java.time.LocalDate;

public class SeguroVida extends Poliza{
    private Float montoAsegurado;
    
    
    public SeguroVida(Cliente c, Float montoAsegurado, LocalDate fechaInicio, LocalDate fechaFinalizacion) {
        super(c,fechaInicio,fechaFinalizacion);
        this.montoAsegurado = montoAsegurado;
        
    }

    public Float montoAsegurado() {
        return montoAsegurado;
    }

    public Float costoAnual(){
        Float costoAnual = 0f;
        if (cliente().edad() < 35){
            costoAnual = 0.05f * montoAsegurado;
        }else{
            costoAnual = 0.1f * montoAsegurado;
        }
        return costoAnual;
    }

    @Override
    public String toString() {
        String vigente = estaVigente() ? "SI" : "NO";
        String salida = "*** Seguro de Vida ***\n";
        salida += " - Monto asegurado: " + montoAsegurado + "\n";
        salida += " - Costo Anual: " + costoAnual() + "\n";
        salida += " - Vigencia desde: " + fechaInicio() + "\n";
        salida += " - Vigencia hasta: " + fechaFinalizacion() + "\n";
        salida += " - Esta vigente: " + vigente;
        return salida;
    }

    

}
