/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosestruturadados2;

/**
 *
 * @author Leonardo Mopaca
 */
public class Teste {
    public static void main(String[] args){
        //testeAdicionaNoFim();
        //testeContemAluno();
        //testePegaPorPosicao();
        //testeAdicionaPorPosicao();
        testeRemoverPorPosicao();
    }
    
    public static void testeAdicionaNoFim(){
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        
        a1.setNome("Joao");
        a2.setNome("Jose");
        
        Vetor lista = new Vetor();
        
        lista.adiciona(a1);
        lista.adiciona(a2);
        
        System.out.println(lista);  
    }
    
    public static void testeAdicionaPorPosicao(){
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();
        Aluno a4 = new Aluno();
        
        a1.setNome("Rafael");
        a2.setNome("Paulo");
        a3.setNome("Ana");
        //a4.setNome("Leonardo");
        
        Vetor lista = new Vetor();
        
        lista.adiciona(0, a1);
        lista.adiciona(0, a2);
        lista.adiciona(1, a3);
        
        //lista.adiciona(0, a4);
        
        System.out.println(lista);
    }
    
    //PEGAR ALUNO POR POSIÇÃO
    public static void testePegaPorPosicao(){
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        
        a1.setNome("Rafael");
        a2.setNome("Paulo");
        
        Vetor lista = new Vetor();
        
        lista.adiciona(a1);
        lista.adiciona(a2);
        
        //O método vai devolver um objeto do tipo aluno
        //Já tenho duas variáveis tipo Aluno, porém já foram usadas
        //para adicionar, vamos criar outras duas variáveis para não mistura-las
        //Aluno aluno1Retorno = lista.pega(1);
        //Aluno aluno2Retorno = lista.pega(0);
        
        //System.out.println("Aluno 1 Retorno: " + aluno1Retorno);
        //System.out.println("Aluno 2 Retorno: " + aluno2Retorno);
    }
    
    public static void testeRemoverPorPosicao(){
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();
        Aluno a4 = new Aluno();
        Aluno a5 = new Aluno();
        Aluno a6 = new Aluno();        
        
        a1.setNome("Rafael");
        a2.setNome("Paulo");
        a3.setNome("Maria");
        a4.setNome("Pedro");
        a5.setNome("João");
        a6.setNome("Julia");        
        
        Vetor lista = new Vetor();
        
        lista.adiciona(a1);
        lista.adiciona(a2);
        lista.adiciona(a3);
        lista.adiciona(a4);
        lista.adiciona(a5);
        lista.adiciona(a6);        
        
        lista.remove(0);
        
        System.out.println(lista);
    }
    
    public static void testeContemAluno(){
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        
        a1.setNome("Rafael");
        a2.setNome("Paulo");
        
        Vetor lista = new Vetor();
        
        lista.adiciona(a1);
        lista.adiciona(a2);
        
        System.out.println(lista.contem(a1));
        System.out.println(lista.contem(a2));
        
        Aluno aluno = new Aluno();
        aluno.setNome("Ana");
        
        System.out.println(lista.contem(aluno));
    }
    
    public static void testeTamanhoLista(){
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();
        
        a1.setNome("Rafael");
        a2.setNome("Paulo");
        
        Vetor lista = new Vetor();
        lista.adiciona(a1);
        lista.adiciona(a2);
        
        System.out.println(lista.tamanho());
        
        lista.adiciona(a3);
        
        System.out.println(lista.tamanho());
    }
    

}
