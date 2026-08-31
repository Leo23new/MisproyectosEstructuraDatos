/**
 * Representa a un estudiante dentro del sistema.
 * Es un objeto simple (sin lógica de arreglo): solo guarda sus propios datos.
 */
public class Estudiante {

    private int id;
    private String nombre;
    private double promedio;

    public Estudiante(int id, String nombre, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Promedio: " + promedio;
    }
}