package org.cmendoza.hilos.executor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        //ambas son tareas
        //Runnable no devuelve nada
        //Callable retorna algún objeto futuro o algún valor
        Callable<String> tarea = () ->{

            System.out.println("Inicio de la tarea");
            try {
                System.out.println("Nombre del Thread" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);//ya maneja la conversion de tiempo

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();//para interrumpir el hilo actual y se libera
                e.printStackTrace();
            }

            System.out.println("Finaliza la tarea......");
            return "Algún resultado importante de la tarea";
        };

        Callable<Integer> tarea3 = () -> {
            System.out.println("Iniciando la tarea 3");
          TimeUnit.SECONDS.sleep(3);
            return 10;
        };

        //si es Runnable no retorna nada
        // sí es call able retorna un objeto del tipo futuro o algún valor
        Future<String> resultado = executor.submit(tarea);// devuelve un objeto del tipo future o algún valor
        Future<String> resultado2 = executor.submit(tarea);
        Future<Integer> resultado3 = executor.submit(tarea3);


        //sigue en funcionamiento el executor y debemos detenerlo
        executor.shutdown();//finaliza la tarea y también las que están en cola
        System.out.println("continuando con el método main() 1 ");

        System.out.println(resultado.isDone());// imprime sí ha terminado la tarea
        System.out.println(resultado.get());//bloquea el main hasta obtener el resultado pero resultado es Runnable
        System.out.println("Finaliza la tarea 1: " + resultado.isDone());

        System.out.println(resultado2.get());
        System.out.println("Finaliza tarea 2: " + resultado2.isDone());

        System.out.println(resultado3.get());
        System.out.println("Finaliza tarea 3: " + resultado3.isDone());





















    }
}
