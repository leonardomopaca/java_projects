package com.a02.training;

public enum CorSemaforo {
    VERMELHO(2000), AMARELO(500), VERDE(1500);
    //VERMELHO (""), AMARELO(""), VERDE("");

    private int tempoEspera;
//    private String priority;

    CorSemaforo(int tempoEspera){
        this.tempoEspera = tempoEspera;
    }

//    CorSemaforo(String priority){
//        this.priority = priority;
//    }

    public int getTempoEspera(){
        return tempoEspera;
    }

    //PRIMEIRO CODIGO ANTES DE EVOLUIR
    // OS VALORES DO TEMPO DE CADA ATRIBUTO NÃO ERA SETADO NA ENUM, MAS SIM NO MÉTODO RUN
}
