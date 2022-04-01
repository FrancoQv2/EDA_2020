package unt.eda.TP8;

import unt.eda.ADT_ArbolBinario.TestADT_AB;

/**
 *  Trabajo Práctico N° 8
 *  Arbol Binario
 *  Implementación ADT Arbol Binario
 * @author Franco Quevedo
 */
public class Principal {
    public static void main(String[] args){
        System.out.println("------------TEST ADT - AB-----------------");
        System.out.println("---------------AB VACIO-----------------");
        TestADT_AB.testEsABVacio();
        TestADT_AB.testPertenece();
        
        System.out.println("\n---------------AB LLENO-----------------");
        TestADT_AB.testEsABVacio();
        TestADT_AB.testArmarAB();
        TestADT_AB.testEsABVacio();
        System.out.println();
        TestADT_AB.testPertenece();
        TestADT_AB.testPreOrden();
        TestADT_AB.testEnOrden();
        TestADT_AB.testPosOrden();
        
        
        System.out.println();
        System.out.println("---------------CODIGO MORSE-----------------");
        Test_CodigoMorse.testCargarMorse();
        
        Test_CodigoMorse.testRecorridoABMorse();
        
        Test_CodigoMorse.testDecodificarMorse();
    }
}
