package unt.eda.Pilas;

import java.util.EmptyStackException;

/**
 *  Trabajo Práctico N° 5
 *  Pilas
 *  Implementación ADT Pila
 * @author Franco Quevedo
 */
public class Test {
    
    /**
     * testEsPilaVacia
     * 
     * Checkea la correcta implementación del metodo esPilaVacia()
     * Muestra el correspondiente mensaje si la pila está vacía o no
     */
    public static void testEsPilaVacia(Pila stack) {
        boolean esPilaVacia = stack.esPilaVacia();
        System.out.println("EsPilaVacia: " + esPilaVacia);
    }
    
    /**
     * testPush
     * 
     * Checkea la correcta implementación del metodo push()
     * Utiliza el método randomChar para crear 10 letras aleatorias
     * y las agrega a la pila con push()
     */
    public static void testPush(Pila stack) {
        int testSize = 10;
        
        for (int i = 0; i < testSize; i++){
            char rndChar = randomChar();
            
            Pila.push(stack, rndChar);
            System.out.println("El caracter '" + rndChar + "' fue agregado a la pila.");
        }
    }
    
    /**
     * testPop
     * 
     * Checkea la correcta implementación del metodo pop()
     * Muestra el correspondiente mensaje si la pila está vacía o no
     */
    public static void testPop(Pila stack) {
        if (Pila.pop(stack).esPilaVacia()) {
            System.out.println("No se puede remover un caracter de una pila vacia.");
        }
        else{
            System.out.println("El top fue removido de la pila.");
        }
    }
    
    /**
     * testTop
     * 
     * Checkea la correcta implementación del metodo top()
     * Muestra el correspondiente mensaje si la pila está vacía o no
     */
    public static void testTop(Pila stack) {
        try{
            char top = Pila.top(stack);
            System.out.println("Top de la pila: " + top);
        }
        catch(EmptyStackException e){
            System.out.println("No se puede obtener un caracter de una pila vacia.");
        }
    }
    
    
    /**
     * randomChar
     * 
     * Genera una letra aleatoria entre A-Z y entre a-z
     */
    private static char randomChar() {
        int sizeAlphabet = 26;
        int rnd = (int) (Math.random() * 2 * sizeAlphabet);
        char base = (rnd < sizeAlphabet) ? 'A' : 'a';
        
        return (char) (base + rnd % sizeAlphabet);
    }
    
    
    /**
     * testMostrarPila
     * 
     * Checkea la correcta implementación del metodo mostrarPila()
     * Utilizado únicamente para controlar después de utilizar algín método de 
     * la implementacón de la clase Pila
     * Muestra el correspondiente mensaje si la pila está vacía o no
     */
    public static void testMostrarPila(Pila stack) {
        try{
            Pila.mostrarPila(stack);
        }
        catch(EmptyStackException e){
            System.out.println(Pila.PILA_VACIA);
        }
    }
}
