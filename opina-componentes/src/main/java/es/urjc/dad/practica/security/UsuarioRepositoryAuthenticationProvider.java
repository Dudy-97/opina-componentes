package es.urjc.dad.practica.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import es.urjc.dad.practica.repository.UsuarioRepository;
import es.urjc.dad.practica.model.*;

@Component
public class UsuarioRepositoryAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		Usuario usuario = usuarioRepository.findByNombre(auth.getName()).get();
		
		if(usuario == null) {
			throw new BadCredentialsException("Usuario no encontrado");
		}
		
		String password = (String) auth.getCredentials();
		if(!new BCryptPasswordEncoder().matches(password, usuario.getPass())) {
			throw new BadCredentialsException("Contrasena incorrecta");
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		for(String role : usuario.getRoles()) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		
		return new UsernamePasswordAuthenticationToken(usuario.getNombre(), password, roles);
	}
	
	@Override
	public boolean supports(Class<?> authenticationObject) {
		return true;
	}
}













