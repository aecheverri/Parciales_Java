package poliza;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import hotel.BusinessException;

import java.util.HashMap;
import java.util.ArrayList;

public class Aseguradora {
    private Map<Cliente,List<Poliza>> polizas;

    

    public Aseguradora() {
        this.polizas = new HashMap<>();
    }

    
    public Poliza asegurarVida(Cliente c, Float montoAsegurado, LocalDate fechaInicio, LocalDate fechaFinalizacion) {
        Poliza seguroVida = new SeguroVida(c, montoAsegurado, fechaInicio, fechaFinalizacion);
        if(!polizas.keySet().contains(c)){
            polizas.put(c, new ArrayList<>());
            polizas.get(c).add(seguroVida);
        }else{
            if(!tieneSeguroVida(c)){
                polizas.get(c).add(seguroVida);
            }else{
                throw new BusinessException("El cliente ya tiene seguro de vida");
            }

        }
        return seguroVida;
    }
    
    private boolean tieneSeguroVida(Cliente c) {
        boolean tieneSeguroVida = false;
        int i=0;
        List<Poliza> polizasDelCliente = polizas.get(c);
        while(i < polizasDelCliente.size() && !tieneSeguroVida){
            tieneSeguroVida = polizasDelCliente.get(i) instanceof SeguroVida;
        }
        return tieneSeguroVida;
    }


    public Poliza asegurarVehiculo(Cliente c, Vehiculo v, LocalDate fechaInicio, LocalDate fechaFinalizacion) {
        Poliza seguroVehiculo = new SeguroAutomor(c, v, fechaInicio, fechaFinalizacion);
        if(!polizas.keySet().contains(c)){
            polizas.put(c, new ArrayList<>());
        }
        polizas.get(c).add(seguroVehiculo);
        
        return seguroVehiculo;
    }
    public void mostrarPolizas() {
        System.out.println("--- Polizas vigentes ---\n");
        polizasVigentes();
        System.err.println("\n+++++++++++++++++++++++++++++++++++++");
        System.out.println("--- Polizas vencidas ---\n");
        polizasVencidas();
        System.err.println("\n+++++++++++++++++++++++++++++++++++++");
    }


    private void polizasVencidas() {
        for(Cliente c : polizas.keySet()){
            List<Poliza> polizasDelCliente = polizas.get(c);
            if (!tieneAlgunaVigente(polizasDelCliente)){
                System.out.println(c);
                for(Poliza p : polizasDelCliente){
                    if (!p.estaVigente()){
                        System.out.println(p);
                    }
                }    
            }  
        }
    }


    private void polizasVigentes() {
        for(Cliente c : polizas.keySet()){
            List<Poliza> polizasDelCliente = polizas.get(c);
            if (tieneAlgunaVigente(polizasDelCliente)){
                System.out.println(c);
                for(Poliza p : polizasDelCliente){
                    if (p.estaVigente()){
                        System.out.println(p);
                    }
                }    
            }  
        }
    }


    private boolean tieneAlgunaVigente(List<Poliza> polizasDelCliente) {
        boolean algunaVigente = false;
        for(Poliza p : polizasDelCliente){
            if(p.estaVigente()){
                algunaVigente = true;
                break;
            }
        }
        return algunaVigente;
    }


    public void transferirPoliza(Poliza p, Cliente c) {
        polizas.get(p.cliente()).remove(p);
        p.cambiarCliente(c);
        polizas.get(c).add(p);
        System.out.println("aaa");
        System.out.println(polizas.get(c));
    }
    
}
