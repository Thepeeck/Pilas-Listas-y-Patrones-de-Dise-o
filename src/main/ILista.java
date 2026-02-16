package src.main;
public interface ILista<T> {
    void agregarInicio(T valor);
    T eliminarInicio();
    T obtenerInicio();
    boolean estaVacia();
    int tamano();
}