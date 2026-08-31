import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        // Capacidad fija del arreglo estático: 30 (suficiente para los 28 estudiantes de 3B)
        GestorEstudiantes gestor = new GestorEstudiantes(30);

        int opcion = -1;
        while (opcion != 0) {
            mostrarMenu();
            opcion = leerEntero(sc, "Elige una opción: ");

            switch (opcion) {
                case 1:
                    registrarDesdeMenu(sc, gestor);
                    break;
                case 2:
                    gestor.listar();
                    break;
                case 3:
                    int idBuscar = leerEntero(sc, "ID a buscar: ");
                    gestor.buscar(idBuscar);
                    break;
                case 4:
                    int idModificar = leerEntero(sc, "ID del estudiante a modificar: ");
                    double nuevoPromedio = leerDecimal(sc, "Nuevo promedio: ");
                    gestor.modificarPromedio(idModificar, nuevoPromedio);
                    break;
                case 5:
                    int idEliminar = leerEntero(sc, "ID del estudiante a eliminar: ");
                    gestor.eliminar(idEliminar);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }
            System.out.println();
        }

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("=== TDA REGISTRO DE ESTUDIANTES ===");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Listar estudiantes");
        System.out.println("3. Buscar estudiante");
        System.out.println("4. Modificar estudiante");
        System.out.println("5. Eliminar estudiante");
        System.out.println("0. Salir");
    }

    private static void registrarDesdeMenu(Scanner sc, GestorEstudiantes gestor) {
        int id = leerEntero(sc, "ID: ");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        double promedio = leerDecimal(sc, "Promedio: ");
        gestor.registrar(new Estudiante(id, nombre, promedio));
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        int valor = Integer.parseInt(sc.nextLine().trim());
        return valor;
    }

    private static double leerDecimal(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        double valor = Double.parseDouble(sc.nextLine().trim());
        return valor;
    }
}