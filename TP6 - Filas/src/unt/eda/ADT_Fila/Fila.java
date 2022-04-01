package unt.eda.ADT_Fila;

/**
 *  Trabajo Práctico N° 6
 *  Filas
 *  Implementación ADT Fila
 * @author Franco Quevedo
 * @param <T> objeto del cual se creara la fila
 */
public class Fila<T> implements IFila<T> {
    private Item frente;
    private Item cola;
    private int size = 0; //Tamaño de la fila

    /**
     * Clase interna Item
     * 
     * Necesaria para operar el objeto del cual estara compuesta la fila
     */
    private class Item<T> {
        private T objeto;
        private Item siguiente;
        
        Item(T objeto) {
            this.objeto = objeto;
            this.siguiente = null;
        }

        public T getObjeto() throws NullPointerException {
            return objeto;
        }

        public void setObjeto(T objeto) {
            this.objeto = objeto;
        }

        public Item getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Item siguiente) {
            this.siguiente = siguiente;
        }
    }

    /**
     * Constructor
     * Inicializa una fila vacia
     */
    public Fila() {
        this.frente = null;
        this.cola = null;
    }
    
    public int getSize() {
        return size;
    }
    

    @Override
    public boolean esFilaVacia() {
        return this.frente == null;
    }

    
    @Override
    public T frente() throws EmptyQueueException { //DEVUELVE EL FRENTE DE LA FILA
        if (this.esFilaVacia()){
            throw new EmptyQueueException();
        }
        else{
            return (T) this.frente.getObjeto();
        }
    }
    
    
    @Override
    public void enFila(T objeto) { //AGREGAR ITEM AL FINAL, A LA DERECHA
        Item itemNuevo = new Item(objeto);
        
        if (this.esFilaVacia()) {
            this.frente = itemNuevo; //Si la fila esta vacia le asigno a frente el nuevo item
        } else {
            this.cola.setSiguiente(itemNuevo);
        }
        this.cola = itemNuevo;
        size++;
    }
    
    
    @Override
    public void deFila() throws EmptyQueueException { //BORRA EL PRIMER ITEM, EL DE LA IZQUIERDA
        
        if (this.esFilaVacia()){
            throw new EmptyQueueException();
        }
        else{
            Item aux = this.frente.getSiguiente();
            this.frente = aux;
            size--;
        }
    }
    
    
    /**
     * NO es parte de la implementación del ADT!
     * Puesto únicamente para una mejor visualización de los cambios en la fila
     */
    @Override
    public void mostrarFila() throws EmptyQueueException {
        Item aux = this.frente;
        
        if (this.esFilaVacia()) {
            throw new EmptyQueueException();
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