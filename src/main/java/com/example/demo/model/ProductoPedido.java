package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LineaPedido")
public class ProductoPedido{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLinea;
	
	@ManyToOne
	private Producto producto;
	
	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	
	
	public ProductoPedido(Producto pr, int cant) {
		this.producto = pr;
		this.cantidad = cant;
	}
	
	public ProductoPedido() {
	}
	
	public Long getIdLinea() {
		return idLinea;
	}


	public void setIdLinea(Long idLinea) {
		this.idLinea = idLinea;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idLinea);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoPedido other = (ProductoPedido) obj;
		return Objects.equals(idLinea, other.idLinea);
	}
	
	
}
