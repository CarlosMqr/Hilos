package org.cmendoza.hilos.executor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
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

        //si es Runnable no retorna nada
        // sí es calable retorna un objeto del tipo futuro o algún valor
        Future<String> resultado = executor.submit(tarea);// devuelve un objeto del tipo future o algún valor

        //sigue en funcionamiento el executor y debemos detenerlo
        executor.shutdown();//finaliza la tarea y también las que están en cola
        System.out.println("continuando con el método main() 1 ");

        System.out.println(resultado.isDone());// imprime sí ha terminado la tarea
        System.out.println(resultado.get());//bloquea el main hasta obtener el resultado pero resultado es Runnable
        System.out.println("Finaliza la tarea " + resultado.isDone());





















    }
}
