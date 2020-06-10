package com.leo.dio.list;

import java.util.*;

public class ExampleList {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        nomes.add("Carlos");
        nomes.add("Pedro");
        nomes.add("Juliana");
        nomes.add("Maria");
        nomes.add("João");

        System.out.println(nomes);

        System.out.println("Ordenando nomes: ");

        Collections.sort(nomes);
        System.out.println(nomes);

        System.out.println("Reverse list: ");
        Collections.reverse(nomes);
        System.out.println(nomes);

        System.out.println(nomes.indexOf("João"));

        nomes.hashCode();

        for (String nome: nomes) {
            System.out.println("==>" + nome);
        }

        Iterator<String> iterator = nomes.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Queue<String> nomes = new LinkedList<String>();
        nomes.add("ABC");
        nomes.add("BCD");
        nomes.add("CDE");
        nomes.add("DEF");



    }
}
