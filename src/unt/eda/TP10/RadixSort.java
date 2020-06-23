package unt.eda.TP10;

import unt.eda.ADT_Fila.EmptyQueueException;
import unt.eda.ADT_Fila.Fila;
import unt.eda.ADT_Fila.IFila;

/**
 *  Trabajo Práctico N° 10
 *  Clasificación
 *  Implementación Radix Sort
 * @author Franco Quevedo
 */
public class RadixSort {
    public static final int BASE_DECIMAL = 10;
    public static final int BASE_BINARIA = 2;
    public static final int BASE_OCTAL = 8;
    public static final int BASE_HEXADECIMAL = 16;

    /**
     * Ordena un arreglo de enteros decimales en orden ascendente
     * @param arreglo
     * @param n_Claves
     * @param k_Digitos
     */
    public static void ordenarArreglo(int arreglo[], int n_Claves, int k_Digitos) {
        IFila<Integer>[] auxFila = new Fila[10];    //Crea un arreglo de filas para poder ordenar otro arreglo
        
        //Inicializa la fila correspondiente del arreglo
        for (int i = 0; i < 10; i++) {
            auxFila[i] = new Fila();
        }
        
        for (int i = 0; i < k_Digitos; i++) {
            //Como trabajo con decimales, el valor posicional es igual a 10^n
            int valorPosicional = (int) Math.pow(BASE_DECIMAL, i);
            
            //Obtengo el indice correspodiente a la posicion de la cifra que estoy analizando de una clave
            //Si es cero entonces no existen elementos con ese valor posicional dentro de la clave
            //Si no es cero, lo agreglo a su fila correspondiente
            for (int j = 0; j < n_Claves; j++) {
                int indiceActual = (arreglo[j] / valorPosicional) % BASE_DECIMAL;
                auxFila[indiceActual].enFila(arreglo[j]);
            }
            
            mostrarFilaPosicion((Fila[]) auxFila);  //Necesario para ir mostrando las filas como en el ejemplo

            ordenarPorFila(arreglo, (Fila[]) auxFila);

            mostrarArreglo(arreglo);    //Muestra el arreglo despues de ordenarlo
        }
    }
    
    
    /**
     * Muestra por pantalla un arreglo de filas
     */
    private static void mostrarFilaPosicion(Fila[] fila){
        for (int i = 0; i < 10; i++) {
                try {
                    System.out.print("Fila " + i + ": ");
                    fila[i].mostrarFila();
                }
                catch(EmptyQueueException e) {
                    System.out.println("-");
                }
            }
    }
    
    
    /**
     * Reordeno un arreglo con el contenido de cada fila
     */
    private static void ordenarPorFila(int arreglo[], Fila[] fila){
        int indice = 0;
        
        for (int k = 0; k < 10; k++) {
            while(!fila[k].esFilaVacia()){
                arreglo[indice] = (Integer) fila[k].frente();
                fila[k].deFila();
                indice++;
            }
        }
    }
    
    
    /**
     * Muestra por pantalla un arreglo de enteros
     * @param arreglo
     */
    public static void mostrarArreglo(int[] arreglo){
        System.out.print("\nArreglo: [ ");
        for (int i = 0; i < arreglo.length; i++) {
            if (i == arreglo.length - 1) {
                System.out.print(arreglo[i]);
            }
            else {
                System.out.print(arreglo[i] + ",");
            }
        }
        System.out.println(" ]\n");
    }
    
    
    /**
     * Invierte el orden de un arreglo
     * @param arreglo
     * @return el arreglo invertido
     */
    public static int[] invertirArreglo(int[] arreglo){
        int aux; // El elemento temporal del arreglo que vamos a intercambiar
        int longitudDeArreglo = arreglo.length;
        
        for (int i = 0; i < longitudDeArreglo / 2; i++) {
          aux = arreglo[i];     // Guardo el actual
          int indiceContrario = longitudDeArreglo - i - 1;      // El índice de la otra mitad
          arreglo[i] = arreglo[indiceContrario];    // El valor actual es el valor contrario, el de la otra mitad
          arreglo[indiceContrario] = aux;   // Y el de la otra mitad, es el que había en el actual originalmente
        }
        return arreglo;
    }
}
