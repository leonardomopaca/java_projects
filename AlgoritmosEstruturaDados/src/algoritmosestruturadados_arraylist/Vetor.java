/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosestruturadados_arraylist;

import java.util.Arrays;

/**
 *
 * @author Leonardo Mopaca
 */
public class Vetor {
    //private Aluno[] alunos = new Aluno[100];
    private Object[] objetos = new Object[100];
    //private int totalDeAlunos = 0;
    private int totalDeObjetos = 0;
    
    public void adiciona(Object objeto){
        //versão consumo linear, pois teremos que percorrer toda a lista até
        //encontrar o índice vazio
//                        for(int i = 0; i < this.alunos.length; i++){
//                            if(this.alunos[i]==null){
//                                this.alunos[i] = aluno;
//                                break;
//                            }
//                        }
        //versão contínua, pois já guardamos em uma variável o total de alunos
        //adicionados
        this.garantaEspaco();
        this.objetos[this.totalDeObjetos] = objeto;
        this.totalDeObjetos++;
    }
    
    /* Só podemos adicionar um aluno em alguma posição que ja estava ocupada 
    ** ou na primeira posicao vazia da lista.
    ** É preciso deslocar todos os alunos para a direita da posição escolhida
    ** Caso a posição escolhida seja a última, não será necessário o deslocamento
    */
    public void adiciona(int posicao, Object objeto){
        //verificar se há espaço suficiente para inclusão de novo aluno
        this.garantaEspaco();
        //primeiro verificamos se a posição é válida
        if(!this.posicaoValida(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }
        //faz um loop para deslocar os valores à direita
        for(int i = totalDeObjetos - 1; i >= posicao; i -- ){
            //valor de i+1 é a posição da direita
            //this.alunos[i] contém o valor que será deslocado à direita
            this.objetos[i+1] = this.objetos[i];
        }
        //coloca o aluno passado por argumento na posição indicada
        this.objetos[posicao] = objeto;
        //nosso array tem um aluno a mais, portanto temos que acrescentar mais
        //um no contador
        this.totalDeObjetos++;
    }
    
    public Object pega(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }
        return this.objetos[posicao];
    }
    
    public void remove(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }
        
        this.objetos[posicao] = null;
        
        for(int i = posicao; i<this.totalDeObjetos-1; i++){
            this.objetos[i] = this.objetos[i+1];
        }
        
        totalDeObjetos--;
        System.out.println(totalDeObjetos);
    
    }
    
    public boolean contem(Object objeto){
        for(int i = 0; i < this.totalDeObjetos; i++){
            if(objeto.equals(this.objetos[i])){ 
                return true;
            }
        }
        return false;
    }
    
    public int tamanho(){ 
        return this.totalDeObjetos;
    }
    
    @Override
    public String toString(){
        if(this.totalDeObjetos == 0){
            return "[]";
        }
        
        StringBuilder builder = new StringBuilder();
        
        builder.append("[");
        
        for(int i = 0; i < this.totalDeObjetos-1; i++){
            builder.append(this.objetos[i]);
            builder.append(", ");
        }
        
        builder.append(this.objetos[this.totalDeObjetos - 1]);
        builder.append("]");
        return builder.toString();
    }
    
    private boolean posicaoOcupada(int posicao){
        return posicao >=0 && posicao < this.totalDeObjetos;
    }
    
    private boolean posicaoValida(int posicao){
        // no statement posicao <+ this.totalDeAlunos colocamos <= porque
        //pegaria a primeira posição vazia depois do último elemento da lista.
        return posicao >= 0 && posicao <= this.totalDeObjetos;
    }
    
    private void garantaEspaco(){
        if(this.totalDeObjetos == this.objetos.length){
            Object[] novaArray = new Object[this.objetos.length * 2];
            for(int i=0; i < this.objetos.length; i++){
                novaArray[i] = objetos[i];
            }
            this.objetos = novaArray;
        }
        
    }
}
