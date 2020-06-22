package unt.eda.TP8;

import unt.eda.ADT_ArbolBinario.AB;

/**
 *  Trabajo Práctico N° 8
 *  Arbol Binario
 *  Implementación ADT Arbol Binario
 * @author Franco Quevedo
 */
public class Test_CodigoMorse {
    private static AB morseAB = AB.ABVacio();
    public static final String SOS = "... --- ...";
    
    
    public static void testCargarMorse() {
        morseAB = CodigoMorse.cargarMorseAB();
        if (!morseAB.esABVacio()) {
            System.out.println("- El código Morse se cargó correctamente en un AB.\n");
        } else {
            System.out.println("- El código Morse no se cargó correctamente en un AB.\n");
        }
    }
    
    
    public static void testRecorridoABMorse() {
        System.out.println("- Recorrido de un AB de código Morse:");
        CodigoMorse.morsePreOrden(morseAB);
        CodigoMorse.morseEnOrden(morseAB);
        CodigoMorse.morsePosOrden(morseAB);
    }
    
    
    public static void testDecodificarMorse() {
        String cadena = CodigoMorse.decodificarMorse(SOS, morseAB);
        System.out.println("\n- Decodificación de un mensaje.");
        System.out.println("[ " + SOS + " ] significa: " + cadena);
    }
}
