public class Equipo {
    private String nombre;
    private String  color;
    private int victorias;
    private int derrotas;
    private int empates;
    private int total;
    private int jugadores;

    public Equipo(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public Equipo(String nombre,String color,int jugadores) {
        this(nombre,color);
        this.jugadores = jugadores;
    }

    public void aumentarVictorias(int victorias) {
        this.victorias += victorias;
    }

    public void aumentarDerrotas(int derrotas) {
        this.derrotas += derrotas;

    }
    public void aumentarEmpates(int empates) {
        this.empates += empates;
    }

    public void actualizarTotal(int puntos) {
        this.total += puntos;
    }

    public String toString() {
        return nombre + "|" + color + "|" + victorias + "|" + derrotas + "|" + empates + "|" + total + "|" + jugadores;
    }
}