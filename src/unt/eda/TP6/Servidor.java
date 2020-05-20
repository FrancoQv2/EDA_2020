package unt.eda.TP6;

import java.util.Random;
import unt.eda.ADT_Fila.EmptyQueueException;
import unt.eda.ADT_Fila.IFila;
import unt.eda.ADT_Fila.Fila;

/**
 *  Trabajo Práctico N° 6
 *  Filas
 *  Implementación ADT Fila
 * @author Franco Quevedo
 */
public class Servidor {
    private IFila<Peticion> filaPrioridad = new Fila<>();
    private IFila<Peticion> filaComun = new Fila<>();
    
    private int probIngreso_peticion;
    private int probIngreso_prioritaria;
    private int tiempo_total; //tiempo que dura la simulacion [ms]

    private int tiempo_inactivo = 0; //tiempo de inactividad del servidor
    private int contador = 0; //contador que simula el paso del tiempo
    private int enCurso; //tiempo restante para terminar de procesar la peticion actual
    private int esperaMaxPrioridad; //tiempo max de espera
    private int esperaMaxComun; //tiempo max de espera
    
    private int cantidad_total = 0; //cantidad total de peticiones procesadas en el tiempo_total
    private int cantidad_prioritarias = 0; //cantidad de pp procesadas
    private int cantidad_prioritariasSinAtender = 0; //cantidad de pp sin procesar
    private int cantidad_comunes = 0; //cantidad de pc procesadas
    private int cantidad_comunesSinAtender = 0; //cantidad de pc sin procesar
    
    private int cantidadMax_prioritarias;
    private int cantidadMax_comunes;

    
    /**
     * Constructor para la probabilidad predeterminada del enunciado
     * Ingreso de peticion 1%
     * Peticion sea prioritaria 10%
     * @param tiempo_total valor ingresado en [s]
     */
    public Servidor(int tiempo_total) {
        this.tiempo_total = tiempo_total * 1000;
        this.probIngreso_peticion = 1;
        this.probIngreso_prioritaria = 10;
    }

    
    /**
     * Constructor para una probabilidad variable de ingreso de peticiones
     * @param tiempo_total valor ingresado en [s]
     * @param probIngreso_peticion valor 0-100 ingresado en [%]
     * @param probIngreso_prioritaria valor 0-10 ingresado en [s]
     */
    public Servidor(int tiempo_total, int probIngreso_peticion, int probIngreso_prioritaria) {
        this.tiempo_total = tiempo_total * 1000;
        this.probIngreso_peticion = probIngreso_peticion;
        this.probIngreso_prioritaria = probIngreso_prioritaria;
    }
    
    
    /**
     * Calcula la probabilidad de que ingrese una peticion al servidor
     * @return true si coincide con el valor probabilistico definido
     *         false si no coincide
     */
    public boolean ingresaPeticion(){
        Random rnd = new Random();
        int probIngreso = rnd.nextInt(100); //Genera un num aleatoria en un rango de 0-100
        
        return probIngreso <= this.probIngreso_peticion;
    }
    
    
    /**
     * Calcula la probabilidad de que una peticion sea prioritaria,
     * es decir, que sea de un usuario redgistrado
     * @return true si coincide con el valor probabilistico definido
     *         false si no coincide
     */
    public boolean esUsuarioRegistrado(){
        Random rnd = new Random();
        int probUsuarioRegistrado = 0;
        probUsuarioRegistrado = rnd.nextInt(100); //Simula peticion prioritaria
        
        return probUsuarioRegistrado <= this.probIngreso_prioritaria; //Si es menor que la probabilidad de ingreso retorna true
    }
    
    
    /**
     * Genera una nueva peticion 
     * @param tiempo_actual contador de la simulacion
     * @return nueva peticion con 
     *         tiempo = tiempo_actual
     *         t_in = tiempo_procesamiento generado aleatoriamente de rango 50-300ms
     */
    public Peticion nuevaPeticion(int tiempo_actual){
        Random rnd = new Random();
        int tiempo_procesamiento = rnd.nextInt(300) + 50;
        
        return new Peticion(tiempo_procesamiento, tiempo_actual);
    }
    
    
    /**
     * Simula el procesamiento de una peticion en un servidor web
     */
    public void procesar() {
        
        while(this.contador < this.tiempo_total){
            
            //ENFILAR PETICIONES
            if (this.ingresaPeticion()) {
                this.enfilarPeticiones(this.contador);
            }
            
            //PROCESAR PETICIONES
            if (this.enCurso > 0) {
                this.enCurso--;
            }
            else{
                if (this.filaPrioridad.esFilaVacia() == false) {
                    this.procesarPrioritarias();
                    this.cantidad_prioritarias++;
                }
                else
                if (this.filaComun.esFilaVacia() == false) {
                    this.procesarComunes();
                    this.cantidad_comunes++;
                }
                else {
                    this.tiempo_inactivo++;
                }
            }
            this.contador++;
        }
        this.prioritariasSinAtender();
        this.comunesSinAtender();
    }
    
    
    /**
     * Genera una fila con las peticiones simuladas
     * @param contador instante de tiempo con el que se va a crear una peticion
     */
    private void enfilarPeticiones(int contador) {
        Peticion p = this.nuevaPeticion(contador);
                
        if (this.esUsuarioRegistrado()) {
            this.filaPrioridad.enFila(p);
            this.cantidadMax_prioritarias++;
        }
        else{
            this.filaComun.enFila(p);
            this.cantidadMax_comunes++;
        }
        this.cantidad_total++;
    }
    
    
    /**
     * Procesa las peticiones prioritarias
     */
    private void procesarPrioritarias() {
        int espera;
        try{
            this.enCurso = this.filaPrioridad.frente().getTiempo();
            
            espera = this.contador - this.filaPrioridad.frente().getT_in();
            this.filaPrioridad.deFila();
            
            if (this.esperaMaxPrioridad < espera) {
                this.esperaMaxPrioridad = espera;
            }
        }
        catch(EmptyQueueException e){
            throw e;
        }
    }
    
    
    /**
     * Procesa las peticiones comunes
     */
    private void procesarComunes() { 
        int espera;
        try{
            this.enCurso = this.filaComun.frente().getTiempo();
            
            espera = this.contador - this.filaComun.frente().getT_in();
            this.filaComun.deFila();
            
            if (this.esperaMaxComun < espera) {
                this.esperaMaxComun = espera;
            }
        }
        catch(EmptyQueueException e){
            throw e;
        }
    }

    
    /**
     * Calcula la cantidad de peticiones prioritarias que no se llegaron a atender en el tiempo_total
     */
    private void prioritariasSinAtender(){
        this.cantidad_prioritariasSinAtender = this.cantidadMax_prioritarias - this.cantidad_prioritarias;
    }
    
    
    /**
     * Calcula la cantidad de peticiones comunes que no se llegaron a atender en el tiempo_total
     */
    private void comunesSinAtender(){
        this.cantidad_comunesSinAtender = this.cantidadMax_comunes - this.cantidad_comunes;
    }
    
    
    public int getTiempo_inactivo() {
        return tiempo_inactivo;
    }

    public int getEsperaMaxPrioridad() {
        return esperaMaxPrioridad;
    }

    public int getEsperaMaxComun() {
        return esperaMaxComun;
    }

    public int getCantidad_total() {
        return cantidad_total;
    }

    public int getCantidad_prioritarias() {
        return cantidad_prioritarias;
    }

    public int getCantidad_prioritariasSinAtender() {
        return cantidad_prioritariasSinAtender;
    }

    public int getCantidad_comunes() {
        return cantidad_comunes;
    }

    public int getCantidad_comunesSinAtender() {
        return cantidad_comunesSinAtender;
    }

    public int getTiempo_total() {
        return tiempo_total;
    }

    public int getCantidadMax_prioritarias() {
        return cantidadMax_prioritarias;
    }

    public int getCantidadMax_comunes() {
        return cantidadMax_comunes;
    }

    public int getProbIngreso_peticion() {
        return probIngreso_peticion;
    }

    public int getProbIngreso_prioritaria() {
        return this.probIngreso_prioritaria;
    }
}