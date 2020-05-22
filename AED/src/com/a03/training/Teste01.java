package com.a03.training;

public class Teste01 {
    public static int valor = 10;

    public void avaliaFuncionario(){
        Funcionario f = new Gerente();

        Analista a = new Analista();

        f = a;

    }
}
