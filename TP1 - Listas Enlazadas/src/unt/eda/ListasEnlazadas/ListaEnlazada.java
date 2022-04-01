package unt.eda.ListasEnlazadas;

/**
 *  Trabajo Práctico N° 1
 *  Listas Enlazadas
 * @author Franco Quevedo
 */
public class ListaEnlazada {
    private Nodo primero;
    private int size = 0; //Tamaño de la lista
    public static final String LISTA_VACIA = "La lista está vacía.";
    public static final String POSICION_INCORRECTA = "La posición ingresada es incorrecta.";
    
    //Clase interna Nodo
    class Nodo{
        private int valor;
        private Nodo siguiente;
        
        Nodo(int numero){
            this.valor = numero; //Si es necesario el this.
            siguiente = null; //No es necesario porque Java inicializa la ref con null
        }

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }

    //1.1
    public ListaEnlazada(){
        primero = null; //No hace falta el this.
    }
    
    //1.2
    public boolean estaVacia(){
        return primero == null;
    }
    
    //1.3
    public void insertarAlInicio(int valor){
        Nodo aux = new Nodo(valor);
        
        aux.setSiguiente(this.primero); //No es necesario el this.
        this.primero = aux;
        size++;
    }
    
    //1.4
    public void insertarAlFinal(int valor){
        Nodo nuevo = new Nodo(valor);
        Nodo aux;
        
        if (this.estaVacia()) {
            this.primero = nuevo; //Si la lista esta vacia le asigno a primero el nuevo nodo
            size++;
        } else {
            aux = this.primero;
           
            while(aux.getSiguiente() != null){ //Recorro la lista hasta el ultimo nodo
                aux = aux.getSiguiente();
            }
            
            aux.setSiguiente(nuevo); //Al ultimo le asigno como siguiente el nuevo nodo
            size++;
        }
    }
    
    //1.5
    public void mostrarLista(){
        Nodo aux = primero;
        
        if (this.estaVacia()) {
            System.out.println(LISTA_VACIA);
        } else {
            while(aux != null){ //Recorro la lista imprimiendo en pantalla sus valores
                System.out.print(aux.getValor() + "->");
                aux = aux.getSiguiente();
            }
            System.out.println("NULL");
        }
    }
    
    //1.6
    public int size(){
        return this.size; //Devuelvo la cantidad de nodos
    }
    
    public void cantidadNodos(){
        System.out.println("Cantidad de nodos: " + this.size);
    }
    
    //1.7
    public void eliminarPrimerNodo(){
        if (this.estaVacia()) {
            System.out.println(LISTA_VACIA);
        } else {
            Nodo aux = this.primero.getSiguiente();
            this.primero = aux; //Asigno a primero el nodo que seguia
            size--;
        }
    }
    
    //1.8
    public void eliminarUltimoNodo(){
        if (this.estaVacia()) {
            System.out.println(LISTA_VACIA);
        } else {
            Nodo aux = this.primero;
            
            while(aux.getSiguiente().getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(null); //El puntero aux queda en el penultimo nodo y se le asigna el valor null al ultimo nodo
            size--;
        }
    }
    
    //1.9
    public void eliminarPorValor(int valorBuscado){
        if (this.estaVacia()) {
            System.out.println(LISTA_VACIA);
        }
        if (this.size == 1 && this.primero.getValor() == valorBuscado) {
            this.eliminarPrimerNodo();
        } else {
            Nodo nodoActual = this.primero;
            Nodo nodoAnterior = null;
            
            while(nodoActual != null){
                if (nodoActual.getValor() == valorBuscado) {
                    if (nodoActual == this.primero) {
                        this.eliminarPrimerNodo();
                    } else {
                        nodoAnterior.setSiguiente(nodoActual.getSiguiente());
                        size--;
                    }
                }
                nodoAnterior = nodoActual;
                nodoActual = nodoActual.getSiguiente();
            }
            System.out.println("Se ha eliminado el nodo correctamente.");
        }
    }
    
    //1.10
    public Nodo obtenerNodo(int posicionBuscada) throws IndexOutOfBoundsException {
        Nodo nodoActual = this.primero;
        int posicionActual = 0; //Por el usuario cuenta el primer elemento como 1 y no posicion 0
        
        if (posicionBuscada < 0 || posicionBuscada >= this.size) {
            throw new IndexOutOfBoundsException();
//            System.out.println(POSICION_INCORRECTA);
        }
        
        if (posicionBuscada < this.size) {
            while(nodoActual != null){
                if (posicionActual == posicionBuscada) {
                    return nodoActual;
                }
                posicionActual++;
                nodoActual = nodoActual.getSiguiente();
            }
        }
        return null;
    }
        
    public int obtenerValorNodo(int posicionBuscada) throws IndexOutOfBoundsException{
        int valorNodo = 0;
        
        try{
            valorNodo = this.obtenerNodo(posicionBuscada).getValor();
        } catch(IndexOutOfBoundsException e){
            System.out.print(POSICION_INCORRECTA);
        }
        return valorNodo;
    }
    
    
    //1.11
    public void modificarNodo(int posicionBuscada, int valorNuevo){
        Nodo nodoActual = this.primero;
        int posicionActual = 0;
        int posicionValorModif = 0;
        int valorAntiguo = 0;
        
        if (posicionBuscada < this.size) {
            while(nodoActual != null){
                if (posicionActual == posicionBuscada) {
                    
                    posicionValorModif = posicionBuscada;
                    valorAntiguo = nodoActual.getValor();
                    nodoActual.setValor(valorNuevo);
                }
                posicionActual++;
                nodoActual = nodoActual.getSiguiente();
            }
            System.out.println("*Se modificó el valor del nodo " + posicionValorModif + ": " + valorAntiguo + " -> " + obtenerValorNodo(posicionValorModif));
        } else {
            System.out.println(POSICION_INCORRECTA);
        }
    }
    
    //1.12
    public void insertarNodo(int posicionBuscada, int nuevoValor) {
        Nodo nodoNuevo = new Nodo(nuevoValor);
        Nodo nodoAnterior = null;
        
        if (estaVacia()) {
            this.insertarAlInicio(nuevoValor);
            System.out.println("*Se insertó un nodo en la lista.");
            return;
        }
        
        if (posicionBuscada < 0 || posicionBuscada > this.size + 1) {
            System.out.println(POSICION_INCORRECTA);
            return;
        }
        
        if (posicionBuscada == 0) {
            this.insertarAlInicio(nuevoValor);
            System.out.println("*Se insertó un nodo al principio de la lista.");
        } 
        else if (posicionBuscada == this.size + 1) {
            this.insertarAlFinal(nuevoValor);
            System.out.println("*Se insertó un nodo al final de la lista.");
        }
        else {
            nodoAnterior = this.obtenerNodo(posicionBuscada - 1);
            nodoNuevo.setSiguiente(nodoAnterior.getSiguiente());
            nodoAnterior.setSiguiente(nodoNuevo);
            size++;
            
            System.out.println("*Se insertó un nodo en la posición " + posicionBuscada + ": " + obtenerValorNodo(posicionBuscada - 1) + " -> " + obtenerValorNodo(posicionBuscada) + " -> " + obtenerValorNodo(posicionBuscada + 1));
        }
    }
    
    //1.13
    public void eliminarNodo(int posicionBuscada){
        Nodo nodoActual = this.primero;
        Nodo nodoSiguiente;
        int posicionActual = 0;
        
        if (estaVacia()) {
            System.out.println(LISTA_VACIA);
            return;
        }
        
        if (posicionBuscada < 0 || posicionBuscada > this.size + 1) {
            System.out.println(POSICION_INCORRECTA);
            return;
        }
        
        if (posicionBuscada == 0) {
            this.eliminarPrimerNodo();
            System.out.println("*Se eliminó el primer nodo.");
            return;
        }
        
        while(nodoActual != null){
                if (posicionActual == posicionBuscada - 1) {
                    nodoSiguiente = nodoActual.getSiguiente().getSiguiente();
                    nodoActual.setSiguiente(nodoSiguiente);
                    size--;
                    System.out.println("*Se eliminó el nodo en la posición " + posicionBuscada);
                }
            posicionActual++;
            nodoActual = nodoActual.getSiguiente();
        }
    }
}
