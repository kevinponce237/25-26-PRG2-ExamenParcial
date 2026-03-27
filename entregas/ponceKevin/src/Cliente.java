import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cliente {
    public static void main(String[] args) {
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("d/M/yyyy H:mm");

        Liga unea = new Liga("UNEA santander");
        Equipo pelatlantico = new Equipo("fc-pelatlántico", "rojo");
        Equipo burger = new Equipo("Burgeger", "verde");
        Equipo geek = new Equipo("geek", "negro");
        Partido geekXBurger = new Partido(geek, burger, LocalDateTime.parse("30/6/2026 15:00", formatoFechaHora));
        unea.programarPartido(geekXBurger);
        Partido  pelatlanticoXgeek = new Partido(pelatlantico, geek, LocalDateTime.parse("1/7/2024 15:00", formatoFechaHora));
        unea.programarPartido(pelatlanticoXgeek);
        pelatlanticoXgeek.marcarComoCompleto();
        unea.mostarPendientes();
        unea.registrarResultado();
        unea.listarPartidos();
        unea.mostrarCalificacion();
    }
}