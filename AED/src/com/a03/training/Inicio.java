package com.a03.training;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inicio {
    static int x = 15;
    public static void main(String[] args) {
        System.out.println(x);
        for (int i = 0; i < 100 ; i++) {
            if(i>50 && i < 60){
                continue;
            }
            System.out.print(" " + i);
        }
        System.out.println("\n " + Teste01.valor);

        String x = new String("fj11");
        String y = new String("fj11");
        System.out.println(" == ");
        if ( x == y){
            System.out.println("referencia para o mesmo objeto");
        }else{
            System.out.println("referencia para diferentes objetos");
        }

        System.out.println(" equals ");
        if ( x.equals(y)){
            System.out.println("iguais no critério da igualdade");
        }else{
            System.out.println("diferentes no critério de igualdade");
        }

        int [] array = new int[0];
        System.out.println(array.length);
        //array[0] = 1;

        List lista = new ArrayList();
        lista.add(1);
        lista.add("Leonardo");
        lista.add(new Funcionario());

        System.out.println(lista.get(1) + " " + lista.get(2) + " " + lista.get(0));

        List<String> lista02 = new LinkedList<String>();
        lista02.add("A");
        lista02.add("B");
        lista02.add("C");
        lista02.add("D");

        lista02.get(2);

    }
}
