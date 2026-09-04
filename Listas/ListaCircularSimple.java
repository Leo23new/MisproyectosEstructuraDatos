public class ListaCircularSimple {

    private static class Nodo {
        String dato;
        Nodo siguiente;

        Nodo(String dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo ultimo; 
    private int cantidad;

    public ListaCircularSimple() {
        this.ultimo = null;
        this.cantidad = 0;
    }

    /**
     * Verifica si la lista está vacía.
     */
    public boolean estaVacia() {
        return ultimo == null;
    }

    /**
     * Devuelve el número de elementos almacenados.
     */
    public int contarElementos() {
        return cantidad;
    }

    /**
     * Inserta un nuevo elemento al inicio de la lista.
     */
    public void insertarInicio(String dato) {
        Nodo nuevo = new Nodo(dato);

        if (estaVacia()) {
            // Caso especial: la lista está vacía.
            // El único nodo debe apuntar a sí mismo para mantener el ciclo.
            ultimo = nuevo;
            ultimo.siguiente = ultimo;
        } else {
            // El nuevo nodo apunta al que hasta ahora era el primero
            nuevo.siguiente = ultimo.siguiente;
            // El último nodo ahora apunta al nuevo primer nodo
            ultimo.siguiente = nuevo;
        }
        cantidad++;
    }

    /**
     * Inserta un nuevo elemento al final de la lista.
     */
    public void insertarFinal(String dato) {
        Nodo nuevo = new Nodo(dato);

        if (estaVacia()) {
            ultimo = nuevo;
            ultimo.siguiente = ultimo;
        } else {
            // El nuevo nodo apunta al primero (mantiene el ciclo)
            nuevo.siguiente = ultimo.siguiente;
            // El antiguo último apunta al nuevo nodo
            ultimo.siguiente = nuevo;
            // El nuevo nodo pasa a ser el último
            ultimo = nuevo;
        }
        cantidad++;
    }

    /**
     * Muestra todos los elementos de la lista, en orden, una sola vuelta.
     */
    public void mostrarElementos() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = ultimo.siguiente; // el primero
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(actual.dato);
            actual = actual.siguiente;
            if (actual != ultimo.siguiente) {
                sb.append(" -> ");
            }
        } while (actual != ultimo.siguiente);

        sb.append(" -> (vuelve al inicio)");
        System.out.println(sb.toString());
    }

    // ---------------- Demostración ----------------
    public static void main(String[] args) {
        ListaCircularSimple playlist = new ListaCircularSimple();

        System.out.println("¿Vacía? " + playlist.estaVacia());

        playlist.insertarFinal("Canción A");
        playlist.insertarFinal("Canción B");
        playlist.insertarFinal("Canción C");
        playlist.insertarInicio("Canción Inicial");

        playlist.mostrarElementos();
        System.out.println("Cantidad de elementos: " + playlist.contarElementos());
        System.out.println("¿Vacía? " + playlist.estaVacia());
    }
}
