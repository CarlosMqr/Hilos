package org.cmendoza.hilos;

import org.cmendoza.hilos.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) throws InterruptedException {

        new Thread(new ViajeTarea("oxaca")).start();
        new Thread(new ViajeTarea("Carlos Mendoza")).start();
        new Thread(new ViajeTarea("Jazmin Diaz")).start();
        new Thread(new ViajeTarea("Puebla")).start();

    }
}
