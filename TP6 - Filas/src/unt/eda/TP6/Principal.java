package unt.eda.TP6;

import unt.eda.ADT_Fila.TestADT_Fila;

/**
 *  Trabajo Práctico N° 6
 *  Filas
 *  Implementación ADT Fila
 * @author Franco Quevedo
 */
public class Principal {
    public static void main(String[] args){
        
        System.out.println("------------TEST ADT - FILA-----------------");
        System.out.println("---------------FILA VACIA-----------------");
        TestADT_Fila.testEsFilaVacia();
        TestADT_Fila.testFrente();
        TestADT_Fila.testDeFila();
        
        System.out.println("\n---------------FILA LLENA-----------------");
        TestADT_Fila.testEsFilaVacia();
        TestADT_Fila.testEnFila();
        TestADT_Fila.testMostrarFila();
        TestADT_Fila.testEsFilaVacia();
        TestADT_Fila.testFrente();
        TestADT_Fila.testDeFila();
        
        
        System.out.println("\n\n--------------------SIMULACION SERVIDOR--------------------------");
        System.out.println("------------SERVIDOR PROBABILIDAD PREDETERMINADA-----------------");
        TestServidor.testProcesarServidorPredet();
        TestServidor.testInfoServidorPredet();
        
        System.out.println("\n------------SERVIDOR PROBABILIDAD VARIABLE-----------------");
        TestServidor.testProcesarServidorVariable();
        TestServidor.testInfoServidorVariable();
    }
}
