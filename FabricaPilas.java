package src.main;
public class FabricaPilas {
    // tipoPila: 1=ArrayList, 2=Vector, 3=Lista
    // tipoLista: 1=Simple, 2=Doble
    public static <T> IPila<T> crearPila(int tipoPila, int tipoLista) {
        switch (tipoPila) {
            case 1: return new PilaArrayList<>();
            case 2: return new PilaVector<>();
            case 3:
                ILista<T> lista;
                if (tipoLista == 2) lista = new ListaDoble<>();
                else lista = new ListaSimple<>();
                return new PilaLista<>(lista);
            default: return new PilaArrayList<>();
        }
    }
}