/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosestruturadados_arraylist;

import java.util.ArrayList;

/**
 *
 * @author Leonardo Mopaca
 */
public class Teste {
    public static void main(String args[]){
        ArrayList vetorSemGenerics = new ArrayList();
        ArrayList<Aluno> vetorComGenerics = new ArrayList<Aluno>();
        
        Aluno aluno = new Aluno();
        
        vetorSemGenerics.add(aluno);
        vetorComGenerics.add(aluno);
        
        Aluno a1 = (Aluno) vetorSemGenerics.get(0);
        Aluno a2 = vetorComGenerics.get(0);
        
    }
    
    public static void testeAdicionaNoFim(){
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        
        a1.setNome("Raphael");
        a2.setNome("Paulo");
        
        Vetor lista = new Vetor();
        
        lista.adiciona(a1);
        lista.adiciona(a2);
        
        System.out.println(lista);
        
    }

    public static void testeAdicionaPorPosicao(){
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();
        
        a1.setNome("Rafael");
        a1.setNome("Paulo");
        a1.setNome("Ana");
        
        Vetor lista = new Vetor();
        
        lista.adiciona(a1);
        lista.adiciona(0, a2);
        lista.adiciona(0, a3);
    }
}
