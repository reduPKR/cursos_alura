package br.com.alura.forum.security;

import br.com.alura.forum.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    @Value("${forum.jwt.expiration}")//pega o tempo de expiração em application.propriets
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        Date hoje = new Date();//Da menos problema que o localDateTime
        Date expira = new Date(hoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("API forum curso alura")
                .setSubject(usuario.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(expira)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    public Boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;//se nao deu nenhum erro
        } catch (Exception e) {
            return false;
        }
    }

    public long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
