package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Usuario")
public class Usuario {
	
	private long id;
	private String user;
	private String contrasena;
	private String email;
	private String nombre;
	private String telefono;
	private String direccion;
	
	public Usuario() {}
	
	/**
	 * Constructor de la clase usuario
	 * @param nombre de usuario
	 * @param contrasena del usuario
	 * @param email del usuario
	 * @param nombre del usuario
	 * @param telefono del usuario
	 * @param direccion del usuario
	 */
	public Usuario( String user,String contrasena, String email, String nombre, String telefono, String direccion) {
		this.user = user;
		this.contrasena = contrasena;
		this.email = email;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	
	/**
	 * Constructor de la clase usuario con solo username y contraseña
	 * @param nombre de ususario
	 * @param contrasena del usuario
	 */
	public Usuario(String user, String contrasena) {
		this.user=user;
		this.contrasena = contrasena;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "user", nullable = false)
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "contrasena", nullable = false)
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "telefono", nullable = false)
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "direccion", nullable = false)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(contrasena, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(contrasena, other.contrasena) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Nombre de usuario: " + user + ", email: " + email + ", nombre: " + nombre + ", telefono: "
				+ telefono + ", direccion postal: " + direccion;
	} 

}
