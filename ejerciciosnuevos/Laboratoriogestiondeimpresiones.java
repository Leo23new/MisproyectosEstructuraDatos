package ejerciciosnuevos;

import java.util.ArrayDeque; 
import java.util.Deque; 

public class Laboratoriogestiondeimpresiones { 

    static Deque<String> pendientes = new ArrayDeque<>(); 

    static Deque<String> historial = new ArrayDeque<>(); 

    public static void registrarDocumento(String nombre) { 

        pendientes.offerLast(nombre); 

        System.out.println("Registrado: " + nombre); 

    } 

    public static void imprimirSiguiente() { 

        if (pendientes.isEmpty()) { 

            System.out.println("No hay documentos pendientes."); 

            return; 

        } 

        String doc = pendientes.pollFirst(); 

        System.out.println("Imprimiendo: " + doc); 

        historial.push(doc); 

    } 

    public static void recuperarUltima() { 

        if (historial.isEmpty()) { 

            System.out.println("No hay documentos en el historial."); 

            return; 

        } 

        String doc = historial.pop(); 

        pendientes.addFirst(doc); 

        System.out.println("Recuperado: " + doc); 

    } 

 
 

    public static void mostrarEstado() { 

        System.out.println("Pendientes: " + pendientes); 

        System.out.println("Historial: " + historial); 

        System.out.println("-----"); 

    } 

 
 

    public static void main(String[] args) { 

        registrarDocumento("Doc1"); 

        registrarDocumento("Doc2"); 

        registrarDocumento("Doc3"); 

        mostrarEstado(); 

 
 

        imprimirSiguiente(); 

        imprimirSiguiente(); 

        mostrarEstado(); 

 
 

        recuperarUltima(); 

        mostrarEstado(); 

 
 

        imprimirSiguiente(); 

        imprimirSiguiente(); 

        mostrarEstado(); 

 
 

        imprimirSiguiente(); 

    } 

} 

 
 

 