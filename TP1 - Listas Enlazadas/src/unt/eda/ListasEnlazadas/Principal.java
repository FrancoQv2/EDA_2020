package unt.eda.ListasEnlazadas;

import java.util.Scanner;

/**
 *  Trabajo Práctico N° 1
 *  Listas Enlazadas
 * @author Franco Quevedo
 */
public class Principal {
    public static void main(String[] args){
        //---------------------------Punto 1------------------------------------
        ListaEnlazada lista = new ListaEnlazada();
        
        System.out.println("--Punto 1.2");
        System.out.println("---Lista vacia");
        lista.estaVacia();
        if (lista.estaVacia())
            System.out.println(ListaEnlazada.LISTA_VACIA);
        System.out.println();
        
        System.out.println("--Punto 1.3");
        System.out.println("---Insertar nodo al inicio");
        lista.insertarAlInicio(1);
        lista.insertarAlInicio(2);
        lista.insertarAlInicio(3);
        lista.insertarAlInicio(4);
        
        lista.mostrarLista();
        System.out.println();
        
        System.out.println("--Punto 1.4");
        System.out.println("---Insertar nodo al final");
        lista.insertarAlFinal(5);
        lista.insertarAlFinal(6);
        lista.insertarAlFinal(7);
        lista.insertarAlFinal(15);
        lista.insertarAlFinal(300);
        lista.insertarAlFinal(7);
        lista.insertarAlFinal(8);
        lista.insertarAlFinal(9);
        System.out.println();
        
        System.out.println("--Punto 1.5");
        lista.mostrarLista();
        lista.cantidadNodos();
        System.out.println();
        
        System.out.println("--Punto 1.6");
        System.out.println("---Eliminar 1er nodo");
        lista.eliminarPrimerNodo();
        lista.cantidadNodos();
        lista.mostrarLista();
        System.out.println();
        
        System.out.println("---Eliminar ultimo nodo");
        lista.eliminarUltimoNodo();
        lista.cantidadNodos();
        lista.mostrarLista();
        System.out.println();
        
        System.out.println("---Eliminar por valor");
        System.out.println("----Eliminar nodo por valor 1ero 3");
        lista.eliminarPorValor(3);
        lista.cantidadNodos();
        lista.mostrarLista();
        System.out.println();
        
        System.out.println("----Eliminar por valor del medio 5");
        lista.eliminarPorValor(5);
        lista.cantidadNodos();
        lista.mostrarLista();
        
        System.out.println();
        System.out.println("----Insertar nodos al final");
        lista.insertarAlFinal(42);
        lista.insertarAlFinal(9);
        lista.insertarAlFinal(12);
        lista.insertarAlFinal(7);
        lista.insertarAlFinal(37);
        lista.cantidadNodos();
        lista.mostrarLista();
        System.out.println();
        
        System.out.println("----Eliminar nodo por valor del medio duplicado 7"); 
        lista.eliminarPorValor(7);
        lista.cantidadNodos();
        lista.mostrarLista();
        System.out.println();
        
//        //No puedo borrar borrar duplicados si estan consecutivos
//        System.out.println("----Valor nodo del medio duplicado 8 consecutivo"); 
//        lista.eliminarPorValor(8);
//        lista.cantidadNodos();
//        lista.mostrarLista();
//        System.out.println();
        
        System.out.println("----Eliminar nodo por valor ultimo");
        lista.eliminarPorValor(37);
        lista.cantidadNodos();
        lista.mostrarLista();
        System.out.println();
        
        
        System.out.println("--Punto 1.7");
        System.out.println("---Obtener nodo por posicion");
        lista.cantidadNodos();
        lista.mostrarLista();
        System.out.print("Nodo posicion 0: ");
        lista.obtenerValorNodo(0);
        System.out.println();
        System.out.print("Nodo posicion 5: ");
        lista.obtenerValorNodo(5);
        System.out.println();
        System.out.print("Nodo posicion -7: ");
        lista.obtenerValorNodo(-7);
        System.out.println();
        System.out.print("Nodo posicion 20: ");
        lista.obtenerValorNodo(20);
        System.out.println();
        System.out.println();
        
        System.out.println("--Punto 1.8");
        System.out.println("---Modificar nodo por posicion");
        lista.cantidadNodos();
        lista.mostrarLista();
        System.out.println();
        lista.modificarNodo(0, 500);
        lista.modificarNodo(2, 500);
        lista.modificarNodo(7, 500);
        lista.modificarNodo(22, 500);
        lista.cantidadNodos();
        lista.mostrarLista();
        System.out.println();
        
        System.out.println("--Punto 1.9");
        System.out.println("---Insertar nodo por posicion");
        lista.insertarNodo(0, 250); // Posicion inicial
        lista.cantidadNodos();
        lista.mostrarLista();
        lista.insertarNodo(20, 350); // Afuera
        lista.cantidadNodos();
        lista.mostrarLista();
        lista.insertarNodo(11, 350); // Posicion final
        lista.cantidadNodos();
        lista.mostrarLista();
        System.out.println();
        lista.insertarNodo(9, 7); // Posicion 9 medio
        lista.cantidadNodos();
        lista.mostrarLista();
        System.out.println();
        
        System.out.println("--Punto 1.10");
        System.out.println("---Eliminar nodo por posicion");
        lista.eliminarNodo(0); //Primer nodo posicion 0
        lista.cantidadNodos();
        lista.mostrarLista();
        lista.eliminarNodo(2); //Nodo posicion 2
        lista.cantidadNodos();
        lista.mostrarLista();
        lista.eliminarNodo(5); //Nodo posicion 5 ultimo en este caso
        lista.cantidadNodos();
        lista.mostrarLista();
        lista.eliminarNodo(8); //Ultimo nodo
        lista.cantidadNodos();
        lista.mostrarLista();
        lista.eliminarNodo(12); //Nodo no contenido en la lista
        lista.cantidadNodos();
        lista.mostrarLista();
        System.out.println();
        System.out.println();
        
        
        //---------------------------Punto 2------------------------------------
        System.out.println("--Punto 2");
        System.out.println("---Clasificador Par Impar");
        ListaEnlazada listaAux = new ListaEnlazada();
        ListaEnlazada listaPar = new ListaEnlazada();
        ListaEnlazada listaImpar = new ListaEnlazada();
        
        Scanner reader = new Scanner(System.in);
        int cantidadNodos = 0;
        String cadena;
        
        System.out.print("Ingrese la cantidad de nodos de la lista: ");
        cadena = reader.nextLine(); //Leo por teclado
        try{
            cantidadNodos = Integer.parseInt(cadena);
            crearLista(listaAux, cantidadNodos);
        } catch(Exception e) {
            System.out.println("Solo se puede ingresar un numero.");
        }
        
        clasificarParImpar(listaAux, listaPar, listaImpar);
        
        listaAux.mostrarLista();
        System.out.println();
        System.out.print("Lista PAR: ");
        listaPar.mostrarLista();
        System.out.print("Lista IMPAR: ");
        listaImpar.mostrarLista();
    }
        
    public static void crearLista(ListaEnlazada lista, int cantidadNodos){//Crea una lista de tamaño n con numeros aleatorios
        int numeroAleatorio;
        for (int i = 0; i < cantidadNodos; i++) {
            numeroAleatorio = (int)(Math.random()*1000); //Rango de numeros 0-999
            lista.insertarAlInicio(numeroAleatorio);
        }
    }
    
    public static void clasificarParImpar(ListaEnlazada lista, ListaEnlazada listaPar, ListaEnlazada listaImpar){
        if (lista.estaVacia()) {
            System.out.println("La lista a clasificar esta vacía.");
        }
        if (!listaPar.estaVacia() && !listaImpar.estaVacia()) {
            System.out.println("Alguna de las listas ingresadas no estan vacías.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            if (lista.obtenerValorNodo(i) % 2 == 0) { //Verifica si el valor del nodo es par
                listaPar.insertarAlInicio(lista.obtenerValorNodo(i));
            } else {
                listaImpar.insertarAlInicio(lista.obtenerValorNodo(i));
            }
        }
    }
}
