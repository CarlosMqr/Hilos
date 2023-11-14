package org.cmendoza.hilos.runnable;
import static org.cmendoza.hilos.EjemploSincronizacionThread.imprimirFrases;


public class ImprimeFrases implements Runnable{
    private String frase1;
    private String frase2;

    public  ImprimeFrases(String frase1, String frase2){
        this.frase1 = frase1;
        this.frase2 = frase2;
    }

    @Override
    public void run() {
        imprimirFrases(this.frase1,this.frase2);

    }


}
