package org.cmendoza.hilos.executor;

import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = () ->{

            System.out.println("Inicio de la tarea");
            try {
                System.out.println("Nombre del Thread" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);//ya maneja la conversion de tiempo

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();//para interrumpir el hilo actual y se libera
                e.printStackTrace();
            }

            System.out.println("Finaliza la tarea......");
        };

        executor.submit(tarea);// devuelve un objeto del tipo future o algún valor
        //pero sigue en funcionamiento el executor y debemos detenerlo
        executor.shutdown();//finaliza la tarea y también las que están en cola
        System.out.println("continuando con el método main() 1 ");
        executor.awaitTermination(2,TimeUnit.SECONDS);//espera que finalicen las treas para continuar
        // con el hilo del método main()
        System.out.println("continuando con el método main() 2 ");




















    }
}
