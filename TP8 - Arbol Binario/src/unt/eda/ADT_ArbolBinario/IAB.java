package unt.eda.ADT_ArbolBinario;

/**
 *  Trabajo Práctico N° 8
 *  Arbol Binario
 *  Implementación ADT Arbol Binario
 * @author Franco Quevedo
 * @param <T>
 */
public interface IAB<T> {
    public static final String AB_VACIO = "El Arbol Binario esta vacio? => ";
    public static final String AB_ARMAR = "Fue agregado correctamente al AB el item: ";
    public static final String AB_SI_PERTENECE = "Si pertenece al AB el item: ";
    public static final String AB_NO_PERTENECE = "No pertenece al AB el item: ";
    public static final String AB_VACIO_PERTENECE = "Un AB vacio no tiene elementos";
    
    /**
     *
     * @return true si es AB esta vacio
     */
    public boolean esABVacio();
    
    /**
     *
     * @param item
     * @return true si el item pertenece al AB
     */
    public boolean pertenece(T item);
    
    /**
     *
     * @return el AB izquierdo del AB analizado
     */
    public AB izquierdo();
    
    /**
     *
     * @return la raiz del AB analizado
     */
    public T raiz();
    
    /**
     *
     * @return el AB derecho del AB analizado
     */
    public AB derecho();
    
}
