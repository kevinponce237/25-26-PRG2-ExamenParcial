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

    public void aumentarVictorias() {

    }

    public void aumentarDerrotas() {

    }
    public void aumentarEmpates() {

    }

    public void actualizarTotal(int puntos) {

    }

    public String toString() {
      
    }
}