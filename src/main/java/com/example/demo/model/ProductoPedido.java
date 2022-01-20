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
	@JoinColumn(name="idProducto", insertable=false, updatable=false)
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name="idPedido", insertable=false, updatable=false)
	private Pedido pedido;
	
	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	
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


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
