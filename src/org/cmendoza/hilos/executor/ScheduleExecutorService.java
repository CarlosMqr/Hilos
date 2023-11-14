package org.cmendoza.hilos.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorService {
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main");

        executor.schedule(() ->{
            System.out.println("Hola mundo tarea....");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);// vuelve a demorarse
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        },2000,TimeUnit.MILLISECONDS);// se retrasa en ejecutarse 2 segundos y medio con el de 1000

        System.out.println("Alguna otra tarea....");//se imprime en segundo lugar por el delay de la tarea

        executor.shutdown();




    }


}
