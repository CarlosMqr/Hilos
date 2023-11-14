package org.cmendoza.hilos;

import org.cmendoza.hilos.runnable.ImprimeFrases;

public class EjemploSincronizacionThread {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ImprimeFrases("Hola","que tal")).start();
        new Thread(new ImprimeFrases("quien eres" , "tú")).start();
        //comenzarán los dos primeros hilos
        //cuando comienza el tercer hilo estará ocupado o bloqueada,
        //ya que en el método imprimirfrases estará ocupado por el hilo 1 o el hilo 2

        Thread h3 = new Thread(new ImprimeFrases("muchas", "gracias amigo"));
        h3.start();
        Thread.sleep(100);
        System.out.println(h3.getState());
    }
    // varios hilos usan este método para sincronizar
    // y no imprimir uno y uno de cada hilo
    public synchronized static void imprimirFrases(String frase1, String frase2){// sincroniza los hilos
        //para que las palabras no se impriman desordenadamente
        System.out.println(frase1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(frase2);
    }

}
