/**
 * Lista Circular Simplemente Enlazada con operaciones controladas:
 * - Insertar en una posición específica
 * - Eliminar por posición
 * - Eliminar por valor
 * - Imprimir antes/después de cada operación
 */
public class ListaCircularControlada {

    private static class Nodo {
        String dato;
        Nodo siguiente;

        Nodo(String dato) {
            this.dato = dato;
        }
    }

    private Nodo primero;
    private int cantidad;

    public boolean estaVacia() {
        return primero == null;
    }

    public int contarElementos() {
        return cantidad;
    }

    /**
     * Recorre la lista hasta encontrar el último nodo (aquel cuyo
     * siguiente es el primero). En una lista vacía devuelve null.
     */
    private Nodo obtenerUltimo() {
        if (estaVacia()) return null;
        Nodo actual = primero;
        while (actual.siguiente != primero) {
            actual = actual.siguiente;
        }
        return actual;
    }

    /**
     * Inserta 'dato' en la posición indicada (0 = inicio, cantidad = final).
     */
    public void insertarEnPosicion(String dato, int posicion) {
        if (posicion < 0 || posicion > cantidad) {
            System.out.println("Posición inválida: " + posicion);
            return;
        }

        Nodo nuevo = new Nodo(dato);

        if (estaVacia()) {
            // Único nodo: se apunta a sí mismo para cerrar el ciclo.
            nuevo.siguiente = nuevo;
            primero = nuevo;
        } else if (posicion == 0) {
            Nodo ultimo = obtenerUltimo();
            nuevo.siguiente = primero;
            ultimo.siguiente = nuevo;
            primero = nuevo;
        } else {
            Nodo anterior = primero;
            for (int i = 0; i < posicion - 1; i++) {
                anterior = anterior.siguiente;
            }
            nuevo.siguiente = anterior.siguiente;
            anterior.siguiente = nuevo;
        }
        cantidad++;
    }

    /**
     * Elimina el nodo ubicado en la posición indicada (0 = primero).
     */
    public void eliminarPorPosicion(int posicion) {
        if (estaVacia()) {
            System.out.println("No se puede eliminar: la lista está vacía.");
            return;
        }
        if (posicion < 0 || posicion >= cantidad) {
            System.out.println("Posición inválida: " + posicion);
            return;
        }

        if (cantidad == 1) {
            // Único nodo: al eliminarlo, la lista queda vacía.
            primero = null;
        } else if (posicion == 0) {
            Nodo ultimo = obtenerUltimo();
            primero = primero.siguiente;
            ultimo.siguiente = primero; // el ciclo se mantiene con el nuevo primero
        } else {
            Nodo anterior = primero;
            for (int i = 0; i < posicion - 1; i++) {
                anterior = anterior.siguiente;
            }
            anterior.siguiente = anterior.siguiente.siguiente;
        }
        cantidad--;
    }

    /**
     * Elimina la primera ocurrencia de 'valor' en la lista.
     */
    public void eliminarPorValor(String valor) {
        if (estaVacia()) {
            System.out.println("No se puede eliminar: la lista está vacía.");
            return;
        }

        if (primero.dato.equals(valor)) {
            eliminarPorPosicion(0);
            return;
        }

        Nodo anterior = primero;
        while (anterior.siguiente != primero) {
            if (anterior.siguiente.dato.equals(valor)) {
                anterior.siguiente = anterior.siguiente.siguiente;
                cantidad--;
                return;
            }
            anterior = anterior.siguiente;
        }

        System.out.println("Valor no encontrado: " + valor);
    }

    /**
     * Imprime todos los elementos, dando una sola vuelta al ciclo.
     */
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("[ ] (lista vacía)");
            return;
        }

        StringBuilder sb = new StringBuilder("[ ");
        Nodo actual = primero;
        for (int i = 0; i < cantidad; i++) {
            sb.append(actual.dato);
            if (i < cantidad - 1) sb.append(", ");
            actual = actual.siguiente;
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }

    private void mostrarAntesDespues(String operacion, Runnable accion) {
        System.out.println("\n--- " + operacion + " ---");
        System.out.print("Antes:   ");
        imprimir();
        accion.run();
        System.out.print("Después: ");
        imprimir();
    }

    // ---------------- Demostración ----------------
    public static void main(String[] args) {
        ListaCircularControlada lista = new ListaCircularControlada();

        lista.mostrarAntesDespues("Insertar 'A' en posición 0 (lista vacía)",
                () -> lista.insertarEnPosicion("A", 0));

        lista.mostrarAntesDespues("Insertar 'B' en posición 1 (final)",
                () -> lista.insertarEnPosicion("B", 1));

        lista.mostrarAntesDespues("Insertar 'C' en posición 1 (medio)",
                () -> lista.insertarEnPosicion("C", 1));

        lista.mostrarAntesDespues("Insertar 'Z' en posición 0 (nuevo inicio)",
                () -> lista.insertarEnPosicion("Z", 0));

        lista.mostrarAntesDespues("Eliminar por posición 0",
                () -> lista.eliminarPorPosicion(0));

        lista.mostrarAntesDespues("Eliminar por valor 'C'",
                () -> lista.eliminarPorValor("C"));

        lista.mostrarAntesDespues("Eliminar por posición 0 (deja un solo nodo)",
                () -> lista.eliminarPorPosicion(0));

        lista.mostrarAntesDespues("Eliminar el único nodo restante",
                () -> lista.eliminarPorPosicion(0));

        lista.mostrarAntesDespues("Intentar eliminar de una lista vacía",
                () -> lista.eliminarPorPosicion(0));
    }
}