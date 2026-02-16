
public class PilaLista<T> extends PilaAbstracta<T> {
    private ILista<T> listaInterna;

    public PilaLista(ILista<T> implementacionLista) {
        this.listaInterna = implementacionLista;
    }

    @Override
    public void empujar(T valor) {
        listaInterna.agregarInicio(valor);
    }

    @Override
    public T sacar() {
        return listaInterna.eliminarInicio();
    }

    @Override
    public T verUltimo() {
        return listaInterna.obtenerInicio();
    }

    @Override
    public int tamano() {
        return listaInterna.tamano();
    }

    @Override
    public void vaciar() {
        while (!listaInterna.estaVacia()) {
            listaInterna.eliminarInicio();
        }
    }
}