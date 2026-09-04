/**
 * Simulación del algoritmo Round-Robin usando una Lista Circular
 * Simplemente Enlazada como cola de procesos.
 *
 * - Cada proceso tiene nombre y tiempo restante.
 * - En cada turno se le asigna un quantum fijo.
 * - Si el proceso no termina, permanece en la lista y se avanza
 *   al siguiente (esto simula "volver al final del ciclo": como
 *   la lista es circular, avanzar el puntero equivale a moverlo
 *   detrás de todos los demás procesos).
 * - Si el proceso termina (tiempo restante <= 0), se elimina de la lista.
 */
public class RoundRobinCircular {

    private static class Proceso {
        String nombre;
        int tiempoRestante;

        Proceso(String nombre, int tiempoRestante) {
            this.nombre = nombre;
            this.tiempoRestante = tiempoRestante;
        }
    }

    private static class Nodo {
        Proceso proceso;
        Nodo siguiente;

        Nodo(Proceso proceso) {
            this.proceso = proceso;
        }
    }

    private Nodo primero;
    private Nodo ultimo;
    private Nodo actual;   // próximo proceso a atender
    private int cantidad;

    public boolean estaVacia() {
        return primero == null;
    }

    /**
     * Agrega un proceso al final de la cola circular.
     */
    public void agregarProceso(String nombre, int tiempo) {
        Nodo nuevo = new Nodo(new Proceso(nombre, tiempo));

        if (estaVacia()) {
            nuevo.siguiente = nuevo;
            primero = nuevo;
            ultimo = nuevo;
            actual = nuevo;
        } else {
            nuevo.siguiente = primero;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        cantidad++;
    }

    /**
     * Busca el nodo anterior a 'nodo' recorriendo el ciclo completo.
     */
    private Nodo obtenerAnterior(Nodo nodo) {
        Nodo temp = primero;
        while (temp.siguiente != nodo) {
            temp = temp.siguiente;
        }
        return temp;
    }

    /**
     * Elimina el nodo 'actual' de la lista (proceso que terminó)
     * y deja 'actual' apuntando al siguiente proceso a atender.
     */
    private void eliminarActual() {
        if (cantidad == 1) {
            primero = null;
            ultimo = null;
            actual = null;
        } else {
            Nodo anterior = obtenerAnterior(actual);
            Nodo siguienteProceso = actual.siguiente;
            anterior.siguiente = siguienteProceso;
            if (actual == primero) primero = siguienteProceso;
            if (actual == ultimo) ultimo = anterior;
            actual = siguienteProceso;
        }
        cantidad--;
    }

    /**
     * Imprime el estado actual de la cola, comenzando por el
     * próximo proceso a ejecutarse.
     */
    public void mostrarEstado() {
        if (estaVacia()) {
            System.out.println("Estado de la lista: [ ] (no quedan procesos)");
            return;
        }
        StringBuilder sb = new StringBuilder("Estado de la lista: [ ");
        Nodo temp = actual;
        for (int i = 0; i < cantidad; i++) {
            sb.append(temp.proceso.nombre).append("(").append(temp.proceso.tiempoRestante).append(")");
            if (i < cantidad - 1) sb.append(", ");
            temp = temp.siguiente;
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }

    /**
     * Ejecuta la simulación Round-Robin hasta que todos los procesos terminen.
     */
    public void simular(int quantum) {
        System.out.println("Estado inicial:");
        mostrarEstado();

        int turno = 1;
        while (!estaVacia()) {
            Proceso p = actual.proceso;
            System.out.println("\n--- Turno " + turno + " ---");
            System.out.println("Ejecutando: " + p.nombre + " | tiempo restante antes: " + p.tiempoRestante);

            int consumo = Math.min(quantum, p.tiempoRestante);
            p.tiempoRestante -= consumo;
            System.out.println("Quantum aplicado: " + consumo + " | tiempo restante después: " + p.tiempoRestante);

            if (p.tiempoRestante <= 0) {
                System.out.println(p.nombre + " ha finalizado y se elimina de la lista.");
                eliminarActual();
            } else {
                System.out.println(p.nombre + " no terminó, vuelve al final del ciclo.");
                actual = actual.siguiente;
            }

            mostrarEstado();
            turno++;
        }

        System.out.println("\nTodos los procesos han finalizado.");
    }

    // ---------------- Demostración ----------------
    public static void main(String[] args) {
        RoundRobinCircular planificador = new RoundRobinCircular();

        planificador.agregarProceso("P1", 5);
        planificador.agregarProceso("P2", 3);
        planificador.agregarProceso("P3", 7);

        int quantum = 2;
        planificador.simular(quantum);
    }
}