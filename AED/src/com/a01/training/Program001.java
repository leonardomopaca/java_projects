package com.a01.training;

public class Program001{
    public static void main(String[] args){
        /*int age;
        System.out.println("Insert your age");
        Scanner ageScan = new Scanner(System.in);
        age = ageScan.nextInt();

        if(age>0){
            if(age>18){
                System.out.println("Welcome");
            }else{
                System.out.println("Too Young");
            }
        }else{
            System.out.println("Error!");
        }

        System.out.println("Checking age using else if");
        System.out.println("Insert new age");
        ageScan = new Scanner(System.in);
        age = ageScan.nextInt();
        if(age<=0){
            System.out.println("Error");
        }else if(age<=16){
            System.out.println("Too Young");
        }else if(age<100){
            System.out.println("Welcome");
        }else{
            System.out.println("Really??");
        }

        String nome;// = "Ana";
        System.out.println("Insira um nome");
        Scanner nomeInserido = new Scanner(System.in);
        nome = nomeInserido.next();
        switch(nome){
            case "Leonardo":
                System.out.println("Ana concatenado com  " + nome);
                break;
            case "Ana":
                System.out.println("Leonardo concatenado com " + nome);
                break;
            default:
                System.out.println("Nenhuma das opções");
        }

        String [] nomes = {"A","B","C"};
        System.out.println("Array de Strings");
        System.out.println(nomes[0]);

        int [] myArr = {6, 42, 3, 7};
        int sum=0;
        for(int x = 0; x < myArr.length; x++){
            sum += myArr[x];
        }
        System.out.println(sum);

        double sum2 = 0.0;
        for(int i = 0; i<4; i++){
            sum2 += myArr[i];
        }
        System.out.println("Segunda soma = " + sum2);

        int [] primes = {2, 3, 5, 7};

        for(int t: primes){
            System.out.println(t);
        }
*/
        int [] [] secondArray = {{1, 2, 3},{4},{5, 6, 7}};
        //secondArray[0][2] = 42;
        System.out.println(secondArray[0][2]);
        int x = secondArray[1][0];
        System.out.println(secondArray[1][0]);

        System.out.println("What is the output of this code?");
        int result = 0;
        for (int i = 0; i < 5; i++){
            if (i == 3){
                result += 10;
            } else {
                result += i;
            }
        }
        System.out.println(result);
    }
}