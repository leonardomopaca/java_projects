package com.leo.dio.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    }
}
