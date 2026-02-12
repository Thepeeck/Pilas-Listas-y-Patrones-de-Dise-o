package src.main;

public abstract class PilaAbstracta<T> implements IPila<T> {

    @Override
    public boolean estaVacia() {
        return tamano() == 0;
    }
    
}
