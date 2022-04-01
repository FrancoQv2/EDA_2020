package unt.eda.ADT_Fila;

/**
 *  Trabajo Práctico N° 6
 *  Filas
 *  Implementación ADT Fila
 * @author Franco Quevedo
 */
public class TestADT_Fila {
    //Creo una fila de objetos Character
    private static IFila<Character> queue = new Fila<>();
    
    
    /**
     * testEsFilaVacia
     * 
     * Chequea la correcta implementación del metodo esFilaVacia()
     * Muestra el correspondiente mensaje si la fila está vacía o no
     */
    public static void testEsFilaVacia(){
        boolean esFilaVacia = queue.esFilaVacia();
        System.out.println(IFila.FILA_VACIA + esFilaVacia);
    }
    
    
    /**
     * testFrente
     * 
     * Chequea la correcta implementación del metodo top()
     * Muestra el correspondiente mensaje si la pila está vacía o no
     */
    public static void testFrente(){
        try{
            Character frente = queue.frente();
            System.out.println(IFila.FILA_FRENTE + frente);
        }
        catch(EmptyQueueException e){
            System.out.println(IFila.FILA_VACIA_FRENTE);
        }
    }
    
    
    /**
     * testEnFila
     * 
     * Chequea la correcta implementación del metodo enFila()
     * Utiliza el método randomChar para crear 10 letras aleatorias
     * y las agrega a la fila con enFila()
     */
    public static void testEnFila(){
        int testSize = 5;
        
        for (int i = 0; i < testSize; i++) {
            Character rndChar = randomChar();
            
            queue.enFila(rndChar);
            System.out.println(IFila.FILA_ENFILA + rndChar);
        }
    }
    
    
    /**
     * testDeFila
     * 
     * Chequea la correcta implementación del metodo deFila()
     * Muestra el correspondiente mensaje si la fila está vacía o no
     */
    public static void testDeFila(){
        try{
            queue.deFila();
            System.out.println(IFila.FILA_DEFILA);
        }
        catch(EmptyQueueException e){
            System.out.println(IFila.FILA_VACIA_DEFILA);
        }
    }
    
    
    /*** randomChar
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
     * testMostrarFila
     * 
     * NO es parte de la implementación del ADT!
     * Puesto únicamente para una mejor visualización de los cambios en la fila
     */
    public static void testMostrarFila(){
        try{
            queue.mostrarFila();
        }
        catch(EmptyQueueException e){
            System.out.println(queue.esFilaVacia());
        }
    }
}