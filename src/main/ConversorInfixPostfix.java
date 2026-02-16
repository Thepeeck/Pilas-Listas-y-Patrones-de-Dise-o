package src.main;
public class ConversorInfixPostfix {
    
    private static int precedencia(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    }

    public static String convertir(String expresion, IPila<Character> pila) {
        StringBuilder resultado = new StringBuilder();
        pila.vaciar();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                resultado.append(c);
                // Agregar espacio si el siguiente no es dígito (para números de varias cifras)
                if (i + 1 >= expresion.length() || !Character.isDigit(expresion.charAt(i + 1))) {
                    resultado.append(" ");
                }
            }
            else if (c == '(') {
                pila.empujar(c);
            }
            else if (c == ')') {
                while (!pila.estaVacia() && pila.verUltimo() != '(') {
                    resultado.append(pila.sacar()).append(" ");
                }
                if (!pila.estaVacia()) pila.sacar(); // Sacar '('
            }
            else if ("+-*/^".indexOf(c) >= 0) { // Es operador
                while (!pila.estaVacia() && precedencia(c) <= precedencia(pila.verUltimo())) {
                    resultado.append(pila.sacar()).append(" ");
                }
                pila.empujar(c);
            }
        }

        while (!pila.estaVacia()) {
            if (pila.verUltimo() == '(') return "Error: Paréntesis no balanceados";
            resultado.append(pila.sacar()).append(" ");
        }
        return resultado.toString().trim();
    }
}