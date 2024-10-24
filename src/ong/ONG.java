package ong;

import java.util.List;

import hotel.BusinessException;

import java.time.LocalDate;
import java.util.ArrayList;

public class ONG {
    private String nombre;
    private List<Donante> donantes;
    private List<Donacion> donaciones;
    private int idNuevoDonante;
    private int idNuevaDonacion;
  

    
    public ONG(String nombre) {
        this.nombre = nombre;
        this.donantes = new ArrayList<>();
        this.donaciones = new ArrayList<>();
        this.idNuevoDonante = 1;
        this.idNuevaDonacion = 1;
    }

    private boolean existeDonante(String nombre, String apellido){
        int i = 0;
        boolean existe = false;
        int n = donantes.size();
        while(i < n && !existe){
            existe = donantes.get(i).nombreDonante().equals(nombre) &&  donantes.get(i).apellidoDonante().equals(apellido);
            if (!existe){
                i++;
            }
        }
        return existe;
    }

    private Donante buscarDonante(String nombre, String apellido){
        for(int i = 0; i < donantes.size();i++){
            if (donantes.get(i).nombreDonante().equals(nombre) &&  donantes.get(i).apellidoDonante().equals(apellido)){
                return donantes.get(i);
            }
        }
        throw new BusinessException("No hay ningún donante con ese nombre y apellido");
    }


    public Donante registrarDonante(String nombre, String apellido) {
        Donante d;
        if (existeDonante(nombre, apellido)){
            d = buscarDonante(nombre, apellido);
        }else{
            d = new Donante(nombre, apellido, idNuevoDonante);
            donantes.add(d);
            idNuevoDonante++;
        }
        return d;     
    }

    public void mostrarDonantes() {
       System.out.println("Listado de donantes de " + nombre);
       for(Donante d : donantes){
            System.out.println(d);
       }
    }

    public Donacion cargarDonacion(Donante d, LocalDate fechaDonacion, float montoDonancion) {
        if ( !existeDonante(d.nombreDonante(), d.apellidoDonante()) ){
            throw new BusinessException("No existe el donante en el sistema.");   
        }
        Donacion nueva = new Donacion(idNuevaDonacion, d, fechaDonacion, montoDonancion);
        idNuevaDonacion ++;
        donaciones.add(nueva);
        return nueva;    
    }

    public void mostrarDonaciones() {
        donaciones.sort((d1, d2) -> d1.compareTo(d2));
        System.out.println("Listado de donaciones de " + nombre);
        
        for(Donacion d : donaciones){
            System.out.println(d);
        }


    }

    public void mostrarResultadoFecha(LocalDate fechaLimite) {
        int cantidad_cobradas = 0;
        int cantidad_rechazadas = 0;
        int cantidad_pendientes = 0;
        float total_recaudado = 0;
        float maxMonto = Float.MIN_VALUE;
        float minMonto = Float.MAX_VALUE;

        System.out.println("Estado de Resultado de " + nombre + " al " + fechaLimite);
        
        for(Donacion d: donaciones){
            if(d.tieneFechaMenorOIgual(fechaLimite)){
                if(d.estaPendiente()){
                    cantidad_pendientes++;
                }
    
                if(d.estaCobrada()){
                    cantidad_cobradas++;
                    total_recaudado += d.montoDonancion();
                    if (d.montoDonancion() < minMonto){
                        minMonto = d.montoDonancion();
                    }
                    if (d.montoDonancion() > maxMonto){
                        maxMonto = d.montoDonancion();
                    }
    
                }

                if (d.estaRechazada()){
                    cantidad_rechazadas++;
                }   

            }
        }
        
        System.out.println(" - Cobradas: " + cantidad_cobradas);
        System.out.println(" - Rechazadas: " + cantidad_rechazadas);
        System.out.println(" - Pendientes: " + cantidad_pendientes);
        
        if (cantidad_cobradas > 0){
            float montoMedio = total_recaudado / cantidad_cobradas;
            System.out.println(" - Monto Total: $ " + total_recaudado);
            System.out.println(" - Monto máximo: $ "+ maxMonto);
            System.out.println(" - Monto mínimo: $ "+ minMonto);
            System.out.println(" - Monto medio: $ " + montoMedio);
        }
    
    }
        
                
                
}
