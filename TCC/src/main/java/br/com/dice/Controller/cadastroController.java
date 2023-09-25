package br.com.dice.Controller;

import br.com.dice.Records.dadosEndereco;
import br.com.dice.Records.dadosListagemEmpresa;
import br.com.dice.Entity.cadastroEmpresa;
import br.com.dice.Records.dadosCadastroEmpresa;
import br.com.dice.Repository.empresaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("empresa")
public class cadastroController {

    @Autowired
    private empresaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid dadosCadastroEmpresa dados, UriComponentsBuilder uriBuilder){
        System.out.println(dados);

        var empresa = new cadastroEmpresa(dados);
        repository.save(empresa);

        var uri = uriBuilder.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body("Empresa Cadastrada!");
    }

    @GetMapping
    public ResponseEntity<List<dadosCadastroEmpresa>> listar(){
        ModelMapper map = new ModelMapper();
        List<cadastroEmpresa> page = new ArrayList<cadastroEmpresa>();
        page = repository.findAll();
        List<dadosCadastroEmpresa> dados = new ArrayList<dadosCadastroEmpresa>();
        for(cadastroEmpresa cadastro : page){
            dadosCadastroEmpresa d = new dadosCadastroEmpresa();
            d = map.map(cadastro, dadosCadastroEmpresa.class);
            dados.add(d);
        }
        return ResponseEntity.ok(dados);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid dadosEndereco dados) {
        var endereco = repository.getReferenceById(dados.ID());
        endereco.atualizarInformacoes(dados);
        return ResponseEntity.ok(dados);
    }
    @DeleteMapping("/{ID}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long ID){
        repository.deleteById(ID);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{ID}")
    public ResponseEntity detalhar(@PathVariable Long ID){
        var empresa =  repository.getReferenceById(ID);

        return ResponseEntity.ok(new dadosListagemEmpresa(empresa));
    }

}
