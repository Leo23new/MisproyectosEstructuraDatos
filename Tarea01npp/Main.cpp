#include <iostream>
#include <limits>
#include "Estudiante.h"
#include "GestorEstudiantes.h"

using namespace std;

void mostrarMenu() {
    cout << "=== TDA REGISTRO DE ESTUDIANTES ===" << endl;
    cout << "1. Registrar estudiante" << endl;
    cout << "2. Listar estudiantes" << endl;
    cout << "3. Buscar estudiante" << endl;
    cout << "4. Modificar estudiante" << endl;
    cout << "5. Eliminar estudiante" << endl;
    cout << "0. Salir" << endl;
}

void limpiarBuffer() {
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
}

int main() {
    GestorEstudiantes gestor;
    int opcion = -1;

    while (opcion != 0) {
        mostrarMenu();
        cout << "Elige una opción: ";
        cin >> opcion;
        limpiarBuffer();

        if (opcion == 1) {
            int id;
            string nombre;
            double promedio;
            cout << "ID: ";
            cin >> id;
            limpiarBuffer();
            cout << "Nombre: ";
            getline(cin, nombre);
            cout << "Promedio: ";
            cin >> promedio;
            limpiarBuffer();
            gestor.registrar(Estudiante(id, nombre, promedio));

        } else if (opcion == 2) {
            gestor.listar();

        } else if (opcion == 3) {
            int id;
            cout << "ID a buscar: ";
            cin >> id;
            limpiarBuffer();
            gestor.buscar(id);

        } else if (opcion == 4) {
            int id;
            double nuevoPromedio;
            cout << "ID del estudiante a modificar: ";
            cin >> id;
            cout << "Nuevo promedio: ";
            cin >> nuevoPromedio;
            limpiarBuffer();
            gestor.modificarPromedio(id, nuevoPromedio);

        } else if (opcion == 5) {
            int id;
            cout << "ID del estudiante a eliminar: ";
            cin >> id;
            limpiarBuffer();
            gestor.eliminar(id);

        } else if (opcion == 0) {
            cout << "Saliendo del sistema..." << endl;

        } else {
            cout << "Opción inválida, intenta de nuevo." << endl;
        }
        cout << endl;
    }

    return 0;
}