/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eda.ListasEnlazadas;

/**
 *
 * @author franc
 */
public class Principal {
    public static void main(String[] args){
        ListaEnlazada l;
        l = new ListaEnlazada();
        
        l.insertarAlInicio(1);
        l.insertarAlInicio(2);
        l.insertarAlInicio(3);
        l.insertarAlInicio(4);
        
        l.mostrarLista();
        
        l.insertarAlFinal(5);
        l.insertarAlFinal(6);
        l.insertarAlFinal(7);
        l.insertarAlFinal(8);
        
        l.mostrarLista();
    }
}
