package org.cmendoza.hilos;

import org.cmendoza.hilos.clasethread.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) {
        Thread hilo = new NombreThread("Carlos Mendoza");// cuando se crea la instancia es un hilo nuevo

        hilo.start();//para ejecutar con run; el star invoca al run()

        Thread hilo2 = new NombreThread("Jazmin Diaz");
        hilo2.start();

        NombreThread hilo3 = new NombreThread("jessy");
        hilo3.start();

        System.out.println(hilo.getState());

    }
}
