package com.leo.dio.hashexample;

public class Congressista {
    private String nome;
    private long cpf;

    public Congressista(String nome, long cpf){
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public long getCpf(){
        return this.cpf;
    }

    @Override
    public boolean equals(Object o){
        if((o instanceof Congressista) && ((Congressista) o).getNome().equals(this.getNome())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return getNome().length() * 8;
    }
}
