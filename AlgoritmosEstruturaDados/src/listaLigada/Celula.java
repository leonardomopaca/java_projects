package listaLigada;

public class Celula {
    private Celula proxima;
    private Object elemento;
    
    //lista duplamente ligada (terei que modificar alguns metodos já 
    //implementados
    private Celula anterior;
    
    public Celula(Celula proxima, Object elemento){
        this.proxima = proxima;
        this.elemento = elemento;
    }
    
    public Celula(Object elemento){
        this.elemento = elemento;
    }
    
    //não implementei o construtor Celula() - sem argumentos
    
    public void setProxima(Celula proxima){
        this.proxima = proxima;
    }
    
    public Celula getProxima(){
        return proxima;
    }
    
    public void setAnterior(Celula anterior){
        this.anterior = anterior;
    }
    
    public Celula getAnterior(){
        return anterior;
    }    
    
    public Object getElemento(){
        return elemento;
    }
}
