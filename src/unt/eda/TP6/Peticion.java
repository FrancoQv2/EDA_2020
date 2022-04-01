package unt.eda.TP6;

/**
 *  Trabajo Práctico N° 6
 *  Filas
 *  Implementación ADT Fila
 * @author Franco Quevedo
 */
public class Peticion {
    private int tiempo;
    private int t_in;

    //CONSTRUCTOR
    public Peticion(int tiempo, int t_in) {
        this.tiempo = tiempo; //tiempo de proceso que requiere la peticion
        this.t_in = t_in; //instante de tiempo en que ingresa la peticion
    }

    //GETTER AND SETTER
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getT_in() {
        return t_in;
    }

    public void setT_in(int t_in) {
        this.t_in = t_in;
    }

    @Override
    public String toString() {
        return "[ " + this.getTiempo() + " , " + this.getT_in() + " ]"; //To change body of generated methods, choose Tools | Templates.
    }
}