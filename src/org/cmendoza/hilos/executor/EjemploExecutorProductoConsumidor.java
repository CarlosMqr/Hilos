package org.cmendoza.hilos.executor;

import org.cmendoza.hilos.sincronizacion.Panaderia;
import org.cmendoza.hilos.sincronizacion.runnable.Consumidor;
import org.cmendoza.hilos.sincronizacion.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductoConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        Panaderia p = new Panaderia();//recurso compartido
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);

        Future<?> futuro1 = executor.submit(productor);
        Future<?> futuro2 = executor.submit(consumidor);





        //sigue en funcionamiento el executor y debemos detenerlo
        executor.shutdown();//finaliza la tarea y también las que están en cola
        System.out.println("continuando con el método main() 1 ");























    }
}
