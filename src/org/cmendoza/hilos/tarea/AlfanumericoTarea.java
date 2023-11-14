package org.cmendoza.hilos.tarea;

import java.util.concurrent.TimeUnit;


public class AlfanumericoTarea implements Runnable{

    private Tipo tipo;

    //CONSTRUCTOR

    public AlfanumericoTarea(Tipo tipo){
        this.tipo = tipo;
    }

    public Tipo getTipo(){
        return this.tipo;
    }


    @Override
    public void run() {
        try {
            switch (tipo){
                case NUMERO ->{
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Numero " + i);
                        TimeUnit.SECONDS.sleep(2);
                    }
                }

                case LETRA -> {
                    for (char c = 'A';c <= 'Z'; c++){
                        System.out.println(c);
                        TimeUnit.SECONDS.sleep(1);
                    }

                }

            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }



}
