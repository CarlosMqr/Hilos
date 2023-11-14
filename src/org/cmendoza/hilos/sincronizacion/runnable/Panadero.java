package org.cmendoza.hilos.sincronizacion.runnable;

import org.cmendoza.hilos.sincronizacion.Panaderia;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable{
    private Panaderia panaderia;

    public Panadero(Panaderia panaderia){
        this.panaderia = panaderia;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            panaderia.hornear("Pan concha: " + i);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
