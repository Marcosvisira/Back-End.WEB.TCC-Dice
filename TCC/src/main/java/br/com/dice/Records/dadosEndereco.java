package br.com.dice.Records;

public record dadosEndereco(Long ID,
                            String logradouro,

                            String cidade,

                            String uf,


                            String cep,

                            String bairro,

                            String numero,

                            String complemento ) {

}