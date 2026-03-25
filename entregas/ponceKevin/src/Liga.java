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
    }
}