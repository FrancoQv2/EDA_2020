package unt.eda.TP8;

import unt.eda.ADT_ArbolBinario.AB;

/**
 *  Trabajo Práctico N° 8
 *  Arbol Binario
 *  Implementación ADT Arbol Binario
 * @author Franco Quevedo
 */
public class CodigoMorse {
    public static final String PUNTO = ".";
    public static final String RAYA = "-";
    public static final String ESPACIO = " ";
    public static final String VACIA = "";
    public static final Character RAIZ = '&';
    
    
    /**
     * insertarMorse
     * 
     * Inserta un AB hoja en la posicion requerida
     * @param morseAB
     * @param codigo determina la posicion
     * @param c
     * @return 
     */
    public static AB insertarMorse(AB morseAB, String codigo, Character c){
        if (codigo.isEmpty()) {
            return AB.armarAB(null, c, null);
        }
        else 
        if (codigo.substring(0, 1).equals(PUNTO)) {
            codigo = codigo.substring(1);
            return AB.armarAB(insertarMorse(morseAB.izquierdo(), codigo, c), morseAB.raiz(), morseAB.derecho());
        } 
        else 
        if(codigo.substring(0, 1).equals(RAYA)){
            codigo = codigo.substring(1);
            return AB.armarAB(morseAB.izquierdo(), morseAB.raiz(), insertarMorse(morseAB.derecho(), codigo, c));
        }
        else {
            return morseAB;
        }
    }
    
    /**
     * cargarMorseAB
     * 
     * Crea un AB compuesto por el Codigo Morse
     * @return 
     */
    public static AB cargarMorseAB(){
        AB morseAB = AB.ABVacio();
        
        morseAB = insertarMorse(morseAB, "", RAIZ);
        
        morseAB = insertarMorse(morseAB, ".", 'E');
        morseAB = insertarMorse(morseAB, "..", 'I');
        morseAB = insertarMorse(morseAB, "...", 'S');
        morseAB = insertarMorse(morseAB, "....", 'H');
        morseAB = insertarMorse(morseAB, ".....", '5');
        morseAB = insertarMorse(morseAB, "....-", '4');
        morseAB = insertarMorse(morseAB, "...-", 'V');
        morseAB = insertarMorse(morseAB, "...--", '3');
        morseAB = insertarMorse(morseAB, "..-", 'U');
        morseAB = insertarMorse(morseAB, "..-.", 'F');
        morseAB = insertarMorse(morseAB, "..--", ' ');
        morseAB = insertarMorse(morseAB, "..---", '2');
        
        morseAB = insertarMorse(morseAB, ".-", 'A');
        morseAB = insertarMorse(morseAB, ".-.", 'R');
        morseAB = insertarMorse(morseAB, ".-..", 'L');
        morseAB = insertarMorse(morseAB, ".-.-", ' ');
        morseAB = insertarMorse(morseAB, ".-.-.", '+');
        morseAB = insertarMorse(morseAB, ".--", 'W');
        morseAB = insertarMorse(morseAB, ".--.", 'P');
        morseAB = insertarMorse(morseAB, ".---", 'J');
        morseAB = insertarMorse(morseAB, ".----", '1');
        
        
        morseAB = insertarMorse(morseAB, "-", 'T');
        morseAB = insertarMorse(morseAB, "-.", 'N');
        morseAB = insertarMorse(morseAB, "-..", 'D');
        morseAB = insertarMorse(morseAB, "-.-", 'K');
        morseAB = insertarMorse(morseAB, "-...", 'B');
        morseAB = insertarMorse(morseAB, "-....", '6');
        morseAB = insertarMorse(morseAB, "-...-", '=');
        morseAB = insertarMorse(morseAB, "-..-", 'X');
        morseAB = insertarMorse(morseAB, "-..--", '/');
        morseAB = insertarMorse(morseAB, "-.-.", 'C');
        morseAB = insertarMorse(morseAB, "-.--", 'Y');
        
        morseAB = insertarMorse(morseAB, "--", 'M');
        morseAB = insertarMorse(morseAB, "--.", 'G');
        morseAB = insertarMorse(morseAB, "---", 'O');
        morseAB = insertarMorse(morseAB, "--..", 'Z');
        morseAB = insertarMorse(morseAB, "--.-", 'Q');
        morseAB = insertarMorse(morseAB, "---.", ' ');
        morseAB = insertarMorse(morseAB, "----", ' ');
        morseAB = insertarMorse(morseAB, "--...", '7');
        morseAB = insertarMorse(morseAB, "---..", '8');
        morseAB = insertarMorse(morseAB, "----.", '9');
        morseAB = insertarMorse(morseAB, "-----", '0');
        
        return morseAB;
    }
    
    
    /**
     * decodificarCaracterMorse
     * 
     * Decodifica un unico caracter del codigo Morse
     * @param codigo a decodificar
     * @param morseAB
     * @return 
     */
    public static String decodificarCaracterMorse(AB<Character> morseAB, String codigo) {
        if (codigo.isEmpty()) {
            return morseAB.raiz().toString();
        }
        else 
        if (codigo.substring(0, 1).equals(PUNTO)) {
            return decodificarCaracterMorse(morseAB.izquierdo(), codigo.substring(1));
        } 
        else 
        if(codigo.substring(0, 1).equals(RAYA)){
            return decodificarCaracterMorse(morseAB.derecho(), codigo.substring(1));
        }
        else {
            return decodificarCaracterMorse(morseAB, codigo.substring(1));
        }
    }
    
    
    /**
     * decodificarMorse
     * 
     * Decodifica toda una cadena de codigo Morse
     * @param codigo a decodificar
     * @param morseAB
     * @return 
     */
    public static String decodificarMorse(String codigo, AB<Character> morseAB) {
        String[] palabra;
        String frase = VACIA;
        
        if (!codigo.isEmpty()) {
            palabra = codigo.trim().split(ESPACIO);
            for (String word : palabra) {
                frase = frase + decodificarCaracterMorse(morseAB, word);
            }
            return frase;
        } else {
            return VACIA;
        }
    }
    
    
    /**
     * morsePreOrden
     * 
     * Muestra un AB de codigo Morse usando el recorrido PreOrden
     * @param morseAB
     */
    public static void morsePreOrden(AB morseAB){
        System.out.print("preOrden:\t");
        morseAB.preOrden();
        System.out.println();
    }
    
    /**
     * morseEnOrden
     * 
     * Muestra un AB de codigo Morse usando el recorrido EnOrden
     * @param morseAB
     */
    public static void morseEnOrden(AB morseAB){
        System.out.print("enOrden:\t");
        morseAB.enOrden();
        System.out.println();
    }
    
    /**
     * morsePosOrden
     * 
     * Muestra un AB de codigo Morse usando el recorrido PosOrden
     * @param morseAB
     */
    public static void morsePosOrden(AB morseAB){
        System.out.print("posOrden:\t");
        morseAB.posOrden();
        System.out.println();
    }
}
