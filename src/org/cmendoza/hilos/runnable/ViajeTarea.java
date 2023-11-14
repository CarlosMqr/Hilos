package org.cmendoza.hilos.runnable;


public class ViajeTarea implements Runnable{
    //como no heredamos de Thread necesitamos implementar atributos
    private String nombre;
    public ViajeTarea(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    @Override
    public  void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " - " + getNombre());
            try {// de esta forma se observará que se van intercalando pero se ejecutan el mismo tiempo
                Thread.sleep((long)Math.random() * 1000);//se hace un cast
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Finalmente me voy de viaje a: " + nombre);

    }
}
