package Clases;

public class Unidad {
    protected  int hp;
    protected int ataque;
    protected int defensa;
    protected int rangoMovimiento;
    protected int rangoAtaque;
    //posicion en el tablero
    protected int x, y;
    protected String nombre;
    // constructor
    public Unidad(int hp, int ataque, int defensa, int rangoMovimiento, int rangoAtaque, String nombre) {
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.rangoMovimiento = rangoMovimiento;
        this.rangoAtaque = rangoAtaque;
        this.nombre = nombre;
    }

    public void recibirDanio( int danio){
        try {
            int factor = (int)(Math.random() * 3);
            danio = factor * 2 - defensa;

            // Si el daño calculado es negativo, lo forzamos a cero
            if (danio < 0) {
                throw new IllegalArgumentException("El daño no puede ser negativo");
            }

        } catch (IllegalArgumentException e) {
            danio = 0;
        }

        this.hp = hp - danio;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public int getHp() {
        return hp;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setPosicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getRangoMovimiento(){
        return rangoMovimiento;
    }
    public int getRangoAtaque(){
        return rangoAtaque;
    }
    public int getDefensa(){
        return defensa;
    }
    public int getAtaque(){
        return ataque;
    }
    public String getNombre(String nombre){
        return nombre;
    }








}
