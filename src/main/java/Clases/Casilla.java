package Clases;

import Interfaces.ICasilla;

public class Casilla {
    public int x,y;
    public boolean ocupada;
    public int costeMovimiento;
    public int defensaExtra;
    public int ataqueExtra;

    public Casilla(int x, int y, int costeMovimiento, int defensaExtra, int ataqueExtra, boolean ocupada) {
        this.x = x;
        this.y = y;
        this.costeMovimiento = costeMovimiento;
        this.defensaExtra = defensaExtra;
        this.ataqueExtra = ataqueExtra;
        this.ocupada = false;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public void ocupar(){
        ocupada = true;
    }

    public void desocupar(){
        ocupada = false;
    }

    public int getCosteMovimiento() {
        return costeMovimiento;
    }
    public void setCosteMovimiento(int costeMovimiento) {
        this.costeMovimiento = costeMovimiento;
    }
    public int getDefensaExtra() {
        return defensaExtra;
    }
    public void setDefensaExtra(int defensaExtra) {
        this.defensaExtra = defensaExtra;
    }
    public int getAtaqueExtra() {
        return ataqueExtra;
    }
    public void setAtaqueExtra(int ataqueExtra) {
        this.ataqueExtra = ataqueExtra;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }
    //posicion xy
    public void setPosicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getPosicionX() {
        return x;
    }
    public int getPosicionY() {
        return y;
    }
    public int[] getPosicionXY(){
        return new int[]{x, y};
    }
}
