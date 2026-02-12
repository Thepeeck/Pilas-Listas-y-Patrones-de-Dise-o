package src.main;

import java.util.Vector;

public class PilaVector<T> extends PilaAbstracta<T> {
    
    private Vector<T> elementos;

    public PilaVector() {
        elementos = new Vector<>();
    }

    @Override
    public void empujar(T valor) {
        elementos.add(valor);
    }

    @Override
    public T sacar() {
        if (estaVacia()) return null;
        return elementos.remove(elementos.size() - 1);
    }

    @Override
    public T verUltimo() {
        if (estaVacia()) return null;
        return elementos.lastElement();
    }

    @Override
    public int tamano() {
        return elementos.size();
    }

    @Override
    public void vaciar() {
        elementos.clear();
    }
}
