package com.teste.lista;

public class ListaCore {
    //referência para o próximo elemento
    //caso este seja nulo, significa que é o fim da lista
    private ListaCore prox;
    //referencia sobre o elemento que ela se refere
    private Object elemento;

    public ListaCore(ListaCore prox, Object elemento) {
        this.prox = prox;
        this.elemento = elemento;
    }
    
    public ListaCore getProx() {
        return prox;
    }

    public void setProx(ListaCore prox) {
        this.prox = prox;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    
}
