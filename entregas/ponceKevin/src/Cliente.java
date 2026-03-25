import java.time.LocalDateTime;

public class Cliente {
    public static void main(String[] args) {
        Liga unea = new Liga("UNEA santander");
        Equipo pelatlantico = new Equipo("fc-pelatlántico", "rojo");
        Equipo burger = new Equipo("Burgeger", "verde");
        Equipo geek = new Equipo("geek", "negro");
        Partido geekXBurger = new Partido(geek, burger, LocalDateTime.of(2026, 6, 30, 15, 0));
        unea.programarPartido(geekXBurger);
        Partido  pelatlanticoXgeek = new Partido(pelatlantico, geek, LocalDateTime.of(2024, 7, 1, 15, 0));
        unea.programarPartido(pelatlanticoXgeek);
        pelatlanticoXgeek.marcarComoCompleto();

        unea.registrarResultado();
        unea.listarPartidos();
        unea.mostarPendientes();
        unea.mostrarCalificacion();
    }
}