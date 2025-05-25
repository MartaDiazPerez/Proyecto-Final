package Interfaces;

import Practicas.Lista;

public interface IInventario {
    void agregarItem(IItem item);
    void quitarItem(IItem item);
    Lista<IItem> obtenerItemsActivos();
}
