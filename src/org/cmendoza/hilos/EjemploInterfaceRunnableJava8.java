package org.cmendoza.hilos;

import org.cmendoza.hilos.runnable.ViajeTarea;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();//sirve para obtener el hilo en cuestion

        Runnable viaje = () ->{//clase anónima con expresión Lambda y el método run no lleva argumentos
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    try {// de esta forma se observará que se van intercalando, pero se ejecutan el mismo tiempo
                        Thread.sleep((long)Math.random() * 1000);//se hace un cast
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
            System.out.println(main.getState());
        };

        Thread v1 = new Thread( viaje,"oxaca");
        Thread v2 = new Thread( viaje,"Carlos Mendoza");
        Thread v3 = new Thread( viaje,"Jazmin Diaz");
        Thread v4 = new Thread( viaje,"Puebla");

        //el join se ejecuta en la instancia y no estatico

        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v1.join();// se une el hilo principal con el hilo del viaje 1
        v2.join();
        v3.join();
        v4.join();

      //  Thread.sleep(100);// se duerme el main el tiempo indicado es statico y ejecuta el hilo donde de instancia

        System.out.println("continuado con el método main: " + main.getName());





    }
}
