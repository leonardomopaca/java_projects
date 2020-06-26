package com.leo.dio.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ExampleQueue {
    public static void main(String[] args) {
        Queue<String> nomes = new LinkedList<String>();
        nomes.add("ABC");
        nomes.add("BCD");
        nomes.add("CDE");
        nomes.add("DEF");

        System.out.println(nomes.poll());

        System.out.println(nomes);

        nomes.add("EFG");

        System.out.println(nomes.peek());
        System.out.println(nomes);

        System.out.println(nomes.element());
        System.out.println(nomes);

        nomes.clear();

        System.out.println(nomes.peek());
        System.out.println(nomes);

        //nomes.add("FGH");

        try {
            System.out.println(nomes.element());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("\nA fila está vazia, erro lançado pelo método element()");
        }


    }
}
