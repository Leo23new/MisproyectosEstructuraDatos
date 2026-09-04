public class ListaEstudiantes {

    private Estudiante[] datos;
    private int cantidad;

    public ListaEstudiantes(int n) {
        datos = new Estudiante[n];
        cantidad = 0;
    }

    // Insertar al final
    public void insertar(Estudiante estudiante) {

        if (cantidad >= datos.length) {
            System.out.println("La lista está llena.");
            return;
        }

        datos[cantidad] = estudiante;
        cantidad++;
    }

    // Insertar en una posición
    public void insertar(int posicion, Estudiante estudiante) {

        if (cantidad >= datos.length) {
            System.out.println("La lista está llena.");
            return;
        }

        if (posicion < 0 || posicion > cantidad) {
            System.out.println("Posición inválida.");
            return;
        }

        for (int i = cantidad; i > posicion; i--) {
            datos[i] = datos[i - 1];
        }

        datos[posicion] = estudiante;
        cantidad++;
    }

    // Obtener por posición
    public Estudiante obtener(int posicion) {

        if (posicion < 0 || posicion >= cantidad) {
            return null;
        }

        return datos[posicion];
    }

    // Buscar por cédula
    public Estudiante buscarPorCedula(String cedula) {

        for (int i = 0; i < cantidad; i++) {

            if (datos[i].getCedula().equals(cedula)) {
                return datos[i];
            }
        }

        return null;
    }

    // Buscar por nombre
    public Estudiante buscarPorNombre(String nombre) {

        for (int i = 0; i < cantidad; i++) {

            if (datos[i].getNombre().equalsIgnoreCase(nombre)) {
                return datos[i];
            }
        }

        return null;
    }

    // Promedio general
    public double promedioGeneral() {

        if (cantidad == 0) {
            return 0;
        }

        double suma = 0;

        for (int i = 0; i < cantidad; i++) {
            suma += datos[i].promedioIndividual();
        }

        return suma / cantidad;
    }
    public int contarAprobados() {

    int aprobados = 0;

    for (int i = 0; i < cantidad; i++) {

        if (datos[i].promedioIndividual() >= 7.0) {
            aprobados++;
        }
    }

    return aprobados;
}
public Estudiante mayorPromedio() {

    if (cantidad == 0) {
        return null;
    }

    Estudiante mayor = datos[0];

    for (int i = 1; i < cantidad; i++) {

        if (datos[i].promedioIndividual() > mayor.promedioIndividual()) {
            mayor = datos[i];
        }
    }

    return mayor;
}
   public void insertarOrdenado(Estudiante estudiante) {

    if (cantidad >= datos.length) {
        System.out.println("La lista está llena.");
        return;
    }

    int posicion = 0;

    while (posicion < cantidad &&
           datos[posicion].getCedula().compareTo(estudiante.getCedula()) < 0) {
        posicion++;
    }

    System.arraycopy(
        datos,
        posicion,
        datos,
        posicion + 1,
        cantidad - posicion
    );

    datos[posicion] = estudiante;

    cantidad++;
} 
}