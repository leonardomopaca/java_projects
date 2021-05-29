package com.leo.leilao;

import com.leo.leilao.dominio.Lance;
import com.leo.leilao.dominio.Leilao;
import com.leo.leilao.dominio.Usuario;
import com.leo.leilao.servico.Avaliador;

public class TesteDoAvaliador {
    public static void main(String[] args) {
        Usuario joao = new Usuario("João");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");


        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(maria, 250.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        System.out.println(leiloeiro.getMaiorLance()); // imprime 400.0
        System.out.println(leiloeiro.getMenorLance()); // imprime 250.0
    }
}
