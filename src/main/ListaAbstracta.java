package src.main;
public abstract class ListaAbstracta<T> implements ILista<T> {
    protected int cantidad;

    @Override
    public boolean estaVacia() {
        return cantidad == 0;
    }

    @Override
    public int tamano() {
        return cantidad;
    }
}
