package com.leo.typestest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        System.out.println("teste ok");

        BigDecimal resultado = new BigDecimal("130000").divide(new BigDecimal("4.930000"), 2, RoundingMode.HALF_EVEN);
        System.out.println(resultado);


        List<Integer> itens = Arrays.asList(11, 10, 16, 5, 85);

        System.out.println("**********************************");
        System.out.println("************PARTE1****************");
        System.out.println("**********************************");
        for(Integer item : itens){
            if(item == 16)
            System.out.println(item);
        }

        System.out.println("**********************************");
        System.out.println("************PARTE2****************");
        System.out.println("**********************************");
        itens.forEach(item -> System.out.println(item));
        itens.stream().filter(i -> i == 16).forEach(System.out::println);
        System.out.println("**********************************");
        System.out.println("************PARTE3****************");
        System.out.println("**********************************");
        itens.forEach(System.out::println);
    }
}
