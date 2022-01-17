package com.example.demo.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "Pedido")
public class Pedido {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long referencia;
	
	@ManyToOne
	@JoinColumn(name="UsuarioPedido", insertable = false, updatable = false)
	private Usuario usuarioPedido;
	
	@OneToMany(mappedBy= "pedido", cascade= CascadeType.ALL)
	private List<ProductoPedido> productos = new ArrayList<>();
	
	private LocalDate fechaPedido;
	private String direccion;
	private String telefono;
	private String email;
	private String tipoEnvio;
	private double precioTotal;
	
	/**
	 * Constructor de la clase Pedido
	 * @param Usuario del pedido
	 * @param Direccion del pedido
	 * @param Telefono del usuario del pedido
	 * @param Email del usuario del pedido
	 */
	public Pedido(Usuario usuarioPedido, String direccion, String telefono, String email) {
		super();
		this.usuarioPedido = usuarioPedido;
		this.fechaPedido = LocalDate.now();
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	
	
	public long getReferencia() {
		return referencia;
	}


	public List<ProductoPedido> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductoPedido> lista) {
		this.productos = lista;
	}
	
	@Column(name = "usuarioPedido", nullable = false)
	public Usuario getUsuarioPedido() {
		return usuarioPedido;
	}

	public void setUsuarioPedido(Usuario usuarioPedido) {
		this.usuarioPedido = usuarioPedido;
	}
	
	
	@Column(name = "telefono", nullable = false)
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Column(name = "fechaPedido", nullable = false)
	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	
	@Column(name = "direccion", nullable = false)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "tipoEnvio", nullable = false)
	public String getTipoEnvio() {
		return tipoEnvio;
	}

	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

	@Column(name = "precioTotal", nullable = false)
	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(referencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return referencia == other.referencia;
	}

	@Override
	public String toString() {
		return "Pedido con referencia " + referencia + ", usuarioPedido: " + usuarioPedido + ", listaProductos: "
				+ productos + ", fechaPedido: " + fechaPedido + "\n";
	}
	
}
