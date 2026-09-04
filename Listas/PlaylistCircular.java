/**
 * Playlist musical implementada como Lista Circular Simplemente Enlazada.
 *
 * - Agregar canciones al inicio y al final.
 * - Mostrar la playlist completa.
 * - Reproducir la siguiente canción (avanza el puntero 'actual').
 * - Eliminar una canción por nombre.
 * - Al llegar al final, vuelve automáticamente a la primera canción,
 *   porque el último nodo apunta de vuelta al primero.
 */
public class PlaylistCircular {

    private static class Nodo {
        String nombre;
        Nodo siguiente;

        Nodo(String nombre) {
            this.nombre = nombre;
        }
    }

    private Nodo primero;
    private Nodo ultimo;
    private Nodo actual; // canción que se está reproduciendo
    private int cantidad;

    public boolean estaVacia() {
        return primero == null;
    }

    /**
     * Agrega una canción al inicio de la playlist.
     */
    public void agregarInicio(String nombre) {
        Nodo nuevo = new Nodo(nombre);

        if (estaVacia()) {
            nuevo.siguiente = nuevo;
            primero = nuevo;
            ultimo = nuevo;
            actual = nuevo;
        } else {
            nuevo.siguiente = primero;
            ultimo.siguiente = nuevo;
            primero = nuevo;
        }
        cantidad++;
    }

    /**
     * Agrega una canción al final de la playlist.
     */
    public void agregarFinal(String nombre) {
        Nodo nuevo = new Nodo(nombre);

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
     * Muestra todas las canciones, marcando cuál se está reproduciendo.
     */
    public void mostrarPlaylist() {
        if (estaVacia()) {
            System.out.println("Playlist vacía.");
            return;
        }

        Nodo temp = primero;
        System.out.print("Playlist: ");
        for (int i = 0; i < cantidad; i++) {
            String marca = (temp == actual) ? "*" : "";
            System.out.print(marca + temp.nombre + marca);
            if (i < cantidad - 1) System.out.print(" -> ");
            temp = temp.siguiente;
        }
        System.out.println();
    }

    /**
     * Avanza a la siguiente canción. Si la actual era la última,
     * vuelve automáticamente a la primera (comportamiento propio
     * de la lista circular, sin lógica adicional).
     */
    public void reproducirSiguiente() {
        if (estaVacia()) {
            System.out.println("No hay canciones para reproducir.");
            return;
        }

        boolean eraLaUltima = (actual == ultimo);
        actual = actual.siguiente;

        if (eraLaUltima) {
            System.out.println("Fin de la playlist alcanzado -> se reinicia automáticamente.");
        }
        System.out.println("Reproduciendo ahora: " + actual.nombre);
    }

    /**
     * Elimina una canción por nombre. Si es la que se está
     * reproduciendo, 'actual' pasa a la siguiente.
     */
    public void eliminarPorNombre(String nombre) {
        if (estaVacia()) {
            System.out.println("No se puede eliminar: la playlist está vacía.");
            return;
        }

        // Caso: el nodo a eliminar es el primero
        if (primero.nombre.equals(nombre)) {
            if (cantidad == 1) {
                primero = null;
                ultimo = null;
                actual = null;
            } else {
                Nodo siguiente = primero.siguiente;
                ultimo.siguiente = siguiente;
                if (actual == primero) actual = siguiente;
                primero = siguiente;
            }
            cantidad--;
            System.out.println("Eliminada: " + nombre);
            return;
        }

        // Caso: el nodo está en el medio o al final
        Nodo anterior = primero;
        while (anterior.siguiente != primero) {
            if (anterior.siguiente.nombre.equals(nombre)) {
                Nodo aEliminar = anterior.siguiente;
                anterior.siguiente = aEliminar.siguiente;
                if (aEliminar == ultimo) ultimo = anterior;
                if (actual == aEliminar) actual = aEliminar.siguiente;
                cantidad--;
                System.out.println("Eliminada: " + nombre);
                return;
            }
            anterior = anterior.siguiente;
        }

        System.out.println("Canción no encontrada: " + nombre);
    }

    // ---------------- Demostración ----------------
    public static void main(String[] args) {
        PlaylistCircular playlist = new PlaylistCircular();

        playlist.agregarFinal("Canción A");
        playlist.agregarFinal("Canción B");
        playlist.agregarFinal("Canción C");
        playlist.agregarInicio("Canción Inicial");

        playlist.mostrarPlaylist();

        System.out.println("\n-- Reproduciendo en secuencia --");
        for (int i = 0; i < 6; i++) { // más vueltas que canciones, para forzar el reinicio
            playlist.reproducirSiguiente();
        }

        System.out.println("\n-- Eliminando 'Canción B' --");
        playlist.eliminarPorNombre("Canción B");
        playlist.mostrarPlaylist();

        System.out.println("\n-- Eliminando la canción actual --");
        playlist.mostrarPlaylist();
        playlist.eliminarPorNombre("Canción Inicial");
        playlist.mostrarPlaylist();
    }
}