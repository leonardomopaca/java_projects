/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos3;

/**
 *
 * @author Leonardo Mopaca
 */
public class IniciaTeste {
    public static void main (String[] args){
        Aluno aluno = new Aluno();
        System.out.println(aluno.getNome());
    }
    
    public static void testeAdicionaNoFim(){
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        
        a1.setNome("Rafael");
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
        a2.setNome("Paulo");
        a3.setNome("Ana");
        
        Vetor lista = new Vetor();
        
        lista.adiciona(a1);
        lista.adiciona(a2);
        lista.adiciona(a3);
        
        System.out.println(lista);
    }
    
    public static void testePegaPorPosicao(){
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        
        a1.setNome("Rafael");
        a2.setNome("Paulo");
        
        Vetor lista = new Vetor();
        
        lista.adiciona(a1);
        lista.adiciona(a2);
        
        Aluno aluno1 = lista.pega(0);
        Aluno aluno2 = lista.pega(1);
        
        System.out.println(aluno1 + " " + aluno2);
        
    }
}
