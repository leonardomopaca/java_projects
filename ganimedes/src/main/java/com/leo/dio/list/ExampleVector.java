package com.leo.dio.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ExampleVector {
    public static void main(String[] args) {
        List<String> esportes = new Vector<>();

        esportes.add("Fubotebol");
        esportes.add("Volei");
        esportes.add("Basquetebol");
        esportes.add("Handebol");
        esportes.add("Tenis");

        System.out.println("Altera o valor da posição 2 do vetor");
        esportes.set(2, "Ping Pong");
        System.out.println("Remove o esporte da posição 2");
        esportes.remove(2);
        System.out.println("Remove o esporte Handebol do vetor");
        esportes.remove("Handebol");

        System.out.println("Retorna o primeiro item do vetor");
        System.out.println(esportes.get(0));

        System.out.println("Navega no Vetor");
        for (String esporte: esportes) {
            System.out.println(esporte);
        }
    }
}
