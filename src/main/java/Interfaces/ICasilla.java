package Interfaces;

public interface ICasilla {
    boolean estaOcupada();
    void ocupar();
    void desocupar();

    int getCosteMovimiento();
    void setCosteMovimiento(int costeMovimiento);

    int getDefensaExtra();
    void setDefensaExtra(int defensaExtra);

    int getAtaqueExtra();
    void setAtaqueExtra(int ataqueExtra);

    int getX();
    int getY();
    void setPosicion(int x, int y);
}
