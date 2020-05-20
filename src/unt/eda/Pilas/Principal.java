package unt.eda.Pilas;

/**
 *  Trabajo Práctico N° 5
 *  Pilas
 *  Implementación ADT Pila
 * @author Franco Quevedo
 */
public class Principal {
    public static void main(String[] args){
        // PILA VACIA
        System.out.println("---------------PILA VACIA-----------------");
        Pila pila_vacia = new Pila();
        
        System.out.println("\n---Test esPilaVacia()");
        Test.testEsPilaVacia(pila_vacia);
        
        System.out.println("\n---testMostrarPila()");
        Test.testMostrarPila(pila_vacia);

        System.out.println("\n---Test pop()");
        Test.testPop(pila_vacia);
        
        System.out.println("\n---Test top()");
        Test.testTop(pila_vacia);
        
        
        //PILA LLENA
        System.out.println("\n\n---------------PILA LLENA-----------------");
        Pila pila_llena = new Pila();
        
        System.out.println("\n---Test esPilaVacia()");
        Test.testEsPilaVacia(pila_llena);
        
        System.out.println("\n---Test push()");
        Test.testPush(pila_llena);
        
        System.out.println();
        Test.testEsPilaVacia(pila_llena);
        Test.testMostrarPila(pila_llena);
        
        System.out.println("\n---Test pop()");
        Test.testPop(pila_llena);
        
        System.out.println();
        Test.testMostrarPila(pila_llena);
        
        System.out.println("\n---Test top()");
        Test.testTop(pila_llena);
        
        System.out.println();
        Test.testMostrarPila(pila_llena);
    }
}
