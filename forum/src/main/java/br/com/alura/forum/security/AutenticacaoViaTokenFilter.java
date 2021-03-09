package br.com.alura.forum.security;

import br.com.alura.forum.model.Usuario;
import br.com.alura.forum.repository.UsuarioRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {
    private TokenService tokenService;
    private UsuarioRepository repository;

    //Como nao da pra injetar por Autowired por que é security-filter, recebe pelo construtor
    public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository repository){
        this.tokenService = tokenService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = pegarToken(httpServletRequest);
        Boolean valido = tokenService.isTokenValido(token);

        if(valido){
            autenticarUsuario(token);
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    private void autenticarUsuario(String token) {
        long id = tokenService.getIdUsuario(token);//No token tem o id do usuario
        Usuario usuario = repository.findById(id).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String pegarToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");

        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }

        return token.substring(7, token.length());
    }
}
