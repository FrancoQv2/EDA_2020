package unt.eda.TDdeAlgoritmos;

/**
 *  Trabajo Práctico N° 3
 *  Técnicas de Diseño de Algoritmos
 * @author Franco Quevedo
 */
public class ListaEnlazada {
    private Nodo primero;
    private int size = 0; //Tamaño de la lista
    public static final String LISTA_VACIA = "La lista está vacía.";

    //Clase interna Nodo
    class Nodo{
        int valor;
        Nodo siguiente;
        
        Nodo(int numero){
            valor = numero; //Si es necesario el this.
            siguiente = null; //No es necesario porque Java inicializa la ref con null
        }
        
        public int getValor() {
            return valor;
        }
        
        public Nodo getSiguiente() {
            return siguiente;
        }
    }

    public ListaEnlazada(){
        primero = null;
    }
    
    public Nodo getPrimero() {
        return primero;
    }
    
    public boolean estaVacia(){
        return primero == null;
    }
    
    public void insertarAlInicio(int valor){
        Nodo aux = new Nodo(valor);
        
        aux.siguiente = this.primero; //No es necesario el this.
        this.primero = aux;
        size++;
    }
    
    public void mostrarLista(){
        Nodo aux = this.primero;
        
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

    //Punto 4-------------------------------------------------------------------
    private static boolean esPar(int n){
        return n % 2 == 0;
    }
    
    private static int sumatoriaPares(ListaEnlazada lista, Nodo nodo){
        if (nodo == null) {
            return 0;
        }
        else{
            if (esPar(nodo.getValor())) {
                return nodo.getValor() + sumatoriaPares(lista, nodo.getSiguiente());
            }
            else{
                return sumatoriaPares(lista, nodo.getSiguiente());
            }
        }
    }
    
    public static int sumatoriaPares(ListaEnlazada lista){
        return sumatoriaPares(lista, lista.primero);
    }
}