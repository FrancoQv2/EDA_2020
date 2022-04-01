package unt.eda.TP6;

import java.util.Random;
import unt.eda.ADT_Fila.EmptyQueueException;

/**
 *  Trabajo Práctico N° 6
 *  Filas
 *  Implementación ADT Fila
 * @author Franco Quevedo
 */
public class TestServidor {
    private static Random rnd = new Random();
    
    //Para el test tomaré valores no muy grandes de probabilidad
    //ya que esto generaria una sobrecarga de peticiones
    private static int rndTiempoTotal = rnd.nextInt(30) + 1; //Simulo un tiempo de funcionamiento 30seg (min 1seg - max 30seg)
    private static int rndProbPeticion = rnd.nextInt(30) + 1; //Simulo la probabilidad de ingreso de peticiones (min 1% - max 30%)
    private static int rndProbPrioritaria = rnd.nextInt(20) + 1; //Simulo la probabilidad de peticiones prioritarias (min 1% - max 20%)
        
    private static Servidor servidor_predeterminado = new Servidor(rndTiempoTotal);
    private static Servidor servidor_variable = new Servidor(rndTiempoTotal,rndProbPeticion,rndProbPrioritaria);
    
    
    /**
     * testProcesarServidorPredet
     * 
     * Simulo el procesamiento de peticiones en un servidor con probabilidades preterminadas por el enunciado
     */
    public static void testProcesarServidorPredet(){
        try{
            servidor_predeterminado.procesar();
        }
        catch(EmptyQueueException e){
            System.out.println("Hubo un error al procesar las peticiones.");
        }
    }
    
    
    /**
     * testProcesarServidorVariable
     * 
     * Simulo el procesamiento de peticiones en un servidor con probabilidades variables
     */
    public static void testProcesarServidorVariable(){
        try{
            servidor_variable.procesar();
        }
        catch(EmptyQueueException e){
            System.out.println("Hubo un error al procesar las peticiones.");
        }
    }
    
    
    /**
     * testInfoServidorPredet
     * 
     * Muestro por pantalla la información correspondiente a la simulación del servidor predeterminado
     */
    public static void testInfoServidorPredet(){
        System.out.println("Tiempo total de funcionamiento: \t\t\t" + servidor_predeterminado.getTiempo_total()/1000 + "[s]");
        System.out.println("Probabilidad de ingreso de peticiones: \t\t\t" + servidor_predeterminado.getProbIngreso_peticion() + "[%]");
        System.out.println("Probabilidad de peticiones prioritarias: \t\t" + servidor_predeterminado.getProbIngreso_prioritaria() + "[%]");
        System.out.println();
        
        System.out.println("Cantidad total de peticiones atendidas: \t\t" + servidor_predeterminado.getCantidad_total());
        System.out.println("Cantidad de peticiones prioritarias atendidas: \t\t" + servidor_predeterminado.getCantidad_prioritarias());
        System.out.println("Cantidad de peticiones prioritarias s/atender: \t\t" + servidor_predeterminado.getCantidad_prioritariasSinAtender());
        System.out.println("Cantidad de peticiones comunes atendidas: \t\t" + servidor_predeterminado.getCantidad_comunes());
        System.out.println("Cantidad de peticiones comunes s/atender: \t\t" + servidor_predeterminado.getCantidad_comunesSinAtender());
        System.out.println();
        
        System.out.println("Tiempo total del servidor inactivo: \t\t\t" + servidor_predeterminado.getTiempo_inactivo() + "[ms]");
        System.out.println("Tiempo max de espera de peticiones prioritarias: \t" + servidor_predeterminado.getEsperaMaxPrioridad() + "[ms]");
        System.out.println("Tiempo max de espera de peticiones comunes: \t\t" + servidor_predeterminado.getEsperaMaxComun() + "[ms]");
        System.out.println();
        
        System.out.println("Tamaño max de peticiones prioritarias: \t\t\t" + servidor_predeterminado.getCantidadMax_prioritarias());
        System.out.println("Tamaño max de peticiones comunes: \t\t\t" + servidor_predeterminado.getCantidadMax_comunes());
    }
    
    
    /**
     * testInfoServidorVariable
     * 
     * Muestro por pantalla la información correspondiente a la simulación del servidor variable
     */
    public static void testInfoServidorVariable(){
        System.out.println("Tiempo total de funcionamiento: \t\t\t" + servidor_variable.getTiempo_total()/1000 + "[s]");
        System.out.println("Probabilidad de ingreso de peticiones: \t\t\t" + servidor_variable.getProbIngreso_peticion() + "[%]");
        System.out.println("Probabilidad de peticiones prioritarias: \t\t" + servidor_variable.getProbIngreso_prioritaria() + "[%]");
        System.out.println();
        
        System.out.println("Cantidad total de peticiones atendidas: \t\t" + servidor_variable.getCantidad_total());
        System.out.println("Cantidad de peticiones prioritarias atendidas: \t\t" + servidor_variable.getCantidad_prioritarias());
        System.out.println("Cantidad de peticiones prioritarias s/atender: \t\t" + servidor_variable.getCantidad_prioritariasSinAtender());
        System.out.println("Cantidad de peticiones comunes atendidas: \t\t" + servidor_variable.getCantidad_comunes());
        System.out.println("Cantidad de peticiones comunes s/atender: \t\t" + servidor_variable.getCantidad_comunesSinAtender());
        System.out.println();
        
        System.out.println("Tiempo total del servidor inactivo: \t\t\t" + servidor_variable.getTiempo_inactivo() + "[ms]");
        System.out.println("Tiempo max de espera de peticiones prioritarias: \t" + servidor_variable.getEsperaMaxPrioridad() + "[ms]");
        System.out.println("Tiempo max de espera de peticiones comunes: \t\t" + servidor_variable.getEsperaMaxComun() + "[ms]");
        System.out.println();
        
        System.out.println("Tamaño max de peticiones prioritarias: \t\t\t" + servidor_variable.getCantidadMax_prioritarias());
        System.out.println("Tamaño max de peticiones comunes: \t\t\t" + servidor_variable.getCantidadMax_comunes());
    }
}