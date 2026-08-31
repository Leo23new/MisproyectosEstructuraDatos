#include "GestorEstudiantes.h"
#include <iostream>

GestorEstudiantes::GestorEstudiantes() : size(0) {}

int GestorEstudiantes::buscarIndice(int id) const {
    for (int i = 0; i < size; i++) {
        if (vector[i].getId() == id) {
            return i;
        }
    }
    return -1;
}

bool GestorEstudiantes::registrar(const Estudiante& nuevo) {
    if (buscarIndice(nuevo.getId()) != -1) {
        std::cout << "Error: ya existe un estudiante con el id " << nuevo.getId() << std::endl;
        return false;
    }
    if (size >= CAPACIDAD_MAXIMA) {
        std::cout << "Error: no hay espacio disponible (capacidad máxima alcanzada)." << std::endl;
        return false;
    }
    vector[size] = nuevo;
    size++;
    return true;
}

void GestorEstudiantes::listar() const {
    if (size == 0) {
        std::cout << "No hay estudiantes registrados." << std::endl;
        return;
    }
    for (int i = 0; i < size; i++) {
        std::cout << (i + 1) << ". " << vector[i].toString() << std::endl;
    }
}

void GestorEstudiantes::buscar(int id) const {
    int i = buscarIndice(id);
    if (i == -1) {
        std::cout << "No existe un estudiante con id " << id << std::endl;
    } else {
        std::cout << "Encontrado -> " << vector[i].toString() << std::endl;
    }
}

bool GestorEstudiantes::modificarPromedio(int id, double nuevoPromedio) {
    int i = buscarIndice(id);
    if (i == -1) {
        std::cout << "No existe un estudiante con id " << id << std::endl;
        return false;
    }
    vector[i].setPromedio(nuevoPromedio);
    return true;
}

bool GestorEstudiantes::eliminar(int id) {
    int i = buscarIndice(id);
    if (i == -1) {
        std::cout << "No existe un estudiante con id " << id << std::endl;
        return false;
    }
    for (int j = i; j < size - 1; j++) {
        vector[j] = vector[j + 1];
    }
    vector[size - 1] = Estudiante(); // limpia la última posición (equivalente a null)
    size--;
    return true;
}