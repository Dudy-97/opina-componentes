package es.urjc.dad.practica.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public UsuarioRepositoryAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// Public pages
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/graficas").permitAll();
		http.authorizeRequests().antMatchers("/graficas/*").permitAll();
		http.authorizeRequests().antMatchers("/procesadores").permitAll();
		http.authorizeRequests().antMatchers("/procesadores/*").permitAll();
		http.authorizeRequests().antMatchers("/placas").permitAll();
		http.authorizeRequests().antMatchers("/placas/*").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/registro").permitAll();
		http.authorizeRequests().antMatchers("/loginerror").permitAll();
		http.authorizeRequests().antMatchers("/cerrar_sesion").permitAll();
		
		// USER pages
		http.authorizeRequests().antMatchers("/procesadores/nuevo").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/graficas/nueva").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/placas/nueva").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/ver_usuarios").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/ver_usuarios/*").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/*/*/nueva_valoracion").hasAnyRole("USER");
		
		// ADMIN pages
		http.authorizeRequests().antMatchers("/*/eliminar").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/ver_usuarios/*/eliminar").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/valoracion/*/eliminar").hasAnyRole("ADMIN");
		
		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("nombre");
		http.formLogin().passwordParameter("pass");
		http.formLogin().defaultSuccessUrl("/");
		http.formLogin().failureUrl("/loginerror");
		
		// Logout
		http.logout().logoutUrl("/cerrar_sesion");
		http.logout().logoutSuccessUrl("/");
		
		// CSRF
		http.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Database authentication provider
		auth.authenticationProvider(authenticationProvider);
	}
}



















