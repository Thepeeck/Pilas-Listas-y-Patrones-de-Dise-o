package src.main;


public class StackFactory<T> {

    public IPila<T> getPila(String opcionPila, String opcionLista) {
        switch (opcionPila.toUpperCase().trim()) {
            case "AL":
            case "1":
                return new PilaArrayList<>();

            case "V":
            case "2":
                return new PilaVector<>();

            case "L":
            case "3":
                // Se aplica el patrón Factory nuevamente para elegir la lista interna
                ILista<T> lista = FabricaListas.crearLista(opcionLista);
                return new PilaLista<>(lista);

            default:
                // Por defecto se usa ArrayList
                return new PilaArrayList<>();
        }
    }

    public IPila<T> getPila(int opcionPila, int opcionLista) {
        return getPila(String.valueOf(opcionPila), String.valueOf(opcionLista));
    }
}
