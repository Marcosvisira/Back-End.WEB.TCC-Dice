package br.com.dice.Entity;

import br.com.dice.Records.dadosCadastroEmpresa;
import br.com.dice.Records.dadosEndereco;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;



@Table(name = "dadosempresa")
@Entity(name = "Empresa")
@Getter
@EqualsAndHashCode(of = "id")
public class cadastroEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    @Embedded
    private Endereco endereco;
    @Enumerated(EnumType.STRING)
    private statusCadastro status;


    public enum statusCadastro {
        PENDENTE,
        APROVADO,
        REJEITADO
    }
    @Enumerated(EnumType.STRING)
    public statusCadastro getStatus() {
        return status;
    }

    public void setStatus(statusCadastro status) {
        this.status = status;
    }


    public cadastroEmpresa(){}

    public cadastroEmpresa(dadosCadastroEmpresa dados) {
        this.nome = dados.getNome();
        this.cnpj = dados.getCnpj();
        this.endereco = dados.getEndereco();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public void atualizarInformacoes(dadosCadastroEmpresa dados) {
        this.setNome(dados.getNome());
        this.setCnpj(dados.getCnpj());
        this.endereco.setLogradouro(dados.getEndereco().getLogradouro());
        this.endereco.setCidade(dados.getEndereco().getCidade());
        this.endereco.setUf(dados.getEndereco().getUf());
        this.endereco.setCep(dados.getEndereco().getCep());
        this.endereco.setBairro(dados.getEndereco().getBairro());
        this.endereco.setNumero(dados.getEndereco().getNumero());
        this.endereco.setComplemento(dados.getEndereco().getComplemento());











    }

    }
