package br.com.ufcg.bibliotecaccc.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration  
public class SpringSecurityWebAppConfig extends WebSecurityConfigurerAdapter {    
	@Override
	public void configure(WebSecurity web) throws Exception {
		// AuthenticationTokenFilter will ignore the below paths[
		web.ignoring().antMatchers(HttpMethod.POST, "/autor");
		web.ignoring().antMatchers(HttpMethod.GET, "/autor");
		web.ignoring().antMatchers(HttpMethod.POST, "/autor/autenticar");
		web.ignoring().antMatchers(HttpMethod.GET, "/autor/nome-autor");
		web.ignoring().antMatchers(HttpMethod.POST, "/artefato");
		web.ignoring().antMatchers(HttpMethod.GET, "/artefato");
		web.ignoring().antMatchers(HttpMethod.POST, "/colecao");
		web.ignoring().antMatchers(HttpMethod.GET, "/colecao");
		
		
	}
}