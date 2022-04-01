package unt.eda.ADT_ArbolBinario;

/**
 *  Trabajo Práctico N° 8
 *  Arbol Binario
 *  Implementación ADT Arbol Binario
 * @author Franco Quevedo
 */
public class TestADT_AB {
    private static AB arbolAB = AB.ABVacio();
    
    
    /**
     * testArmarAB
     * 
     * Arma un AB compuesto de varios AB de caracteres
     */
    public static void testArmarAB(){
        Character rndChar = randomChar();
        Character rndChar2 = randomChar();
        Character rndChar3 = randomChar();
        Character rndChar4 = randomChar();
        Character rndChar5 = randomChar();

        AB arbolAB2 = AB.armarAB(null, rndChar2, null);
        AB arbolAB3 = AB.armarAB(null, rndChar3, null);
        AB arbolAB4 = AB.armarAB(arbolAB3, rndChar4, null);
        AB arbolAB5 = AB.armarAB(null, rndChar5, arbolAB2);

        arbolAB = AB.armarAB(arbolAB5, rndChar, arbolAB4);

        System.out.println(IAB.AB_ARMAR + rndChar);
        System.out.println(IAB.AB_ARMAR + rndChar2);
        System.out.println(IAB.AB_ARMAR + rndChar3);
        System.out.println(IAB.AB_ARMAR + rndChar4);
        System.out.println(IAB.AB_ARMAR + rndChar5);
    }
    
    
    /**
     * testEsABVacio
     * 
     * Chequea si el AB esta vacio o no
     */
    public static void testEsABVacio(){
        boolean esABVacio = arbolAB.esABVacio();
        System.out.println(IAB.AB_VACIO + esABVacio);
    }
    
    
    
    /**
     * testPertenece
     * 
     * Chequea si un caracter aleatorio se encuentra en el AB
     */
    public static void testPertenece(){
        int testSize = (int) (Math.random() * 5) + 1; //Genera num entre 1-5 para testear
        
        if (arbolAB.esABVacio()) {
            System.out.println(IAB.AB_VACIO_PERTENECE);
        } else{
            for (int i = 0; i < testSize; i++) {
                Character rndChar = randomChar();
                boolean pertenece = arbolAB.pertenece(rndChar);

                if (pertenece) {
                    System.out.println(IAB.AB_SI_PERTENECE + rndChar);
                } else {
                    System.out.println(IAB.AB_NO_PERTENECE + rndChar);
                }
            }
        }
    }
    
    
    /**
     * testEsFilaVacia
     * 
     * Muestra un AB recorrido de la forma PreOrden
     */
    public static void testPreOrden(){
        System.out.print("\npreOrden:\t");
        arbolAB.preOrden();
        System.out.println();
    }
    
    /**
     * testEsFilaVacia
     * 
     * Muestra un AB recorrido de la forma EnOrden
     */
    public static void testEnOrden(){
        System.out.print("enOrden:\t");
        arbolAB.enOrden();
        System.out.println();
    }
    
    /**
     * testEsFilaVacia
     * 
     * Muestra un AB recorrido de la forma PosOrden
     */
    public static void testPosOrden(){
        System.out.print("posOrden:\t");
        arbolAB.posOrden();
        System.out.println();
    }
    
    
    /*** randomChar
     * 
     * Genera una letra aleatoria entre A-Z y entre a-z
     */
    private static char randomChar() {
        int sizeAlphabet = 26;
        int rnd = (int) (Math.random() * sizeAlphabet);
        char base = (rnd < sizeAlphabet) ? 'A' : 'Z'; //Genero solo mayusculas
        
        return (char) (base + rnd % sizeAlphabet);
    }
}
