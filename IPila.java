public interface IPila<T> {

    void empujar(T valor); // push
    
    T sacar();             // pop
    
    T verUltimo();         // peek
    
    boolean estaVacia();   // isEmpty
    
    int tamano();          // size
    
    void vaciar();         // clear

}