import java.util.Scanner;

public class Liga {
    private String nombre;
    private Partido[] partidos;
    private int totalPartidos;

    private static final int MAX_PARTIDOS = 1000;

    public Liga(String nombre) {
        this.nombre = nombre;
        this.partidos = new Partido[MAX_PARTIDOS];
        this.totalPartidos = 0;
    }

    private void agregarPartido(Partido partido) {
        if (totalPartidos < MAX_PARTIDOS) {
            partidos[totalPartidos] = partido;
            totalPartidos++;
        } else {
            System.out.println("No se pueden agregar más partidos.");
        }
    }

    public void programarPartido(Partido partido) {
        assert partido != null : "partido no puede ser null";
        agregarPartido(partido);
    }

    public void listarPartidos() {
        System.out.println("Partidos Programados:");
        for (int i = 0; i < totalPartidos; i++) {
            System.out.println(" - " + partidos[i]);
        }
    }

    public void mostarPendientes() {
        System.out.println("Partidos Pendientes:");
        for (int i = 0; i < totalPartidos; i++) {
            if (partidos[i].estaPendiente()) {
                System.out.println(" - " + partidos[i]);
            }
        }
    }

    public void mostrarCalificacion() {
        System.out.println("Calificacion:");
        for (int i = 0; i < totalPartidos; i++) {
            Partido partido = partidos[i];
            if (!partido.estaPendiente()) {
                Equipo ganador = partido.getGanador();

                if (!equipoYaFueProcesado(ganador, i)) {
                    int victorias = contarVictorias(ganador);
                    System.out.println(" - " + ganador + " | victorias=" + victorias);
                }
            }
        }
    }

    private boolean equipoYaFueProcesado(Equipo equipo, int indiceActual) {
        boolean yaMostrado = false;
        
        for (int j = 0; j < indiceActual && !yaMostrado; j++) {
            Partido partidoAnterior = partidos[j];
            
            if (!partidoAnterior.estaPendiente() && partidoAnterior.getGanador() == equipo) {
                yaMostrado = true;
            }
        }
        
        return yaMostrado;
    }

    private int contarVictorias(Equipo equipo) {
        int victorias = 0;
        for (int i = 0; i < totalPartidos; i++) {
            if (!partidos[i].estaPendiente() && partidos[i].getGanador() == equipo) {
                victorias++;
            }
        }

        return victorias;
    }

    public void registrarResultado() {
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < totalPartidos; i++) {
            if (partidos[i].estaPendiente()) {
                procesarPartidoPendiente(partidos[i], scanner, i + 1);
            }
        }
        
        scanner.close();
    }

    private void procesarPartidoPendiente(Partido partido, Scanner scanner, int numeroPartido) {
        System.out.println("\n--- Registrando resultado del Partido " + numeroPartido + " ---");
        System.out.println(partido);
        
        int golesEquipo1 = pedirGoles(scanner, 1);
        int golesEquipo2 = pedirGoles(scanner, 2);
        
        registrarGolesEnPartido(partido, golesEquipo1, golesEquipo2);
        partido.marcarComoCompleto();
        
        System.out.println("Resultado registrado exitosamente.");
    }

    private int pedirGoles(Scanner scanner, int numeroEquipo) {
        int goles = -1;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            try {
                System.out.print("Ingrese goles del equipo " + numeroEquipo + ": ");
                goles = scanner.nextInt();
                
                if (goles < 0) {
                    System.out.println("Los goles no pueden ser negativos. Intente nuevamente.");
                } else {
                    entradaValida = true;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
                scanner.nextLine();
            }
        }
        
        return goles;
    }

    private void registrarGolesEnPartido(Partido partido, int golesEquipo1, int golesEquipo2) {
        if (golesEquipo1 > 0) {
            partido.aumentarGoles(1, golesEquipo1);
        }
        if (golesEquipo2 > 0) {
            partido.aumentarGoles(2, golesEquipo2);
        }
    }
}