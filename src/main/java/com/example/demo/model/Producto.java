package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nombre;
	
	private String imagen;
	
	private double precio;
	
	
	public Producto() {	
	}
	/**
	 * Constructor de la clase productos
	 * @param nombre del producto
	 * @param ruta de la imagen del producto
	 * @param precio del producto
	 */
	public Producto(String nombre, String imagen, double precio) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.precio = precio;
	}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "imagen", nullable = false)
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	@Column(name = "precio", nullable = false)
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
