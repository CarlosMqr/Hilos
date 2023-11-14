package org.cmendoza.hilos.timer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {
        /*
        repite una tarea cada determinado tiempo, pero necesitamos una variable de control
        para poder determinar cuantas veces se ejecutará la tarea
         */

        Toolkit toolKit = Toolkit.getDefaultToolkit();

        AtomicInteger conatdorAtomic = new AtomicInteger(3); //variable control

        Timer timer = new Timer();//tarea
        timer.schedule(new TimerTask() {
           // int contador = 3;//variable de control para que la tarea pueda finalizar
            @Override
            public void run() {
                int i = conatdorAtomic.getAndDecrement();//obtiene el decremento de la variable
                if (i > 0){
                    toolKit.beep();
                    System.out.println("Tarea " + i +  " periódica en " + new Date() + " nombre del thread: " +
                            Thread.currentThread().getName());
                    //contador --; //cuando el contador llegue a cero se sale y entra al else y se cancela
                }else {
                    System.out.println("finaliza la tarea");
                    timer.cancel();
                }
            }
        },1000,3000);// aquí se pone el tiempo que tardara en ejecutar la tarea
        //después el periodo en el que se volverá a ejecutar
        // se ejecuta de forma indeterminada tenemos que controlar hasta cuando se ejecutará la tarea

        System.out.println("Agendamos una tarea para 5 segundos más....");// print main()
        //va a imprimir primero el print del main porque la tarea tiene un daley de 5 segundos

    }
}
