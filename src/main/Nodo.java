package src.main;
public class Nodo<T> {
    T valor;
    Nodo<T> siguiente;
    Nodo<T> anterior; // Solo para la doblemente encadenada

    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }
}