package br.com.dice.Entity;

import br.com.dice.Records.dadosCadastroEmpresa;
import br.com.dice.Records.dadosEndereco;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Table(name = "dadosempresa")
@Entity(name = "Empresa")
@Getter
@EqualsAndHashCode(of = "id")
public class cadastroEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nomeFantasia;
    private String cnpj;
    @Embedded
    private Endereco endereco;

    @ManyToMany(mappedBy = "dadosempresa")
    @JsonManagedReference
    private List<dadosCadastroEmpresa> empresas;


    public cadastroEmpresa(dadosCadastroEmpresa dados) {
        this.nome = dados.nome();
        this.nomeFantasia = dados.nomeFantasia();
        this.cnpj = dados.cnpj();
        this.endereco = new Endereco(dados.endereco());
        this.nomeFantasia = dados.nomeFantasia();

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


    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void atualizarInformacoes(dadosEndereco dados) {
        if (dados.logradouro() != null) {
            this.endereco.setLogradouro(dados.logradouro());
        }
        if (dados.cidade() != null) {
            this.endereco.setCidade(dados.cidade());
        }
        if (dados.uf() != null) {
            this.endereco.setUf(dados.cidade());
        }
        if (dados.cep() != null) {
            this.endereco.setCep(dados.cidade());
        }
        if (dados.bairro() != null) {
            this.endereco.setBairro(dados.bairro());
        }
        if (dados.numero() != null) {
            this.endereco.setNumero(dados.numero());
        }
        if (dados.complemento() != null) {
            this.endereco.setComplemento(dados.complemento());
        }

    }}
