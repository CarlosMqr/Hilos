package org.cmendoza.hilos.tarea;

import org.cmendoza.hilos.executor.ScheduleExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TareaScheduleExecutorServicePeriodo {
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        AtomicInteger atomic = new AtomicInteger(2);

        executor.scheduleAtFixedRate(()->{
            int a = atomic.getAndDecrement();
            if (a > 0){

                try {
                    for (int i = 0; i < 10 ; i++) {
                        System.out.print("\t" + i);
                        TimeUnit.SECONDS.sleep(1);

                    }
                    System.out.println("\n");
                    for (char c = 'A'; c <= 'Z'; c++) {
                        System.out.print("\t" + c);
                        TimeUnit.SECONDS.sleep(1);
                    }
                    System.out.println("\n");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }else {
                executor.shutdown();
            }


        },500,1000, TimeUnit.MILLISECONDS);











    }
}


