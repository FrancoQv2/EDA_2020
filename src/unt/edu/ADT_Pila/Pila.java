package unt.edu.ADT_Pila;

import java.util.EmptyStackException;

/**
 *  Trabajo Práctico N° 5
 *  Pilas
 *  Implementación ADT Pila
 * @author Franco Quevedo
 * @param <T> objeto del cual se creara la pila
 */
public class Pila<T> implements IPila<T> {
    private Nodo primero;
    private int size = 0; //Tamaño de la pila

    /**
     * Clase interna Nodo
     * 
     * Necesaria para operar el objeto del cual estara compuesta la pila
     */
    class Nodo<T> {
        private T objeto;
        private Nodo siguiente;
        
        Nodo(T objeto){
            this.objeto = objeto;
            this.siguiente = null;
        }

        public T getObjeto() {
            return objeto;
        }

        public void setObjeto(T objeto) {
            this.objeto = objeto;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }

    public Pila() {
        this.primero = primero;
    }
    

    public Nodo getPrimero() {
        return primero;
    }

    public int getSize() {
        return size;
    }
    
    
    /**
     *  ESPILAVACIA
     * 
     *  Si esta vacia @return true
     *  Si no esta vacia @return false
     */
    @Override
    public boolean esPilaVacia() {
        return this.primero == null;
    }


    /**
     * PUSH
     * 
     * Agrega un elemento a la pila
     */
    @Override
    public void push(T objeto) {
        Nodo aux = new Nodo(objeto);
        
        aux.siguiente = this.primero;
        this.primero = aux;
        size++;
    }

    
    /**
     * POP
     * 
     * Si la pila está vacía tira una excepción
     * Si la pila contiene elementos remueve el último elemento agregado
     */
    @Override
    public void pop() throws EmptyStackException {
        if (this.esPilaVacia()){
            throw new EmptyStackException();
        }
        else{
            Nodo aux = this.primero.getSiguiente();
            this.primero = aux;
            size--;
        }
    }
    
    
    /**
     * TOP
     * 
     * Si la pila está vacía tira una excepción
     * Si la pila contiene elementos devuelve el último elemento agregado
     */
    @Override
    public T top() throws EmptyStackException {
        if (this.esPilaVacia()){
            throw new EmptyStackException();
        }
        else{
            return (T) this.getPrimero().getObjeto();
        }
    }

    
    /**
     * MOSTRARPILA
     * 
     * No es parte de la implementación
     * Sirve para mostrar los elementos de la pila como una lista enlazada
     * pero con el sentido invertido
     */
    @Override
    public void mostrarPila() {
        Nodo aux = this.primero;
        
        if (this.esPilaVacia()) {
            throw new EmptyStackException();
        } else {
            while(aux != null){ //Recorro la lista imprimiendo en pantalla sus valores
                if (aux.getSiguiente() == null) {
                    System.out.println(aux.getObjeto().toString());
                }
                else{
                    System.out.print(aux.getObjeto().toString() + "<-");
                }
                aux = aux.getSiguiente();
            }
        }
    }
}