package ponceKevin.src;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private LocalDateTime fecha;
    private int golesEquipo1;
    private int golesEquipo2;
    private boolean estaCompleto = false;
    public partido(Equipo equipo1, Equipo equipo2,LocalDateTime fecha) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fecha = fecha;        
    }

    public void aumentarGoles(int numeroEquipo, int cantidDeGoles) {
        aumentarGolesEnEquipo(numeroEquipo, cantidDeGoles);
    }

    public void aumentarGoles(int numeroEquipo) {
        aumentarGolesEnEquipo(numeroEquipo, 1);
    }

    private void aumentarGolesEnEquipo(int numeroEquipo, int cantidadDeGoles) {
        assert numeroEquipo == 1 || numeroEquipo == 2 : "numeroEquipo debe ser 1 o 2";
        assert cantidadDeGoles >= 0 : "cantidadDeGoles no puede ser negativa";

        switch (numeroEquipo) {
            case 1 -> golesEquipo1 += cantidadDeGoles;
            case 2 -> golesEquipo2 += cantidadDeGoles;
        }
    }

    public boolean pasoLaFecha() {
        return !fecha.isAfter(LocalDateTime.now());
    }

    public boolean estaPendiente() {
        return !estaCompleto;
    }

    public Equipo getGanador() {
        if (golesEquipo1 > golesEquipo2) {
            return equipo1;
        }
        return equipo2;
    }

    public int[] getGolesPorEquipo() {
        return new int[]{golesEquipo1, golesEquipo2};
    }

    public int diasFaltantes() {
        return calcularDiasFaltantesDesde(LocalDateTime.now());
    }

    public int diasFaltantes(LocalDateTime fechaAComparar) {
        return calcularDiasFaltantesDesde(fechaAComparar);
    }

    private int calcularDiasFaltantesDesde(LocalDateTime fechaBase) {
        long dias = ChronoUnit.DAYS.between(fechaBase.toLocalDate(), fecha.toLocalDate());
        return (int) Math.max(0, dias);
    }

    public String toString() {
        
    }

}