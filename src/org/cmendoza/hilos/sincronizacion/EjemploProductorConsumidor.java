package org.cmendoza.hilos.sincronizacion;

import org.cmendoza.hilos.sincronizacion.runnable.Consumidor;
import org.cmendoza.hilos.sincronizacion.runnable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();

        //new Thread(new Panadero(p)).start();
        //new Thread(new Consumidor(p)).start();

        //es la misma forma de implementar
        // Thread implemente Runnable

        Thread hilo1 = new Thread(new Panadero(p));
        Thread hilo2 = new Thread(new Consumidor(p));
        hilo1.start();
        hilo2.start();







    }
}
