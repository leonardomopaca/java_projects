package com.a01.training;

public class Cap2Intro {
    private static double[] altura = {1.75, 1.62, 1.78};

    public static void main (String args []){

        System.out.println(calculaMaiorAltura(altura));
        double [] altura2 = {1.85, 1.78, 1.82};
        System.out.println(calculaMaiorAltura(altura2));
    }

    public static double calculaMaiorAltura(double [] lista){
        double maiorAltura = 0;
        for(int i = 0; i < lista.length; i++){
            if( i == 0){
                maiorAltura = lista[i];
            }else{
                if(maiorAltura<lista[i]){
                    maiorAltura = lista[i];
                }
            }
        }
        return maiorAltura;
    }
}
