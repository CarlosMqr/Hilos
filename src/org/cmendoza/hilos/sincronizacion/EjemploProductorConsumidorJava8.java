package org.cmendoza.hilos.sincronizacion;
import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductorConsumidorJava8 {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();

        new Thread(() ->{//hornear
            for (int i = 0; i < 10; i++) {
                p.hornear("Pan concha: " + i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }//cach

            }//for
        }).start();

        new Thread(() ->{//consumir
        for (int i = 0; i < 10; i++) {
            p.consumir();
        }//for
        }).start();






    }
}
