package listaLigada;

public class ListaLigada {
    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;
    
    /* Se não tivéssemos guardado a referência para a última célula, teríamos
    que percorrer célula por célula até o fim da Lista para alterar a referência
    próxima da última célula
    Caso especial da lista vazia, tanto faz adicionar no começo ou fim.
    */
    public void adiciona(Object elemento){
        if(this.totalDeElementos == 0){
            this.adicionaNoComeco(elemento);
        }else{
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            this.ultima = nova;
            this.totalDeElementos++;
        }
        
    }
    
    public void adiciona(int posicao, Object elemento){
        if(posicao == 0){
            this.adicionaNoComeco(elemento); 
        }else if(posicao == totalDeElementos){
            this.adiciona(elemento);
        }else{
            Celula anterior = this.pegaCelula(posicao-1);
            Celula nova = new Celula(anterior.getProxima(), elemento);
            anterior.setProxima(nova);
            this.totalDeElementos++;
        }
    }

    public void adicionaNoComeco(Object elemento){
        Celula nova = new Celula(this.primeira, elemento);  
        this.primeira = nova;
        //verifica se o total de elementos = 0 (vazio)
        if(totalDeElementos == 0){
            //caso especial lista vazia
            this.ultima = this.primeira;
        }
        this.totalDeElementos++;
    }
    
    public Object pega(int posicao){
        return this.pegaCelula(posicao).getElemento();
    }
    
    public void remove(int posicao){
    
    }
    
    public int tamanho(){
        return 0;
    }
    
    public boolean contem(Object o){
        return false;
    }
    

    
    public void removeDoComeco(){
        if(!this.posicaoOcupada(0)){
            throw new IllegalArgumentException("Posição não existe");
        }
        
        this.primeira = this.primeira.getProxima();
        this.totalDeElementos--;
        
        if(this.totalDeElementos==0){
            this.ultima = null;
        }
    }
    
    public void removeDoFim(){
        if(!this.posicaoOcupada(totalDeElementos-1)){
            throw new IllegalArgumentException("Posição não existe");
        }
        if(this.totalDeElementos == 1){
            this.removeDoComeco();
        }else{
            Celula penultima = this.ultima.getAnterior();
            penultima.setProxima(null);
            this.ultima = penultima;
            this.totalDeElementos--;
        }
    }
    
    public String toString(){
        //Verificando se a lista está vazia
        if(totalDeElementos == 0){
            return "[]";
        }
        
        StringBuilder builder = new StringBuilder("[");
        Celula atual = primeira;
        
        //percorrendo até o ultimo elemento
        for(int i =0; i < totalDeElementos-1; i++){
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProxima();
        }
        //ultimo elemento
        builder.append(atual.getElemento());
        builder.append("]");
        
        return builder.toString();
    }
    
    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.totalDeElementos;
    }
    
    private Celula pegaCelula(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição não existe");
        }
        
        Celula atual = primeira;
        for(int i = 0; i<posicao; i++){
            atual = atual.getProxima();
        }
        return atual;
    }
    
}
