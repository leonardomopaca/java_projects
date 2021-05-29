package com.leo.designpatterns;

public class ICMS {

    public double calculaICMS(Orcamento orcamento){
        return orcamento.getValor() * 0.1;
    }

}
