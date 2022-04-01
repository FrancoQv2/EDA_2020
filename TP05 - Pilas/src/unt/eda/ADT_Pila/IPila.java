package unt.edu.ADT_Pila;

/**
 *  Trabajo Práctico N° 5
 *  Pilas
 *  Implementación ADT Pila
 * @author Franco Quevedo
 * @param <T> objeto del cual se creara la pila
 */
public interface IPila<T> {
    public static final String PILA_VACIA = "La pila esta vacia? => ";
    public static final String PILA_TOP_VACIA = "No se puede obtener un item de una pila vacia.";
    public static final String PILA_POP_VACIA = "No se puede remover un item de una pila vacia.";
    
    public static final String PILA_PUSH = "Fue agregado correctamente a la pila el item: ";
    public static final String PILA_TOP = "Top de la pila: ";
    public static final String PILA_POP = "El top fue removido de la pila.";
    
    /**
     *  ESPILAVACIA
     * 
     * @return true si esta vacia
     */
    public boolean esPilaVacia();
    
    /**
     * PUSH
     * 
     * Agrega un elemento a la pila
     * @param objeto
     */
    public void push(T objeto);
    
    /**
     * POP
     * 
     * Si la pila está vacía tira una excepción
     * Si la pila contiene elementos remueve el último elemento agregado
     */
    public void pop();
    
    /**
     * TOP
     * 
     * Si la pila está vacía tira una excepción
     * Si la pila contiene elementos devuelve el último elemento agregado
     * @return objeto del top de la pila
     */
    public T top();
    
    /**
     * MOSTRARPILA
     * 
     * No es parte de la implementación
     * Sirve para mostrar los elementos de la pila como una lista enlazada
     * pero con el sentido invertido
     */
    public void mostrarPila();
}
