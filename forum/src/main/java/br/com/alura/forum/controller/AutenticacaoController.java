package br.com.alura.forum.controller;

import br.com.alura.forum.dto.TokenDTO;
import br.com.alura.forum.form.LoginForm;
import br.com.alura.forum.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Profile(value = {"prod", "test"})//pode ser carregada em 2 profiles
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDTO> autendicar(@RequestBody @Valid LoginForm loginForm){
        UsernamePasswordAuthenticationToken dados = loginForm.converter();

        try{
            Authentication authentication = authenticationManager.authenticate(dados);
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
        }catch(AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
