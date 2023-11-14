package org.cmendoza.hilos.executor;

import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduleExecutorServicePeriodo {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main");

        //CountDownLatch lock = new CountDownLatch(5);// es una instancia de un contador y se va a repetir 5 veces

        AtomicInteger ato = new AtomicInteger(5);

     executor.scheduleAtFixedRate(() ->{
            System.out.println("Hola mundo tarea....");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);// vuelve a demorarse
               // lock.countDown();// decrementa el lock hasta cero
                ato.getAndDecrement();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        },500,1000,TimeUnit.MILLISECONDS);// se retrasa en ejecutarse 2 segundos y medio con el de 1000

        //TimeUnit.SECONDS.sleep(10);//se va a repetir durate los 10 segundos

        //lock.await();//bloquea el hilo del main hasta que llegue a cero y después se ejecuta el amin

        //este va de la mano con el AtomicInteger
        while (ato.get() >= 0){//va a iterar hasta que sea cero
            if (ato.get() == 0){//ya cuando sea igual a cero
                executor.shutdown();//apagamos
                ato.getAndDecrement();//tenemos que volver a iterar para que de cero pase a -1 y se salga del while
            }
        }

        System.out.println("Alguna otra tarea....");//se imprime en segundo lugar por el delay de la tarea

        executor.shutdown();// apaga el hilo




    }
}
