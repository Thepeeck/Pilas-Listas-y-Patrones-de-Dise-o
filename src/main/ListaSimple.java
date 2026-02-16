package src.main;

public class ListaSimple<T> extends ListaAbstracta<T> {
    private Nodo<T> cabeza;

    @Override
    public void agregarInicio(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        cantidad++;
    }

    @Override
    public T eliminarInicio() {
        if (estaVacia()) return null;
        T valor = cabeza.valor;
        cabeza = cabeza.siguiente;
        cantidad--;
        return valor;
    }

    @Override
    public T obtenerInicio() {
        if (estaVacia()) return null;
        return cabeza.valor;
    }
}