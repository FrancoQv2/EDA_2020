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
    private int size = 0; //Tamaño de la fila

    /**
     * Clase interna Item
     * 
     * Necesaria para operar el objeto del cual estara compuesta la fila
     */
    class Item<T> {
        private T objeto;
        private Item siguiente;
        
        Item(T objeto) {
            this.objeto = objeto;
            this.siguiente = null;
        }

        public T getObjeto() {
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

    public Fila() {
        this.frente = frente;
    }

    public Item getFrente() {
        return frente;
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
            return (T) this.getFrente().getObjeto();
        }
    }

    @Override
    public void enFila(T objeto) { //AGREGAR ITEM AL FINAL, A LA DERECHA
        Item peticionNueva = new Item(objeto);
        Item aux;
        
        if (this.esFilaVacia()) {
            this.frente = peticionNueva; //Si la fila esta vacia le asigno a frente el nuevo item
            size++;
        } else {
            aux = this.frente;
           
            while(aux.getSiguiente() != null){ //Recorro la fila hasta el ultimo item
                aux = aux.getSiguiente();
            }
            
            aux.setSiguiente(peticionNueva); //Al ultimo item le asigno como siguiente el nuevo nodo
            size++;
        }
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