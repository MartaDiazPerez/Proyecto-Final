package Practicas;

/**
 * Implementación de una lista básica usando ArrayLista
 * Permite agregar, eliminar elementos y obtener un iterador
 */
public class ListaBasica<T> implements Lista<T> {

    int maxElementos;
    int numElementos = 0;
    T[] elementos;

    /**
     * Constructor: Inicializa la lista como un ArrayList vacío
     */
    public ListaBasica(int tamano_max) {
        this.maxElementos = tamano_max;
        this.elementos = (T[]) new Object[tamano_max];
    }
    public ListaBasica(){}

    /***
     *Agrega in elemento a la lista
     * @param elemento Elemento a agregar
     * @return true si se agregó correctamente
     */
    @Override
    public boolean add(T elemento) {
        boolean result=false;
        if (numElementos<maxElementos){
            this.elementos[getNumElementos()] = elemento;
            this.numElementos = this.numElementos + 1;
            result=true;
        }
        return result;
    }

    /**
     * Elimina un elemento de la lista
     * @param elemento Elemento a eliminar.
     * @return true si el elemento estaba en la lista y fue eliminado
     */
    @Override
    public boolean delete(T elemento) {
        boolean result=false;
        if (numElementos != 0){
            int pos = 0;
            for (T i: this.elementos){
                if (i == elemento){
                    this.elementos[pos] = null;
                    this.elementos[pos]= this.elementos[numElementos-1];
                    this.elementos[numElementos-1] = null;
                    result = true;
                    numElementos = numElementos - 1;
                }
                pos++;
            }
        }
        return result;
    }

    /**
     * Retorna un iterador para recorrer la lista
     * @return Iterador de la lista
     */
    @Override
    public Iterador<T> getIterador() {
        return new ListaIterador(this);
    }

    /**
     * Retorna el número de elementos en la lista.
     * @return Cantidad de elementos en la lista.
     */
    @Override
    public int getNumElementos() {
        return this.numElementos;
    }

    @Override
    public T get(int i) {
        return null;
    }

}
