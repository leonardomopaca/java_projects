package com.recycle.training;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String question = "Qual meu chocolate preferido?";
        String choiceOne = "Ao Leite";
        String choiceTwo = "Branco";
        String choiceThree = "Amargo";

        String correctAnswer = choiceThree;

        System.out.println(question);
        System.out.println("Selecione uma das opcoes: "
                + choiceOne + " - "
                + choiceTwo + " - "
                + choiceThree);

        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();

        if(choiceThree.toLowerCase().equals(input.toLowerCase())){
            System.out.println("Voce acertou");
        }else{
            System.out.println("Resposta incorreta");
        }

    }

}
