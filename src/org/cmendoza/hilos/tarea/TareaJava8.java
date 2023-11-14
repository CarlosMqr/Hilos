package org.cmendoza.hilos.tarea;

import java.util.concurrent.TimeUnit;

public class TareaJava8 {
    public static void main(String[] args) {

        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Numero " + i);
                    TimeUnit.SECONDS.sleep(1);
                }
                for (char c = 'A'; c <= 'Z'; c++) {
                    System.out.print("\t" + c);
                    TimeUnit.SECONDS.sleep(1);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();





    }
}
