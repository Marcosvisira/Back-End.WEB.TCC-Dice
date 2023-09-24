package br.com.dice.Controller;

import br.com.dice.Records.dadosEndereco;
import br.com.dice.Records.dadosListagemEmpresa;
import br.com.dice.Entity.cadastroEmpresa;
import br.com.dice.Records.dadosCadastroEmpresa;
import br.com.dice.Repository.empresaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cadastro")
public class cadastroController {

    @Autowired
    private empresaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid dadosCadastroEmpresa dados, UriComponentsBuilder uriBuilder){
        System.out.println(dados);

        var empresa = new cadastroEmpresa(dados);
        repository.save(empresa);

        var uri = uriBuilder.path("/cadastro/{ìd}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body("Empresa Cadastrada!");
    }

    @GetMapping
    public ResponseEntity<Page<dadosListagemEmpresa>> listar(Pageable paginacao){
        var page =  repository.findAll(paginacao).map(dadosListagemEmpresa::new);
        return ResponseEntity.ok(page);
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
