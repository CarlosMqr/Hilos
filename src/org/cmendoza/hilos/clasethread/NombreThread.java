package org.cmendoza.hilos.clasethread;

public class NombreThread extends Thread {

    /*
    implementar un constructor para personalizar el nombre en caso de darle un nombre
    propio
     */
    public NombreThread(String name) {
        super(name);
    }

    //getName() se obtiene el nombre del thread
    @Override
    public void run() {
        System.out.println("Se inicia el método  run del hilo " + getName());

        //en medio hacer una tarea
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName());// imprime 10 veces el nombre del hilo
        }

        System.out.println("finaliza el hilo");
    }
}
