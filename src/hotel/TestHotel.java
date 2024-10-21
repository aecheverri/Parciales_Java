package hotel;

import java.time.LocalDate;

public class TestHotel {
    public static void main(String[] args) {
        // Crear un hotel
        Hotel hotel = new Hotel("Hotel California", "Av Brotes Verdes 1234");

        // Definir precio de habitaciones
        hotel.definirPrecioNoche(100);
        
        // Crear habitaciones
        hotel.agregarHabitacion(4);
        hotel.agregarHabitacion(6);
        hotel.agregarHabitacion(8);
        hotel.agregarHabitacion(6);
        hotel.agregarHabitacion(3);
        
        // Crear clientes
        Cliente juana = new Cliente("Juana");
        Cliente pedro = new Cliente("Pedro");
        Cliente maria = new Cliente("Maria");

        // Consultar disponibilidad en el hotel entre el 14 y 20 de junio de 2024
        hotel.consultarDisponibilidad(LocalDate.of(2024, 06, 14), LocalDate.of(2024, 06, 20));
        
        // Reservar habitaciones
        hotel.reservarHabitacion(juana, LocalDate.of(2024, 06, 14), LocalDate.of(2024, 06, 20), 5);
        hotel.reservarHabitacion(pedro, LocalDate.of(2024, 06, 15), LocalDate.of(2024, 06, 18), 4);
        
        // Consultar disponibilidad en el hotel entre el 14 y 20 de junio de 2024
        hotel.consultarDisponibilidad(LocalDate.of(2024, 06, 14), LocalDate.of(2024, 06, 20));
        
        // Consultar disponibilidad en el hotel entre el 18 y 25 de junio de 2024
        hotel.consultarDisponibilidad(LocalDate.of(2024, 06, 18), LocalDate.of(2024, 06, 25));
        
        // Reservar habitaciones
        hotel.reservarHabitacion(maria, LocalDate.of(2024, 06, 19), LocalDate.of(2024, 06, 30), 4);
        
        // Consultar disponibilidad en el hotel entre el 10 y 25 de junio de 2024
        hotel.consultarDisponibilidad(LocalDate.of(2024, 06, 10), LocalDate.of(2024, 06, 25));
        
        // Mostrar información detallada de las reservas de un hotel
        hotel.mostrarReservasHotel();
    
    }
}
