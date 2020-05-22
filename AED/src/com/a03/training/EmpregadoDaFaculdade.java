package com.a03.training;

public class EmpregadoDaFaculdade {
    private String nome;
    private double salario;
    public double getGastos(){
        return this.getSalario();
    }
    public String getInfo(){
        return "nome: " + this.nome + " com salário " + this.getSalario();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
