/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.eda.TP10;

/**
 *
 * @author Franco Quevedo
 */
public class Principal {
    public static void main(String[] args){
        
        System.out.println("------------TEST RADIX SORT-----------------");
        System.out.println("------------ARREGLO INTEGER-----------------");
        Test_RadixSort.testRadixSortInteger();
        
        System.out.println("------------ARREGLO INVERTIDO-----------------");
        Test_RadixSort.testRadixSortInvertido();
        
        System.out.println("------------ARREGLO ALEATORIO-----------------");
        Test_RadixSort.testRadixSortAleatorio();
        
    }
}
