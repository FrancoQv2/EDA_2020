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
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.t_in;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Peticion other = (Peticion) obj;
        if (this.t_in != other.t_in) {
            return false;
        }
        return true;
    }
}