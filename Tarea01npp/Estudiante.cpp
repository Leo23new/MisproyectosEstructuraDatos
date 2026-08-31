#include "Estudiante.h"

Estudiante::Estudiante() : id(-1), nombre(""), promedio(0.0) {}

Estudiante::Estudiante(int id, const std::string& nombre, double promedio)
    : id(id), nombre(nombre), promedio(promedio) {}

int Estudiante::getId() const {
    return id;
}

std::string Estudiante::getNombre() const {
    return nombre;
}

double Estudiante::getPromedio() const {
    return promedio;
}

void Estudiante::setPromedio(double promedio) {
    this->promedio = promedio;
}

std::string Estudiante::toString() const {
    return "ID: " + std::to_string(id) + " | Nombre: " + nombre +
           " | Promedio: " + std::to_string(promedio);
}