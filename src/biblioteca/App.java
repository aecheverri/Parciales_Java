package biblioteca;

import java.time.LocalDate;

public class App {
    Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        // Docentes
        Docente ana = biblioteca.registrarDocente("Ana López",35234111, LocalDate.of(2010, 1, 1));
        Docente carlos = biblioteca.registrarDocente("Carlos Pérez", 40234111, LocalDate.of(2015, 1, 1));

        // Estudiantes
        Estudiante laura = biblioteca.registrarEstudiante("Laura Gómez", 45234111);
        Estudiante juan = biblioteca.registrarEstudiante("Juan Rodríguez", 50234111);

        // Libros 
        Libro cien_anios = biblioteca.donarLibro("Cien años de soledad", "Gabriel García Márquez");
        Libro sapiens = biblioteca.donarLibro("Sapiens: De animales a dioses", "Yuval Noah Harari");
        Libro nombre_de_la_rosa = biblioteca.donarLibro("El nombre de la rosa", "Umberto Eco");
        Libro breves_respuestas = biblioteca.donarLibro("Breves respuestas a las grandes preguntas", "Stephen Hawking");



        // Préstamos utilizando usuarios y libros registrados
        Prestamo prestamo1 = biblioteca.registrarPrestamo(ana, cien_anios);
        Prestamo prestamo2 = biblioteca.registrarPrestamo(carlos, sapiens);
        Prestamo prestamo3 = biblioteca.registrarPrestamo(laura, nombre_de_la_rosa);
        Prestamo prestamo4 = biblioteca.registrarPrestamo(ana, breves_respuestas);


        // Devolver préstamos registrados
        biblioteca.devolverPrestamo(prestamo1);  // Ana devuelve el libro "Cien años de soledad"
        biblioteca.devolverPrestamo(prestamo2);  // Carlos devuelve "Sapiens: De animales a dioses"

        // Mostrar todos los préstamos registrados
        System.out.println("Préstamos registrados de la Biblioteca Central:");
        biblioteca.mostrarPrestamos();

        // Mostrar solo los préstamos activos 
        System.out.println("\nPréstamos activos (no devueltos):");
        biblioteca.mostrarPrestamosActivos();

        // Mostrar los usuarios que han realizado al menos 2 préstamos
        System.out.println("\nUsuarios con al menos 2 préstamos:");
        biblioteca.mostrarUsuariosConPrestamos(2);

}
