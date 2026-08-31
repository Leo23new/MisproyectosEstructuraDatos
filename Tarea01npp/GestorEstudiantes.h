#ifndef GESTORESTUDIANTES_H
#define GESTORESTUDIANTES_H

#include "Estudiante.h"

/**
 * TDA Registro de Estudiantes.
 * Implementado sobre un arreglo estático (capacidad fija en memoria, tamaño
 * definido en tiempo de compilación con una constante o en el constructor).
 * 'size' es el dato lógico que indica cuántos estudiantes hay realmente
 * registrados en este momento; 'capacidad' es el tamaño físico del arreglo
 * y nunca cambia después de crear el objeto. Este es el TDA estático con CRUD
 * (equivalente exacto de GestorEstudiantes.java).
 */
class GestorEstudiantes {
private:
    static const int CAPACIDAD_MAXIMA = 30; // arreglo estático: tamaño fijo en compilación (30, suficiente para los 28 estudiantes de 3B)
    Estudiante vector[CAPACIDAD_MAXIMA];
    int size;

    // Pre-condición: ninguna.
    // Post-condición: no se modifica el arreglo; retorna el índice del
    // estudiante con ese id, o -1 si no existe.
    int buscarIndice(int id) const;

public:
    GestorEstudiantes();

    // Pre-condición: size < CAPACIDAD_MAXIMA Y no debe existir otro estudiante con el mismo id.
    // Acción: se guarda el nuevo estudiante en vector[size].
    // Post-condición: el estudiante queda registrado y size se incrementa en 1.
    // Retorna true si se registró correctamente, false si estaba lleno o el id ya existía.
    bool registrar(const Estudiante& nuevo);

    // Pre-condición: ninguna.
    // Post-condición: no se modifica el arreglo; se imprimen todos los
    // estudiantes registrados, recorriendo únicamente de 0 a size-1.
    void listar() const;

    // Pre-condición: ninguna.
    // Post-condición: no se modifica el arreglo; imprime los datos del
    // estudiante si existe, o un aviso de "no encontrado" si no existe.
    void buscar(int id) const;

    // Pre-condición: debe existir un estudiante con el id dado.
    // Post-condición: el promedio cambió a nuevoPromedio; size no se altera.
    bool modificarPromedio(int id, double nuevoPromedio);

    // Pre-condición: debe existir un estudiante con el id dado.
    // Post-condición: el estudiante ya no aparece en el vector, no queda
    // ningún hueco intermedio, y size disminuye en 1.
    bool eliminar(int id);
};

#endif