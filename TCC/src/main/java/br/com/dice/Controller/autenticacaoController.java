package br.com.dice.Controller;

import br.com.dice.Infra.security.LoginResponseDTO;
import br.com.dice.Infra.security.TokenService;
import br.com.dice.Repository.UsuarioRepository;
import br.com.dice.Usuario.DadosAutenticacaoDTO;
import br.com.dice.Usuario.RegistrarDTO;
import br.com.dice.Usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class autenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid DadosAutenticacaoDTO dados){
           var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

           var authentication = this.authenticationManager.authenticate(authenticationToken);
           var token = tokenService.gerarToken((Usuario) authentication.getPrincipal());

           return ResponseEntity.ok(new LoginResponseDTO(token));
       }

    @PostMapping("/registrar")
    public ResponseEntity registrar(@RequestBody @Valid RegistrarDTO dados){
        if(this.repository.findByLogin(dados.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedSenha = new BCryptPasswordEncoder().encode(dados.senha());
        Usuario newUsuario = new Usuario(dados.login(), encryptedSenha, dados.role());

        this.repository.save(newUsuario);
        return ResponseEntity.ok().build();
    }


}
