package Practicas;

class ElementoDiccionario<K,V> {
    K clave;
    V valor;
    ElementoDiccionario<K,V> siguiente;
    ElementoDiccionario<K,V> anterior;

    public ElementoDiccionario(K clave,V valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }
}
