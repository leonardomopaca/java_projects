package br.com.leo.pessoaservice.model;

import javax.persistence.*;

@Table(name="tb_pessoa")
@Entity
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pessoa")
    private Integer codigo;

    @Column(name="ds_nome")
    private String nome;

    @Column(name="fl_ativo", columnDefinition = "BIT")
    private boolean ativo;

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getCodigo(){
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAtivo() {
        return ativo;
    }
}
