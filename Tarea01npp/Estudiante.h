#ifndef ESTUDIANTE_H
#define ESTUDIANTE_H

#include <string>

/**
 * Representa a un estudiante dentro del sistema.
 * Es un objeto simple (sin lógica de arreglo): solo guarda sus propios datos.
 * Equivalente directo de la clase Estudiante.java.
 */
class Estudiante {
private:
    int id;
    std::string nombre;
    double promedio;

public:
    Estudiante(); // constructor por defecto, necesario para el arreglo estático
    Estudiante(int id, const std::string& nombre, double promedio);

    int getId() const;
    std::string getNombre() const;
    double getPromedio() const;
    void setPromedio(double promedio);

    std::string toString() const;
};

#endif