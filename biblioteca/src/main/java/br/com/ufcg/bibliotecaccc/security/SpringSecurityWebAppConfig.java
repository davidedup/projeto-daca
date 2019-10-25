package br.com.ufcg.bibliotecaccc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@EnableWebSecurity
@Configuration  
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityWebAppConfig extends WebSecurityConfigurerAdapter {    
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// AuthenticationTokenFilter will ignore the below paths[
		web.ignoring().antMatchers(HttpMethod.POST, "/autor");
//		web.ignoring().antMatchers(HttpMethod.GET, "/autor");
		//web.ignoring().antMatchers(HttpMethod.POST, "/autenticacao");
//		web.ignoring().antMatchers(HttpMethod.GET, "/autor/nome-autor");
//		web.ignoring().antMatchers(HttpMethod.POST, "/artefato");
//		web.ignoring().antMatchers(HttpMethod.GET, "/artefato");
//		web.ignoring().antMatchers(HttpMethod.POST, "/colecao");
//		web.ignoring().antMatchers(HttpMethod.GET, "/colecao");
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		
		http.httpBasic();
	}
	
	@Autowired
	public void configuraGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password("{noop}samambaia").roles("ADMIN");
	}
	
}