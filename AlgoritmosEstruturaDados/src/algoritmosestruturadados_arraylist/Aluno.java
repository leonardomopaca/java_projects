/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosestruturadados_arraylist;

/**
 *
 * @author Leonardo Mopaca
 */
public class Aluno {
    private String nome;
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String toString(){
        return this.nome;
    }
    //Não entendi essa parte
    public boolean equals(Object o){
        Aluno outro = (Aluno)o;
        return this.nome.equals(outro.nome);
    }
}

