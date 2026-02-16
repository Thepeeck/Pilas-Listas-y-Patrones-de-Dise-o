package src.main;
public class CalculadoraPostfix implements ICalculadora {
    
    private IPila<Integer> pila;
    
    public CalculadoraPostfix(IPila<Integer> pila) {
        this.pila = pila;
    }
    
    @Override
    public int evaluar(String expresion) {
        pila.vaciar();
        String[] tokens = expresion.trim().split("\\s+");
        
        for (String token : tokens) {
            if (esOperador(token)) {
                if (pila.tamano() < 2) throw new IllegalArgumentException("Faltan operandos.");
                int b = pila.sacar();
                int a = pila.sacar();
                pila.empujar(operar(a, b, token));
            } else {
                try {
                    pila.empujar(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Elemento inválido: " + token);
                }
            }
        }
        if (pila.tamano() != 1) throw new IllegalArgumentException("Expresión mal formada.");
        return pila.sacar();
    }
    
    private boolean esOperador(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int operar(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": if (b==0) throw new ArithmeticException("División por cero"); return a / b;
            default: return 0;
        }
    }
}