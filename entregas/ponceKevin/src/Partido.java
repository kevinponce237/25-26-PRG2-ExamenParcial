package ponceKevin.src;
import java.time.LocalDateTime;
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
     
    }

    public boolean estaPendiente() {
        return !estaCompleto;
    }

    public Equipo getGanador() {
        
    }

    public int[] getGolesPorEquipo() {
        
    }

    public int diasFaltantes() {
        
    }

    public int diasFaltantes(LocalDateTime fechaAComparar) {
        
    }

    public String toString() {
        
    }

}