package br.com.dice.Records;

import br.com.dice.Entity.Endereco;
import jakarta.persistence.*;


public class dadosCadastroEmpresa {


    private Long id;
    private String nome;
    private String nomeFantasia;
    private String cnpj;
    @Embedded
    private Endereco endereco;
    public dadosCadastroEmpresa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Long ID() {
        return ID();
    }
}
