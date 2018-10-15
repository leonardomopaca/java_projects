/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosestruturadados;

import java.util.Arrays;

/**
 *
 * @author Leonardo Mopaca
 */
public class Vetor {
    private Aluno[] alunos = new Aluno[100];
    private int totalDeAlunos = 0;
    
    public void adiciona(Aluno aluno){
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
        this.alunos[this.totalDeAlunos] = aluno;
        this.totalDeAlunos++;
    }
    
    /* Só podemos adicionar um aluno em alguma posição que ja estava ocupada 
    ** ou na primeira posicao vazia da lista.
    ** É preciso deslocar todos os alunos para a direita da posição escolhida
    ** Caso a posição escolhida seja a última, não será necessário o deslocamento
    */
    public void adiciona(int posicao, Aluno aluno){
        //verificar se há espaço suficiente para inclusão de novo aluno
        this.garantaEspaco();
        //primeiro verificamos se a posição é válida
        if(!this.posicaoValida(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }
        //faz um loop para deslocar os valores à direita
        for(int i = totalDeAlunos - 1; i >= posicao; i -= 1 ){
            //valor de i+1 é a posição da direita
            //this.alunos[i] contém o valor que será deslocado à direita
            this.alunos[i+1] = this.alunos[i];
        }
        //coloca o aluno passado por argumento na posição indicada
        this.alunos[posicao] = aluno;
        //nosso array tem um aluno a mais, portanto temos que acrescentar mais
        //um no contador
        this.totalDeAlunos++;
    }
    
    public Aluno pega(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }
        return this.alunos[posicao];
    }
    
    public void remove(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }
        
        this.alunos[posicao] = null;
        
        for(int i = posicao; i<this.totalDeAlunos-1; i++){
            this.alunos[i] = this.alunos[i+1];
        }
        
        totalDeAlunos--;
        System.out.println(totalDeAlunos);
    
    }
    
    public boolean contem(Aluno aluno){
        for(int i = 0; i < this.totalDeAlunos; i++){
            if(aluno.equals(this.alunos[i])){ 
                return true;
            }
        }
        return false;
    }
    
    public int tamanho(){ 
        return this.totalDeAlunos;
    }
    
    @Override
    public String toString(){
        if(this.totalDeAlunos == 0){
            return "[]";
        }
        
        StringBuilder builder = new StringBuilder();
        
        builder.append("[");
        
        for(int i = 0; i < this.totalDeAlunos-1; i++){
            builder.append(this.alunos[i]);
            builder.append(", ");
        }
        
        builder.append(this.alunos[this.totalDeAlunos - 1]);
        builder.append("]");
        return builder.toString();
    }
    
    private boolean posicaoOcupada(int posicao){
        return posicao >=0 && posicao < this.totalDeAlunos;
    }
    
    private boolean posicaoValida(int posicao){
        // no statement posicao <+ this.totalDeAlunos colocamos <= porque
        //pegaria a primeira posição vazia depois do último elemento da lista.
        return posicao >= 0 && posicao <= this.totalDeAlunos;
    }
    
    private void garantaEspaco(){
        
        if(this.totalDeAlunos == this.alunos.length){
            Aluno[] novaArray = new Aluno[this.alunos.length * 2];
            for(int i=0; i < totalDeAlunos; i++){
                novaArray[i] = alunos[i];
            }
            this.alunos = novaArray;
        }
        
    }
}
