package src.main;


public class FabricaListas {

    public static <T> ILista<T> crearLista(String opcion) {
        switch (opcion.toUpperCase().trim()) {
            case "D":
            case "2":
                return new ListaDoble<>();
            case "S":
            case "1":
            default:
                return new ListaSimple<>();
        }
    }

    /**
     * Sobrecarga con int para compatibilidad con el código existente.
     */
    public static <T> ILista<T> crearLista(int opcion) {
        return crearLista(String.valueOf(opcion));
    }
}