/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eda.ListasEnlazadas;

/**
 *
 * @author franc
 */
public class ListaEnlazada {
    
    private Nodo primero;
    
    //Clase interna Nodo
    class Nodo{
        private int numero;
        private Nodo siguiente;
        
        Nodo(int numero){
            this.numero = numero; //Si es necesario el this.
            siguiente = null; //No es necesario porque Java inicializa la ref con null
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }

    //1.1
    public ListaEnlazada() {
        primero = null; //No hace falta el this.
    }
    
    //1.2
    public boolean esVacia(){
        return primero == null;
    }
    
    //1.3
    public void insertarAlInicio(int numero){
        Nodo aux = new Nodo(numero);
        
        aux.setSiguiente(this.primero); //No es necesario el this.
        this.primero = aux;
    }
    
    //1.4
    public void insertarAlFinal(int numero){
        Nodo nuevo = new Nodo(numero);
        Nodo aux;
        
        if (this.esVacia()) {
            
        } else {
            aux = this.primero;
           
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            } //Si la lista esta vacia me tira excepcion
            
            aux.setSiguiente(nuevo);
        }
    }
    
    //1.5
    public void mostrarLista(){
        Nodo aux = primero;
        
        while(aux != null){
            System.out.print(aux.getNumero() + "->");
            aux = aux.getSiguiente();
        }
        System.out.println("NULL");
    }
    
    //1.6
    
    
    //1.7
    
    
    //1.8
    
    
    //1.9
    
    
    //1.10
    
    
    //1.11
    
    
    //1.12
    
    
    //1.13
    
    
    
}
