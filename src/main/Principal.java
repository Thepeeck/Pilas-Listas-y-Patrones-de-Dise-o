package src.main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Calculadora de Expresiones Infix a Postfix ---");
        System.out.println("Seleccione la implementación de la Pila:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista (Encadenada)");
        int opcionPila = scanner.nextInt();
        
        int opcionLista = 0;
        if (opcionPila == 3) {
            System.out.println("  > Seleccione el tipo de Lista:");
            System.out.println("  1. Simplemente Encadenada");
            System.out.println("  2. Doblemente Encadenada");
            opcionLista = scanner.nextInt();
        }

        StackFactory<Character> fabricaChar = new StackFactory<>();
        StackFactory<Integer> fabricaInt  = new StackFactory<>();

        IPila<Character> pilaConversion = fabricaChar.getPila(opcionPila, opcionLista);
        IPila<Integer>   pilaCalculo    = fabricaInt.getPila(opcionPila, opcionLista);
        
        ICalculadora calculadora = new CalculadoraPostfix(pilaCalculo);
        
        try (BufferedReader lector = new BufferedReader(new FileReader("dato.txt"))) { 
            //para que funcione el codigo, se necesita que se lea popor medio de los archivos de compu, dandole copy path al archivo txt, y pegandolo en el codigo, reemplazando el dato.txt
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    System.out.println("\n------------------------------------------------");
                    System.out.println("Expresión Infix: " + linea);
                    
                    String postfix = ConversorInfixPostfix.convertir(linea, pilaConversion);
                    System.out.println("Traducido a Postfix: " + postfix);
                    
                    try {
                        int resultado = calculadora.evaluar(postfix);
                        System.out.println("Resultado: " + resultado);
                    } catch (Exception e) {
                        System.err.println("Error al evaluar: " + e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        }
        scanner.close();
    }
}