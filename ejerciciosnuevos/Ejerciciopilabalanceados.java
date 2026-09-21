package ejerciciosnuevos; 

import java.util.Stack; 

 
 

public class Ejerciciopilabalanceados { 

    public static boolean esValida(String expr) { 

        Stack<Character> pila = new Stack<>(); 

 
 

        for (char c : expr.toCharArray()) { 

            if (c == '(' || c == '[' || c == '{') { 

                pila.push(c); 

            } else if (c == ')' || c == ']' || c == '}') { 

                if (pila.isEmpty()) return false; 

                char tope = pila.pop(); 

                if ((c == ')' && tope != '(') || 

                    (c == ']' && tope != '[') || 

                    (c == '}' && tope != '{')) { 

                    return false; 

                } 

            } 

        } 

        return pila.isEmpty(); 

    } 

 
 

    public static void main(String[] args) { 

        String entrada = "([{}])"; 

        System.out.println(esValida(entrada) ? "Expresion valida" : "Expresion invalida"); 

    } 

} 

 
 