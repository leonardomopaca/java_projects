package com.a02.training;

public class SimSemaforo{
    public static void main(String [] args){
        ThreadSemaforo semaforo = new ThreadSemaforo();

        for (int i = 0; i < 10; i++){
            System.out.println(semaforo.getCor());
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            semaforo.esperaCorMudar();
        }
        semaforo.setParar(true);
        System.out.println("Passando por aqui sem o parar");
    }
}