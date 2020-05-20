package unt.edu.ADT_Pila;

import java.util.EmptyStackException;

/**
 *  Trabajo Práctico N° 5
 *  Pilas
 *  Implementación ADT Pila
 * @author Franco Quevedo
 */
public class TestADT_Pila {
    private static IPila<Character> stack = new Pila<>();
    
    /**
     * testEsPilaVacia
     * 
     * Checkea la correcta implementación del metodo esPilaVacia()
     * Muestra el correspondiente mensaje si la pila está vacía o no
     */
    public static void testEsPilaVacia() {
        boolean esPilaVacia = stack.esPilaVacia();
        System.out.println(IPila.PILA_VACIA + esPilaVacia);
    }
    
    
    /**
     * testPush
     * 
     * Checkea la correcta implementación del metodo push()
     * Utiliza el método randomChar para crear 10 letras aleatorias
     * y las agrega a la pila con push()
     */
    public static void testPush() {
        int testSize = 5;
        
        for (int i = 0; i < testSize; i++){
            char rndChar = randomChar();
            
            stack.push(rndChar);
            System.out.println(IPila.PILA_PUSH + rndChar);
        }
    }
    
    
    /**
     * testPop
     * 
     * Checkea la correcta implementación del metodo pop()
     * Muestra el correspondiente mensaje si la pila está vacía o no
     */
    public static void testPop() {
        try{
            stack.pop();
            System.out.println(IPila.PILA_POP);
        }
        catch(EmptyStackException e){
            System.out.println(IPila.PILA_POP_VACIA);
        }
    }
    
    
    /**
     * testTop
     * 
     * Checkea la correcta implementación del metodo top()
     * Muestra el correspondiente mensaje si la pila está vacía o no
     */
    public static void testTop() {
        try{
            Character top = stack.top();
            System.out.println(IPila.PILA_TOP + top);
        }
        catch(EmptyStackException e){
            System.out.println(IPila.PILA_TOP_VACIA);
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
 
 Checkea la correcta implementación del metodo mostrarPila()
 Utilizado únicamente para controlar después de utilizar algín método de 
 la implementacón de la clase Pilas
 Muestra el correspondiente mensaje si la pila está vacía o no
     */
    public static void testMostrarPila() {
        try{
            stack.mostrarPila();
        }
        catch(EmptyStackException e){
            System.out.println(IPila.PILA_VACIA);
        }
    }
}
