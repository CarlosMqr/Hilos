package org.cmendoza.hilos.tarea;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class TareaExecutor {
    public static void main(String[] args) {


        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);


        Runnable hiloA = new AlfanumericoTarea(Tipo.LETRA);
        Runnable hiloB = new AlfanumericoTarea(Tipo.NUMERO);

        Future<?> futuro1 = executor.submit(hiloA);
        Future<?> futuro2 = executor.submit(hiloB);

        executor.shutdown();



    }
}
