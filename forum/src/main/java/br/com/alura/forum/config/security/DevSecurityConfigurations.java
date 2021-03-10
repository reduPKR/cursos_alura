package br.com.alura.forum.config.security;

import br.com.alura.forum.repository.UsuarioRepository;
import br.com.alura.forum.security.AutenticacaoViaTokenFilter;
import br.com.alura.forum.security.AutenticaoService;
import br.com.alura.forum.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@Profile("dev")//Quando esta em ambiente de desenvolvimento fica ruim ter que autenticar para todos os testes
public class DevSecurityConfigurations extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().antMatchers("/topicos").permitAll();->libera tudo
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/**").permitAll()
                .and().csrf().disable();
    }
}
