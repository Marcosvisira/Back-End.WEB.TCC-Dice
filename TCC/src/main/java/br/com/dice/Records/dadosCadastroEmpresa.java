package br.com.dice.Records;

import jakarta.validation.Valid;


public record dadosCadastroEmpresa (String nome,

                                    String nomeFantasia,


                                    String cnpj,

                                    @Valid
                                    dadosEndereco endereco){

}
