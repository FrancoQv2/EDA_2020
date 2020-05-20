package unt.eda.Pilas;

import unt.edu.ADT_Pila.TestADT_Pila;

/**
 *  Trabajo Práctico N° 5
  Pilas
  Implementación ADT Pilas
 * @author Franco Quevedo
 */
public class Principal {
    public static void main(String[] args){
//        // PILA VACIA
//        System.out.println("---------------PILA VACIA-----------------");
//        Pilas pila_vacia = new Pilas();
//        
//        System.out.println("\n---Test esPilaVacia()");
//        Test.testEsPilaVacia(pila_vacia);
//        
//        System.out.println("\n---testMostrarPila()");
//        Test.testMostrarPila(pila_vacia);
//
//        System.out.println("\n---Test pop()");
//        Test.testPop(pila_vacia);
//        
//        System.out.println("\n---Test top()");
//        Test.testTop(pila_vacia);
//        
//        
//        //PILA LLENA
//        System.out.println("\n\n---------------PILA LLENA-----------------");
//        Pilas pila_llena = new Pilas();
//        
//        System.out.println("\n---Test esPilaVacia()");
//        Test.testEsPilaVacia(pila_llena);
//        
//        System.out.println("\n---Test push()");
//        Test.testPush(pila_llena);
//        
//        System.out.println();
//        Test.testEsPilaVacia(pila_llena);
//        Test.testMostrarPila(pila_llena);
//        
//        System.out.println("\n---Test pop()");
//        Test.testPop(pila_llena);
//        
//        System.out.println();
//        Test.testMostrarPila(pila_llena);
//        
//        System.out.println("\n---Test top()");
//        Test.testTop(pila_llena);
//        
//        System.out.println();
//        Test.testMostrarPila(pila_llena);
        
        System.out.println("------------TEST ADT - PILA-----------------");
        System.out.println("---------------PILA VACIA-----------------");
        TestADT_Pila.testEsPilaVacia();
        TestADT_Pila.testTop();
        TestADT_Pila.testPop();
        
        System.out.println("\n---------------PILA LLENA-----------------");
        TestADT_Pila.testEsPilaVacia();
        TestADT_Pila.testPush();
        TestADT_Pila.testMostrarPila();
        TestADT_Pila.testEsPilaVacia();
        TestADT_Pila.testTop();
        TestADT_Pila.testPop();
        TestADT_Pila.testMostrarPila();
    }
}
