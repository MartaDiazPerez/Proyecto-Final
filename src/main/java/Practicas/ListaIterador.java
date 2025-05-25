package Practicas;

/**
 * Implementación pública de la clase ListaIterador
 * Permite recorrer la lista y eliiminar elementos durante la iteración
 */
public class ListaIterador<T> implements Iterador<T> {

    ListaBasica<T> milista;
    int posElemento = 0;

    /**
     * Constructor que recibe la lista a iterar
     */
    public ListaIterador(ListaBasica<T> lista) {
        this.milista = lista;
    }

    /**
     * Verifica si hay más elementos en la lista.
     * @return true si hay más elementos, false en caso contrario.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        if (posElemento < milista.maxElementos){
            result = milista.elementos[posElemento] != null;
        }
        return result;
    }

    /**
     * Retorna el siguiente elemento de la lista.
     * @return Siguiente elemento en la lista.
     */
    @Override
    public T next() {
        T elemento = null;
        if (hasNext()) {
            elemento = milista.elementos[posElemento];
            posElemento++;
        }
        return elemento;
    }

    /**
     * Elimina el último elemento retornado por next.
     * Evita eliminar más de una vez sin llamar a next de nuevo.
     */
    @Override
    public void delete() {
        this.milista.delete(milista.elementos[posElemento]);
    }
}
