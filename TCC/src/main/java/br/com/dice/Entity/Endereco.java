package br.com.dice.Entity;

import br.com.dice.Records.dadosEndereco;

public class Endereco {

    private String logradouro;
    private String cidade;
    private String uf;
    private String cep;
    private String bairro;
    private String numero;
    private String complemento;

    public Endereco() {
    }
    public Endereco(dadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.cep = endereco.cep();
        this.bairro = endereco.bairro();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
    }


    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;

    }



}

