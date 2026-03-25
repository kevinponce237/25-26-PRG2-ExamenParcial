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
        assert esNoNegativo(jugadores) : "jugadores no puede ser negativo";
        this.jugadores = jugadores;
    }

    public void aumentarVictorias(int victorias) {
        assert esNoNegativo(victorias) : "victorias no puede ser negativo";
        this.victorias += victorias;
    }

    public void aumentarDerrotas(int derrotas) {
        assert esNoNegativo(derrotas) : "derrotas no puede ser negativo";
        this.derrotas += derrotas;

    }
    public void aumentarEmpates(int empates) {
        assert esNoNegativo(empates) : "empates no puede ser negativo";
        this.empates += empates;
    }

    public void actualizarTotal(int puntos) {
        assert esNoNegativo(puntos) : "puntos no puede ser negativo";
        this.total += puntos;
    }

    private boolean esNoNegativo(int valor) {
        return valor >= 0;
    }

    public String toString() {
        return nombre + " - " + color;
    }
}