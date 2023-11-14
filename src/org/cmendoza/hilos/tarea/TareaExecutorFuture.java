package org.cmendoza.hilos.tarea;

import java.util.concurrent.*;

public class TareaExecutorFuture{

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = ()->{
            System.out.println("Comienza la tarea");
            try {
                        for (int i = 1; i <= 10; i++) {
                            System.out.print("\t" + i);
                            TimeUnit.SECONDS.sleep(1);
                        }
                System.out.println("\n");
                        for (char c = 'A';c <= 'Z'; c++){
                            System.out.print("\t" + c);
                            TimeUnit.SECONDS.sleep(1);
                        }
                System.out.println("\n");

            }catch (InterruptedException e){
                e.printStackTrace();
            }

        };


        Future<?> resultado = executor.submit(tarea);
        System.out.println("Finaliza la tarea " + resultado.isDone());



        System.out.println("Cuando es Runnable devuelve: " + resultado.get());
        System.out.println("Finaliza la tarea " + resultado.isDone());

        executor.shutdown();








    }
}
