package unt.eda.Pilas;

import java.util.EmptyStackException;

/**
 *  Trabajo Práctico N° 5
  Pilas
  Implementación ADT Pilas
 * @author Franco Quevedo
 */
public class Pilas {
    private Nodo primero;
    private int size = 0; //Tamaño de la pila
    public static final String PILA_VACIA = "La pila está vacía.";

    //Clase interna Nodo
    class Nodo{
        private char caracter;
        private Nodo siguiente;
        
        Nodo(char caracter){
            this.caracter = caracter;
            this.siguiente = null;
        }

        public char getCaracter() {
            return caracter;
        }

        public void setCaracter(char caracter) {
            this.caracter = caracter;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }

    public Pilas() {
        this.primero = null;
    }

    public Nodo getPrimero() {
        return primero;
    }
    
    
    /**
     *  ESPILAVACIA
     * 
     *  Si esta vacia @return true
     *  Si no esta vacia @return false
     */
    public boolean esPilaVacia(){
        return this.primero == null;
    }
    
    
    /**
     * PUSH
     * 
     * Agrega un elemento a la pila
     */
    private void push(char caracter){
        Nodo aux = new Nodo(caracter);
        
        aux.siguiente = this.primero;
        this.primero = aux;
        size++;
    }
    
    public static void push(Pilas pila, char caracter){
        pila.push(caracter);
    }
    
    
    /**
     * POP
     * 
     * Si la pila está vacía tira una excepción
     * Si la pila contiene elementos remueve el último elemento agregado
     */
    private void pop() throws EmptyStackException{
        if (this.esPilaVacia()){
            throw new EmptyStackException();
        }
        else{
            Nodo aux = this.primero.getSiguiente();
            this.primero = aux;
            size--;
        }
    }
    
    public static Pilas pop(Pilas pila){
        try{
            pila.pop();
        }
        catch(EmptyStackException e){
            return new Pilas();
        }
        return pila;
    }
    
    
    /**
     * TOP
     * 
     * Si la pila está vacía tira una excepción
     * Si la pila contiene elementos devuelve el último elemento agregado
     */
    private char top() throws EmptyStackException{
        if (this.esPilaVacia()){
            throw new EmptyStackException();
        }
        else{
            return this.getPrimero().getCaracter();
        }
    }
    
    public static char top(Pilas pila){
        try{
            pila.top();
        }
        catch(EmptyStackException e){
            throw e;
        }
        return pila.getPrimero().getCaracter();
    }
    
    
    
    /**
     * MOSTRARPILA
     * 
     * No es parte de la implementación
     * Sirve para mostrar los elementos de la pila como una lista enlazada
     * pero con el sentido invertido
     */
    private void mostrarPila() throws EmptyStackException{
        Nodo aux = this.primero;
        
        if (this.esPilaVacia()) {
            throw new EmptyStackException();
        } else {
            while(aux != null){ //Recorro la lista imprimiendo en pantalla sus valores
                if (aux.getSiguiente() == null) {
                    System.out.println(aux.getCaracter());
                }
                else{
                    System.out.print(aux.getCaracter() + "<-");
                }
                aux = aux.getSiguiente();
            }
        }
    }
    
    public static void mostrarPila(Pilas pila){
        try{
            pila.mostrarPila();
        }
        catch(EmptyStackException e){
            throw e;
        }
    }
}
