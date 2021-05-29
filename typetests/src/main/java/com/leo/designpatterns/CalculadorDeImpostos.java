package com.leo.designpatterns;

public class CalculadorDeImpostos {

    public void realizaCalculo(Orcamento orcamento, String imposto){

        if("ICMS".equals(imposto)){
            // antes > double icms = orcamento.getValor() * 0.1;
            //depois que eu deixei a responsabilidade do cálculo na classe do imposto
            double icms = new ICMS().calculaICMS(orcamento);
            System.out.println(icms); //imprimirá 50.0
        }else if("ISS".equals(imposto)){
            //double iss = orcamento.getValor() * 0.06;
            double iss = new ISS().calculaISS(orcamento);
            System.out.println(iss); //imprimirá 30.0
        }


    }
}
