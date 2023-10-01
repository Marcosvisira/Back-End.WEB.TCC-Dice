package br.com.dice.Records;

import br.com.dice.Entity.Endereco;
import br.com.dice.Entity.cadastroEmpresa;

public record dadosListagemEmpresa(Long ID, String nome, Endereco endereco) {

    public dadosListagemEmpresa(cadastroEmpresa cadastroEmpresa){
        this(cadastroEmpresa.getId(), cadastroEmpresa.getNome(),  cadastroEmpresa.getEndereco());
    }
}