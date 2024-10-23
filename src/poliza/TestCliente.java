package poliza;

import java.time.LocalDate;

public class TestCliente {
    public static void main(String[] args) {
        Cliente c = new Cliente("Carlo", "Angelotti", LocalDate.of(1980, 10, 22));
        String n = c.nombre();
        n = "Juan";
        System.err.println(n);
        System.out.println(c.nombre());
        LocalDate f = c.fechaNacimiento();
        f = LocalDate.of(1854, 10, 1);
        System.out.println(f);
        System.out.println(c.fechaNacimiento());
        System.out.println(c.edad());
    }
}
