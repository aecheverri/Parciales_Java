package poliza;

public class Vehiculo {
    private String patente;
    private Float montoCompra;
    private Integer anioCompra;
    
    
    public Vehiculo(String patente, Float montoCompra, Integer anioCompra) {
        this.patente = patente;
        this.montoCompra = montoCompra;
        this.anioCompra = anioCompra;
    }


    public String patente() {
        return patente;
    }


    public Float montoCompra() {
        return montoCompra;
    }


    public Integer anioCompra() {
        return anioCompra;
    }


    @Override
    public String toString() {
        String salida = " - Dominio: " + patente + "\n";
        salida += " - Año: " + anioCompra + "\n";
        salida += " - Monto compra: " + montoCompra+"\n" ; 
        return salida;
    }

    
    

    
}
