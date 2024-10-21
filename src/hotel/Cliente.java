package hotel;

public class Cliente {
    String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }


    public Cliente(Cliente cliente) {
        this.nombre = new String(cliente.nombre);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String nombreCliente(){
        return new String(nombre);
    }





}
