public class BusquedaLineal implements Busqueda {
    @Override
    public int buscar(int[] arreglo, int valor) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == valor) {
                return i; // Devuelve la posición
            }
        }
        return -1; // No encontrado
    }
}
