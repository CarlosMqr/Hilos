package org.cmendoza.hilos.tarea;

public class Tarea {
    public static void main(String[] args) {
        AlfanumericoTarea hilo1 = new AlfanumericoTarea(Tipo.LETRA);
        AlfanumericoTarea hilo2 = new AlfanumericoTarea(Tipo.NUMERO);

        Thread hiloA = new Thread(hilo1);
        Thread hiloB = new Thread(hilo2);


        hiloA.start();
        hiloB.start();


    }
}


