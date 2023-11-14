package org.cmendoza.hilos.sincronizacion;

public class Panaderia {
    private String pan;
    private boolean disponible;

    public synchronized void hornear(String masa){
        while (disponible){//disponible es false y no llama al while
            try {
                wait();// si disponible es true entra al while y queda esperando para que se ejecute el método consumir
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.pan = masa;
        System.out.println("Panadero hornea: " + this.pan);
        this.disponible = true;//dejamos en true porque está disponible el pan para ser consumido

        notify();//notificamos
    }

    public synchronized String consumir(){
        while (!disponible){//como está en true no entra al while

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Cliente consume pan: " + this.pan);
        this.disponible= false;// dejamos en, false porque el cliente está consumiendo el pan

        notify();
        return pan;
    }
}
