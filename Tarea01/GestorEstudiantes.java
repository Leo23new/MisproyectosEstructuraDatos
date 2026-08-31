/**
 * TDA Registro de Estudiantes.
 * Implementado sobre un arreglo estático (capacidad fija en memoria).
 * 'size' es el dato lógico que indica cuántos estudiantes hay realmente
 * registrados en este momento; 'capacidad' es el tamaño físico del arreglo
 * y nunca cambia después de crear el objeto.
 */
public class GestorEstudiantes {

    private Estudiante[] vector;
    private int size;
    private final int capacidad;

    public GestorEstudiantes(int capacidad) {
        this.capacidad = capacidad;
        this.vector = new Estudiante[capacidad];
        this.size = 0;
    }

    /**
     * Pre-condición: size < capacidad Y no debe existir otro estudiante con el mismo id.
     * Acción: se guarda el nuevo estudiante en vector[size].
     * Post-condición: el estudiante queda registrado y size se incrementa en 1.
     * @return true si se registró correctamente, false si estaba lleno o el id ya existía.
     */
    public boolean registrar(Estudiante nuevo) {
        if (buscarIndice(nuevo.getId()) != -1) {
            System.out.println("Error: ya existe un estudiante con el id " + nuevo.getId());
            return false;
        }
        if (size >= capacidad) {
            System.out.println("Error: no hay espacio disponible (capacidad máxima alcanzada).");
            return false;
        }
        vector[size] = nuevo;
        size++;
        return true;
    }

    /**
     * Pre-condición: ninguna.
     * Post-condición: no se modifica el arreglo; se imprimen todos los estudiantes
     * registrados, recorriendo únicamente de 0 a size-1 (nunca hasta capacidad).
     */
    public void listar() {
        if (size == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + vector[i]);
        }
    }

    /**
     * Pre-condición: ninguna.
     * Post-condición: no se modifica el arreglo; retorna el índice del estudiante
     * con ese id, o -1 si no existe. Método interno reutilizado por registrar,
     * modificar y eliminar para no repetir lógica de búsqueda.
     */
    private int buscarIndice(int id) {
        for (int i = 0; i < size; i++) {
            if (vector[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Pre-condición: ninguna.
     * Post-condición: no se modifica el arreglo; imprime los datos del estudiante
     * si existe, o un aviso de "no encontrado" si no existe.
     */
    public void buscar(int id) {
        int i = buscarIndice(id);
        if (i == -1) {
            System.out.println("No existe un estudiante con id " + id);
        } else {
            System.out.println("Encontrado -> " + vector[i]);
        }
    }

    /**
     * Pre-condición: debe existir un estudiante con el id dado.
     * Acción: se sobrescribe únicamente el atributo promedio de ese estudiante.
     * Post-condición: el promedio cambió a nuevoPromedio; size no se altera
     * y el resto de atributos del estudiante permanecen intactos.
     * @return true si se modificó, false si no existía ese id.
     */
    public boolean modificarPromedio(int id, double nuevoPromedio) {
        int i = buscarIndice(id);
        if (i == -1) {
            System.out.println("No existe un estudiante con id " + id);
            return false;
        }
        vector[i].setPromedio(nuevoPromedio);
        return true;
    }

    /**
     * Pre-condición: debe existir un estudiante con el id dado.
     * Acción: se desplaza cada elemento posterior una posición hacia la izquierda,
     * sobrescribiendo la posición del elemento eliminado.
     * Post-condición: el estudiante ya no aparece en el vector, no queda ningún
     * hueco intermedio (todos los datos válidos siguen contiguos de 0 a size-2),
     * la última posición ocupada queda en null y size disminuye en 1.
     * @return true si se eliminó, false si no existía ese id.
     */
    public boolean eliminar(int id) {
        int i = buscarIndice(id);
        if (i == -1) {
            System.out.println("No existe un estudiante con id " + id);
            return false;
        }
        for (int j = i; j < size - 1; j++) {
            vector[j] = vector[j + 1];
        }
        vector[size - 1] = null;
        size--;
        return true;
    }
}