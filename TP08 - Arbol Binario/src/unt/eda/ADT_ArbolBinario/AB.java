package unt.eda.ADT_ArbolBinario;

/**
 *  Trabajo Práctico N° 8
 *  Arbol Binario
 *  Implementación ADT Arbol Binario
 * @author Franco Quevedo
 * @param <T> 
 */
public class AB<T> implements IAB<T> {
    private T raiz;
    private AB left;
    private AB right;

    
    private AB() {
        this.raiz = null;
    }
    
    
    public static AB ABVacio() {
        return new AB();
    }
    
    
    public static <T> AB armarAB(AB izq, T item, AB der) {
        if (item == null) {
            return null;
        }
        AB nuevoAB = ABVacio();
        
        if (izq == null) {
            nuevoAB.left = ABVacio();
        } else {
            nuevoAB.left = izq;
        }
        
        if (der == null) {
            nuevoAB.right = ABVacio();
        } else {
            nuevoAB.right = der;
        }
        
        nuevoAB.raiz = item;
        
        return nuevoAB;
    }

    @Override
    public boolean esABVacio() {
        return this.raiz == null;
    }

    @Override
    public boolean pertenece(T item) {
        if (this.esABVacio()) {
            return false;
        }
        if (this.raiz.equals(item)) {
            return true;
        }
        return this.izquierdo().pertenece(item) || this.derecho().pertenece(item);
    }

    @Override
    public AB izquierdo() {
        return this.left;
    }
    
    @Override
    public T raiz() {
        return (T) this.raiz;
    }

    @Override
    public AB derecho() {
        return this.right;
    }
    
    
    /**
     * PreOrden
     * 
     * Muestra un AB ordenado por el recorrido PreOrden
     */
    public void preOrden() {
        if (this.esABVacio() == false) {
            System.out.print(raiz + " ");
            izquierdo().preOrden();
            derecho().preOrden();
        }
    }

    /**
     * enOrden
     * 
     * Muestra un AB ordenado por el recorrido enOrden
     */
    public void enOrden() {
        if (this.esABVacio() == false) {
            izquierdo().enOrden();
            System.out.print(raiz + " ");
            derecho().enOrden();
        }
    }

    /**
     * posOrden
     * 
     * Muestra un AB ordenado por el recorrido posOrden
     */
    public void posOrden() {
        if (this.esABVacio() == false) {
            izquierdo().posOrden();
            derecho().posOrden();
            System.out.print(raiz + " ");
        }
    }
}
