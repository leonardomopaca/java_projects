package com.teste.lista;

public class ListaLigada {
    Node head; // HEAD of the list
    
    class Node{
        public int valor;
        public Node prox;
        
        public Node(int x){
            this.valor = x;
            this.prox = null;
        }
    }
    
    void pairWiseSwap(){
        Node temp = head;
        //Traverse only till there are at least 2 nodes left
        while(temp != null && temp.prox != null){
            //crio uma variável do tipo inteiro para armazenar o valor que será trocado
            int k = temp.valor;
            //
            temp.valor = temp.prox.valor;
            temp.prox.valor = k;
            temp = temp.prox.prox;
        }
    }
}
