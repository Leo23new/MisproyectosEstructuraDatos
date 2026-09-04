import java.util.ArrayList;
import java.util.List;

/**
 * Problema de Josephus resuelto con una Lista Circular Simplemente Enlazada.
 *
 * n personas se ubican en círculo. Se cuenta hasta k y esa persona es
 * eliminada. El conteo continúa desde la siguiente persona, dando la
 * vuelta al círculo tantas veces como sea necesario, hasta que solo
 * quede una persona: el superviviente.
 */
public class JosephusCircular {

    private static class Nodo {
        int id;
        Nodo siguiente;

        Nodo(int id) {
            this.id = id;
        }
    }

    /**
     * Construye el círculo de n personas (numeradas de 1 a n) y devuelve
     * el nodo inicial.
     */
    private static Nodo construirCirculo(int n) {
        Nodo primero = new Nodo(1);
        Nodo anterior = primero;
        for (int i = 2; i <= n; i++) {
            Nodo nuevo = new Nodo(i);
            anterior.siguiente = nuevo;
            anterior = nuevo;
        }
        anterior.siguiente = primero; // se cierra el círculo
        return primero;
    }

    /**
     * Busca el nodo anterior a 'nodo' recorriendo el círculo completo.
     */
    private static Nodo obtenerAnterior(Nodo nodo) {
        Nodo temp = nodo;
        while (temp.siguiente != nodo) {
            temp = temp.siguiente;
        }
        return temp;
    }

    /**
     * Resuelve el problema de Josephus para n personas eliminando cada
     * k-ésima. Imprime el orden de eliminación y devuelve el id del
     * superviviente.
     */
    public static int resolver(int n, int k) {
        Nodo actual = construirCirculo(n);
        List<Integer> orden = new ArrayList<>();
        int restantes = n;

        System.out.println("Círculo inicial (n=" + n + ", k=" + k + "): 1 a " + n);

        while (restantes > 1) {
            // avanzar k-1 pasos para llegar a la persona número k
            for (int i = 0; i < k - 1; i++) {
                actual = actual.siguiente;
            }

            Nodo anterior = obtenerAnterior(actual);
            orden.add(actual.id);
            System.out.println("Se elimina: persona " + actual.id);

            Nodo siguiente = actual.siguiente;
            anterior.siguiente = siguiente; // se cierra el hueco, el círculo sigue circular
            actual = siguiente;
            restantes--;
        }

        System.out.println("Orden de eliminación: " + orden);
        System.out.println("Superviviente: persona " + actual.id);
        return actual.id;
    }

    // ---------------- Demostración ----------------
    public static void main(String[] args) {
        System.out.println("=== Caso 1: n = 5, k = 2 ===");
        resolver(5, 2);

        System.out.println("\n=== Caso 2: n = 7, k = 3 ===");
        resolver(7, 3);
    }
}