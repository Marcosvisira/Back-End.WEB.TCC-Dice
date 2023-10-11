package br.com.dice.Controller;

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
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("empresa")
public class cadastroController {

    @Autowired
    private empresaRepository repository;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid dadosCadastroEmpresa dados, UriComponentsBuilder uriBuilder){
        System.out.println(dados);

        var empresa = new cadastroEmpresa(dados);
        empresa.setStatus(cadastroEmpresa.statusCadastro.PENDENTE);
        repository.save(empresa);

        var uri = uriBuilder.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body("Aguarde aprovação de cadastro");
    }

    @PutMapping("/{id}/aprovar")
    @Transactional
    public ResponseEntity<String> aprovarCadastro(@PathVariable Long id) {
        Optional<cadastroEmpresa> empresaOptional = repository.findById(id);

        if (empresaOptional.isPresent()) {
            cadastroEmpresa empresa = empresaOptional.get();
            empresa.setStatus(cadastroEmpresa.statusCadastro.APROVADO); // Define o status como "aprovado"
            repository.save(empresa);
            return ResponseEntity.ok("Cadastro aprovado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/rejeitar")
    @Transactional
    public ResponseEntity<String> rejeitarCadastro(@PathVariable Long id) {
        cadastroEmpresa empresa = repository.findById(id).orElse(null);
        if (empresa == null) {
            return ResponseEntity.notFound().build();
        }

        empresa.setStatus(cadastroEmpresa.statusCadastro.REJEITADO);
        repository.save(empresa);

        return ResponseEntity.ok("Cadastro rejeitado com sucesso");
    }


    @GetMapping("/listar")
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

    @PutMapping("/atualizar")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid dadosCadastroEmpresa dados) {
        cadastroEmpresa empresa = repository.findById(dados.getId()).orElse(new cadastroEmpresa());
        if (empresa.getId() == null ){
            return ResponseEntity.notFound().build();
        }
        empresa.atualizarInformacoes(dados);
        repository.save(empresa);
        return ResponseEntity.ok(dados);
    }

    @DeleteMapping("/delete/{ID}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long ID){
        repository.deleteById(ID);

        return ResponseEntity.noContent().build();
    }
}
