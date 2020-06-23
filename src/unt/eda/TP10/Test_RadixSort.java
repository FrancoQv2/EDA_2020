package unt.eda.TP10;

import java.util.Random;

/**
 *  Trabajo Práctico N° 10
 *  Clasificación
 *  Implementación Radix Sort
 * @author Franco Quevedo
 */
public class Test_RadixSort {
    private static Random rnd = new Random();
    public static final int CANTIDAD_DIGITOS = 3;
    
    
    /**
     * Realiza de un test de un arreglo ordenado mediante el metodo RADIX SORT
     */
    public static void testRadixSortInteger(){
        final int[] ARREGLO_ORIGINAL = {36,909,100,25,101,49,64,471,381,4,555,186,100,38,671,1,10,999,899,2};
        
        RadixSort.mostrarArreglo(ARREGLO_ORIGINAL);
        
        RadixSort.ordenarArreglo(ARREGLO_ORIGINAL, ARREGLO_ORIGINAL.length, CANTIDAD_DIGITOS);
    }
    
    
    /**
     * Realiza de un test de un arreglo, previamente invertido, ordenado mediante el metodo RADIX SORT
     */
    public static void testRadixSortInvertido(){
        final int[] ARREGLO_ORIGINAL = {36,909,100,25,101,49,64,471,381,4,555,186,100,38,671,1,10,999,899,2};
        
        int[] arregloInvertido = RadixSort.invertirArreglo(ARREGLO_ORIGINAL);
        RadixSort.mostrarArreglo(arregloInvertido);
        
        RadixSort.ordenarArreglo(arregloInvertido, arregloInvertido.length, CANTIDAD_DIGITOS);
    }
    
    
    /**
     * Realiza de un test de un arreglo aleatorio ordenado mediante el metodo RADIX SORT
     */
    public static void testRadixSortAleatorio(){
        int[] arregloAleatorio = crearArregloInteger();
        
        RadixSort.mostrarArreglo(arregloAleatorio);
        
        RadixSort.ordenarArreglo(arregloAleatorio, arregloAleatorio.length, CANTIDAD_DIGITOS);
    }
    
    
    /**
     * Crea un arreglo de enteros aleatorios entre 1-999 y de tamano entre 10-20
     */
    private static int[] crearArregloInteger(){
        int sizeArreglo = rnd.nextInt(10) + 10; //Defino el tamano del nuevo arreglo entre 10-20 elementos
        int[] rndArreglo = new int[sizeArreglo];
        
        for (int i = 0; i < sizeArreglo; i++) {
            rndArreglo[i] = rnd.nextInt(999) + 1; //Cargo al arreglo una clave aleatoria entre 1-999
        }
        return rndArreglo;
    }
}
