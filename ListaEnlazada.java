import java.util.Scanner;

public class ListaEnlazada {

    
    static class Nodo {
        int dato;
        Nodo siguiente;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        Nodo cabeza = null;

        System.out.println("Numero de elementos: ");
        int numElemento = sc.nextInt();

        for (int contador = 0; contador < numElemento; contador++) {
            System.out.println("Elemento:" + (contador + 1));

         
            Nodo nuevo = new Nodo();
            nuevo.dato = sc.nextInt();

        
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        }

        
        System.out.println("\nListado: ");
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }

        sc.close();
    }
}