package unt.eda.ADT_Fila;

/**
 *  Trabajo Práctico N° 6
 *  Filas
 *  Implementación ADT Fila
 * @author Franco Quevedo
 * @param <T> objeto del cual se creara la fila
 */
public interface IFila<T> {
    public static final String FILA_VACIA = "La fila esta vacia? => ";
    public static final String FILA_VACIA_FRENTE = "No se puede obtener un item de una fila vacia.";
    public static final String FILA_VACIA_DEFILA = "No se puede remover un item de una fila vacia.";
    
    public static final String FILA_ENFILA = "Fue agregado correctamente a la fila el item: ";
    public static final String FILA_FRENTE = "Frente de la fila: ";
    public static final String FILA_DEFILA = "El frente fue removido de la fila.";
    
    public static final String FILA_SEPARADOR = "->";
    
    /**
     * Verifica si una fila es vacia o no
     * @return true si esta vacia
     */
    public boolean esFilaVacia();
    
    /**
     * Obtiene la peticion el frente de la fila
     * @return objeeto al frente de la fila
     */
    public T frente();
    
    /**
     * Agrega la peticion al final de la fila
     * @param objeto a agregar a la fila
     */
    public void enFila(T objeto);
    
    /**
     * Remueve el frente de la fila
     */
    public void deFila();
    
    /**
     * NO es parte de la implementación del ADT!
     * Puesto únicamente para una mejor visualización de los cambios en la fila
     */
    public void mostrarFila();
}