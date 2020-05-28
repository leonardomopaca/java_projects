package com.leo.dio.hashexample;

import java.util.HashMap;

/*Aqui será utilizado um HashMap<Congressita, String> para complementar o exemplo.
Será utilizado o primeiro objeto como chave e o segundo como valor agregado a esta chave.
Congressista será a chave da nossa busca e a String será o valor atrelado a este objeto encontrado.
* */
public class Busca {

    public static void main(String[] args) {
        Congressista con1 = new Congressista("Leonardo", 30286815877L);
        Congressista con2 = new Congressista("Juliana", 13596745820L);

        HashMap<Congressista, String> hash = new HashMap<Congressista, String>();

        // Inserção dos congressistas no HashMap
        hash.put(con1, "Info importante sobre Leonardo");
        hash.put(con2, "Info importante sobre Juliana");
        /*
        *  Criaremos um terceiro congressita e iremos efetuar uma busca
        * para ver se o algoritimo está, de fato, funcionando.
        * Não será encontrado o objeto porque Primeiro: não o inserimos no HashMap
        * Segundo: o tamanho do nome não bate com nenhum tamanho de nome inserido.
        * */

        Congressista con3 = new Congressista("Felipe", 15478549863L);
        System.out.println("Verificando se existe Felipe");
        System.out.println(hash.containsKey(con3));

        /*
        * Aqui iremos procurar por um nome que coincida com o valor de algum
        * que já esteja cadastrado, Mas - muito importante - não bate com o nome
        * do congressista que está lá. Por isto é importante a implementação do
        * método equals()
        * */

        Congressista con4 = new Congressista("Mariana", 30158412240L);
        System.out.println("Verificando se existe Mariana");
        System.out.println(hash.containsKey(con4));

        /*
        * Por fim, iremos pesquisar por um objeto que já exista e exibir suas informações
        * */


        String info = hash.get(con1);
        System.out.println("con1");
        System.out.println(info);

        System.out.println("con2");
        System.out.println(hash.get(con2));
    }
}
