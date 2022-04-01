package unt.eda.TDdeAlgoritmos;

import java.util.Scanner;

/**
 *  Trabajo Práctico N° 3
 *  Técnicas de Diseño de Algoritmos
 * @author Franco Quevedo
 */
/**
 *  Apartado 2: digitoAusente()  -> final de la clase Principal
 *  Apartado 4: sumatoriaPares() -> final de la clase ListaEnlazada
 *  Apartado 6: buscaPar()       -> final de la clase Principal
 * 
 *  Los métodos digitoAusente() y buscaPar() se prueban llamando a un
 *  método void llamado test+nombreMetodo()
 *  Esto no tiene razón en particular, solo quería probar si facilitaba
 *  o no la lectura del código
 */
public class Principal {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        ListaEnlazada lista = new ListaEnlazada();
        
        lista.insertarAlInicio(7);
        lista.insertarAlInicio(6);
        lista.insertarAlInicio(5);
        lista.insertarAlInicio(4);
        lista.insertarAlInicio(3);
        lista.insertarAlInicio(2);
        lista.insertarAlInicio(1);
        lista.insertarAlInicio(0);
        
        lista.mostrarLista();
        System.out.println();
        
        
        //Punto 4---------------------------------------------------------------
        System.out.println("-----PUNTO 4");
        System.out.println("---sumatoriaPares()");
        int suma_pares = ListaEnlazada.sumatoriaPares(lista);
        
        System.out.println("\n*La suma de pares es: " + suma_pares);
        System.out.println();
        
        
        //Punto 2---------------------------------------------------------------
        System.out.println("-----PUNTO 2");
        System.out.println("---digitoAusente()");
        
        System.out.print("\nIngrese un numero entero: ");
        int numero = input.nextInt();
        
        System.out.print("Ingrese un digito: ");
        int digito = input.nextInt();
        
        testDigitoAusente(numero, digito);
        
        System.out.println();
        
        
        //Punto 6---------------------------------------------------------------
        System.out.println("-----PUNTO 6");
        System.out.println("---buscaPar()");
        
        int[] vector = {5,8,10,12,18,20};
        
        mostrarVector(vector);
        System.out.println("Longitud del vector: " + vector.length);
        
        System.out.print("\nIngrese un numero entero: ");
        int x = input.nextInt();
        System.out.print("Ingrese otro numero entero: ");
        int y = input.nextInt();
        
        testBuscaPar(vector, x, y);
        
    }
    
    //Punto 2-------------------------------------------------------------------
    private static boolean digitoAusente(int n, int D){
        if (n == 0) {
            return false;
        }
        else{
            if (n%10 == D) {
                return true;
            }
            else{
                return digitoAusente(n/10, D);
            }
        }
    }
    
    public static void testDigitoAusente(int n, int D){
        if (digitoAusente(n, D)) {
            System.out.println("\n*El digito NO esta ausente.");
        } else {
            System.out.println("\n*El digito esta ausente.");
        }
    }
    
    //Punto 6-------------------------------------------------------------------
    private static void mostrarVector(int[] vector, int indice){
        if (indice == vector.length) {
            System.out.println(" ]");
        }
        else{
            if (indice == 0) {
                System.out.print("[ " + vector[indice] + " , ");
            }
            else {
                if (indice < vector.length - 1)
                    System.out.print(vector[indice] + " , ");
                else
                    System.out.print(vector[indice]);
            }
            mostrarVector(vector, indice + 1);
        }
    }
    
    public static void mostrarVector(int[] vector){
        mostrarVector(vector, 0);
    }
    
    private static boolean estaFueraVector(int[] vector, int x, int y){
        return (x < vector[0]) || (y < vector[0]) || (x > vector[vector.length-1]) || (y > vector[vector.length-1]); //true si NO esta dentro del vector
    }
    
    private static boolean buscaPar(int[] vector, int x, int y, int inferior, int superior) throws ArrayIndexOutOfBoundsException{
        int medio = (inferior + superior) / 2;
        
        if (estaFueraVector(vector, x, y)){ //Si NO esta dentro del vector tira la excepcion
            throw new ArrayIndexOutOfBoundsException();
        }
        
        if (inferior < superior) {   //El caso base es inferior > superior RETURN false
            if (x == vector[medio] || y == vector[medio]) {
                if (x == vector[medio-1] || y == vector[medio-1] || x == vector[medio+1] || y == vector[medio+1]) {
                    return true;
                }
            }
            else
            if (x < vector[medio] || y < vector[medio]) {
                return buscaPar(vector, x, y, inferior, medio-1);
            }
            else{
                return buscaPar(vector, x, y, medio+1, superior);
            }
        }
        return false;
    }
        
    public static boolean buscaPar(int[] vector, int x, int y) throws ArrayIndexOutOfBoundsException{
        try{
            return buscaPar(vector, x, y, 1, vector.length);
        } catch(IndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public static void testBuscaPar(int[] vector, int x, int y){
        try{
            boolean test = buscaPar(vector, x, y);
            
            if (test) {
                System.out.println("\n*Los numeros ingresados estan a la par");
            }
            else
                System.out.println("\n*Los numeros ingresados no estan a la par");
        } catch(IndexOutOfBoundsException e){
            System.out.println("\n*El/los numero/s ingresados no se encuentran en el vector");
        }
    }
}
