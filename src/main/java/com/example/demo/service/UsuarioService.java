package com.example.demo.service;

import java.util.Arrays;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repositorio;
	
	/**
	 * 
	 * @return Lista de los usuarios existentes en la web
	 */
	public List<Usuario> findAll() {
		return repositorio.findAll();
	}
	
	/**
	 * Metodo para comprobar si un usuario existe en nuestro servidor
	 * @param Usuario creado en el logni, que usaremos para comparar con ususarios existentes
	 * @return Devuelve el usuario que hayamos encontrado, en caso de no existir devuelve nulo
	 */
	public Usuario comprobarUser(Usuario us) {
		Usuario resultado = null;
		if (repositorio.findById(us.getUser().toUpperCase()).orElse(null).equals(us)) {
			resultado = repositorio.findById(us.getUser()).orElse(null);
		}
		return resultado;
	}
	/**
	 * Metodo para obtener un usuario mediante su nombre de usuario
	 * @param nombre de usuario de un Usuario del servidor
	 * @return Devuelve el usuario que está almacenado en el servidor
	 */
	public Usuario obtenerUsuario(String us) {
		return repositorio.findById(us).orElse(null);
	}
	
	/**
	 * Metodo postConstruct para añadir usuarios de forma estatica para realizar comprobaciones durante el desarrollo del proyecto
	 */
	@PostConstruct
	public void init() {
		repositorio.saveAll( Arrays.asList(new Usuario("J123", "123", "jorge@dominio.com","Jorgue", "911111111", "C/Rosales del campo Nº3"), new Usuario("FRAN", "BLANCO", "fran@dominio.com","Francisco", "922222222", "C/Puente romero Nº23"),new Usuario("F123", "111", "ff123@dominio.com","Maria", "933333333", "C/Perez de la luna Nº41")));
	}
	
}
