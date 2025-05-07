public interface IInventario {
    void agregarItem(IItem item);
    void quitarItem(IItem item);
    List<IItem> obtenerItemsActivos();
}
