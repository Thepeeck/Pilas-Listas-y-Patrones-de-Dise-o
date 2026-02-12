package src.main;

import java.util.ArrayList;

public class PilaArrayList<T> extends PilaAbstracta<T> {

    private ArrayList<T> elementos;

    public PilaArrayList() {
        elementos = new ArrayList<>();
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
        return elementos.get(elementos.size() - 1);
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
