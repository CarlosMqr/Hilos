package org.cmendoza.hilos.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimer {
    public static void main(String[] args) {


        Timer timer = new Timer();//
        timer.schedule(new TimerTask() {//agenda una tarea
            @Override
            public void run() {
                System.out.println("Tarea realizada en " + new Date() + " nombre del thread: " +
                        Thread.currentThread().getName());
                System.out.println("finaliza la tarea");
                timer.cancel();
            }
        },500);// aquí se pone el tiempo que tardara en ejecutar la tarea

        System.out.println("Agendamos una tarea para 5 segundos más....");// print main()
        //va a imprimir primero el print del main porque la tarea tiene un daley de 5 segundos

    }
}
