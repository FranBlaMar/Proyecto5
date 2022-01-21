package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;
import com.example.demo.model.ProductoPedido;
import com.example.demo.model.Usuario;
import com.example.demo.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repositorio;

	/**
	 * 
	 * @return La lista con todos los pedidods almacenados en el servidor
	 */
	public List<Pedido> findAll() {
		return repositorio.findAll();
	}
	
	/**
	 * Metodo para almacenar pedido en la base de datos
	 * @param pedido
	 * @return Pedido
	 */
	public Pedido add(Pedido pedido) {
		return repositorio.save(pedido);
	}
	
	/**
	 * Metodo para añadir los datos del usuario a un pedido
	 * @param pedido 
	 * @return
	 */
	public Pedido anadirDatosUserPedido(Pedido pedido, Usuario user, int precio) {
		pedido.setDireccion(user.getDireccion());
		pedido.setEmail(user.getEmail());
		pedido.setPrecioTotal(precio);
		pedido.setTelefono(user.getTelefono());
		pedido.setUsuarioPedido(user);
		return pedido;
	}

	/**
	 * Metodo para añadir la linea de pedido a un pedido
	 * @param pedido
	 * @param productoPedido
	 * @param pro
	 * @param cant
	 */
	public void anadirLineaPedido(Pedido pedido,ProductoPedido productoPedido, Producto pro, int cant) {
		productoPedido.setCantidad(cant);
		productoPedido.setProducto(pro);
		pedido.setProductos(productoPedido);
	}


	/**
	 * Metodo para añadir nueva direccion y tipo de envio a un pedido
	 * @param envio
	 * @param direccion
	 * @param pedido
	 */
	public void anadirTipoEnvioyDireccion(String envio, String direccion,long pedido) {
		Pedido p = obtenerPedidoPorReferencia(pedido);
		p.setTipoEnvio(envio);
		p.setDireccion(direccion);
		add(p);	
	}
	
	/**
	 * Metodo para modificar un pedido y modificarlo en la lista de pedidos
	 * @param Usuario al que pertenece el pedido editado
	 * @param Precio total editado o el antiguo
	 * @param HashMap de productos comprados editado o el antiguo
	 * @param String del tipo de envio editado o el antiguo
	 * @param int con el numero de referencia del pedido a editar
	 * @param String con la direccion editado o el antiguo
	 * @param String con el telefono editado o el antiguo
	 * @param String con el email editado o el antiguo
	 * @return Devuelve el Pedido editado
	 */
	public Pedido editarPedido(Usuario us,double precioTotal, String tipoEnvio, int refe, String direccion, String telefono, String email) {
		Pedido resultado = null;
		for(Pedido p: repositorio.findAll()) {
			//Obtengo el pedido con la referencia que le indico
			if(p.getReferencia() == refe) {
				//Le modifico todos los datos antiguos por los nuevos
				/*p.anadirProductos(cantidadesProductos);*/
				p.setUsuarioPedido(us);
				p.setDireccion(direccion);
				p.setTelefono(telefono);
				p.setEmail(email);
				p.setPrecioTotal(precioTotal);
				p.setTipoEnvio(tipoEnvio);
				resultado = p;
			}
		}
		return resultado;
	}
	
	/**
	 * Metodo para borrar pedidos de la base de datos
	 * @param refe
	 */
	 
	public void borrarPedido(long refe) {
		this.repositorio.deleteById(refe);
	}
	
	/**
	 * Metodo para obtener un pedido de la lista de pedidos mediante un numero de referencia
	 * @param long con el numero de referencia del pedido que deseamos obtener
	 * @return Pedido que estamos buscando
	 */
	public Pedido obtenerPedidoPorReferencia(long referencia){
		return repositorio.findById(referencia).orElse(null);
	}
	
	/**
	 * Metodo para obtener todos los pedidos que pertenecen a un usuario
	 * @param us id usuario
	 * @return todos los pedidos de un usuario
	 */
	public List<Pedido> findPedidoUser(String us){
		return repositorio.findPedidoUser(us);
	}

}