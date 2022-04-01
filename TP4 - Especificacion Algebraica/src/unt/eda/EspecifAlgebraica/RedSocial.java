package unt.eda.EspecifAlgebraica;

/**
 *  Trabajo Práctico N° 4
 *  Especificación Algebraica
 *  Implementación RedSocial
 * @author Franco Quevedo
 */
public class RedSocial {
    private Nodo primero;
    private int size = 0; //Tamaño de la lista
    public static final String LISTA_VACIA = "La lista está vacía.";

    //Clase interna Nodo
    class Nodo{
        private Usuario usuario;
        private Nodo siguiente;
        
        Nodo(Usuario usuario){
            this.usuario = usuario;
            siguiente = null;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }
        
        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }

    //CONSTRUCTOR
    public RedSocial() {
        this.primero = null;
    }

    public Nodo getPrimero() {
        return primero;
    }
    
    
    //FUNCION REGISTRAR
    public void registrarInicio(Usuario usuario){
        Nodo aux = new Nodo(usuario);
        
        aux.setSiguiente(primero);
        primero = aux;
        size++;
    }
    
    public void registrarFinal(Usuario usuario){
        Nodo nuevo = new Nodo(usuario);
        Nodo aux;
        
        if (this.esVacia()) {
            this.primero = nuevo;
            size++;
        }
        else{
            aux = this.primero;
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            size++;
        }
    }
    
    
    //FUNCION REDSOCIAL VACIA
    public boolean esVacia(){
        return this.getPrimero() == null;
    }
    
    
    //FUNCION CANTIDAD USUARIOS
    public int cantidad(){
        return this.size;
    }
    
    
    //FUNCION MOSTRAR USUARIOS
    public void mostrarUsuarios(){
        Nodo aux = this.primero;
        
        if (esVacia()) {
            System.out.println(LISTA_VACIA);
        } else {
            while(aux != null){ //Recorro la lista imprimiendo en pantalla sus valores
                System.out.print(aux.getUsuario()+ "->");
                aux = aux.getSiguiente();
            }
            System.out.println("NULL");
        }
    }
    
    
    //FUNCION ULTIMO USUARIO
    private Usuario ultimoUsuario(Nodo nodo){
        if (nodo == null) {
            return null;
        }
        else{
            if (nodo.getSiguiente() == null) {
                return nodo.getUsuario();
            }
            else{
                return ultimoUsuario(nodo.getSiguiente());
            }
        }
    }
    
    public Usuario ultimoUsuario(){
        return ultimoUsuario(this.primero);
    }
    
    
    //FUNCION ESTA USUARIO
    private boolean estaUsuario(Usuario usuario, Nodo nodo){
        
        if (nodo == null) {
            return false;
        }
        else{
            if (usuario.equals(nodo.getUsuario())) {
                return true;
            }
            else{
                return estaUsuario(usuario, nodo.getSiguiente());
            }
        }
    }
    
    public boolean estaUsuario(Usuario usuario){
        return estaUsuario(usuario, this.primero);
    }
    
    
    //FUNCION POSICION USUARIO
    private int posicionUsuario(Usuario usuario, Nodo nodoActual){
        int posicionActual = 0;
        int posicionUsuario = 0;
        
        while(nodoActual != null){
            
            if (nodoActual.getUsuario().equals(usuario)) {
                posicionUsuario = posicionActual;
            }
            posicionActual++;
            nodoActual = nodoActual.getSiguiente();
        }
        
        return posicionUsuario;
    }
    
    public int posicionUsuario(Usuario usuario){
        return posicionUsuario(usuario, this.primero);
    }
    
    
    //FUNCION ECHAR USUARIO
    private RedSocial echarUsuario(Usuario usuario, Nodo nodo){
        int posUsuario = this.posicionUsuario(usuario);
        int posActual = 0;
        Nodo nodoSig;
        RedSocial rS = new RedSocial();
        
        if (esVacia()) {
            return new RedSocial();
        }
        
        if (!this.estaUsuario(usuario)) {
            return null;
        }
        
        if (posUsuario == 0) {
            nodoSig = nodo.getSiguiente();
            nodo = nodoSig;
            size--;
            for (int i = 0; i < size; i++) {
                rS.registrarFinal(nodo.getUsuario());
                nodo = nodo.getSiguiente();
            }
            return rS;
        }
        
        while(nodo != null){
            if (posActual == posUsuario-1) {
                nodoSig = nodo.getSiguiente().getSiguiente();
                nodo.setSiguiente(nodoSig);
                size--;
            }
            posActual++;
            rS.registrarFinal(nodo.getUsuario());
            nodo = nodo.getSiguiente();
        }
        return rS;
    }
    
    public RedSocial echarUsuario(Usuario usuario){
        return echarUsuario(usuario,this.primero);
    }
    
    
    //FUNCION ESAMIGOCOMUN
    public static boolean esAmigoComun(RedSocial redSocial1, RedSocial redSocial2, Usuario usuario){
        
        if (redSocial1.esVacia() || redSocial2.esVacia()) {
            return false;
        }
        if (!redSocial1.estaUsuario(usuario)) {
            return false;
        }
        if (!redSocial2.estaUsuario(usuario)) {
            return false;
        }
        
        return true;
    }
}
