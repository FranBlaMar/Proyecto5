package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Pedido;
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
	 * @param p pedido a añadir
	 * @return Pedido
	 */
	public Pedido add(Pedido p) {
		return repositorio.save(p);
	}
	/**
	 * Metodo para crear y añadir un pedido a la lista de pedidos
	 * @param Usuario al que pertenece el pedido
	 * @param Double del precio total del pedido
	 * @param HashMap con los productos y las cantidades comprados
	 * @return El Pedido ya añadido 
	 */
	public Pedido crearYAnadirPedido(Usuario us,double precioTotal) {
		Pedido p = new Pedido(us,us.getDireccion(),us.getTelefono(), us.getEmail());
		p.setPrecioTotal(precioTotal);
		/*p.anadirProductos(cantidadesProductos);*/
		repositorio.save(p);
		return p;
	}
	
	
	/**
	 * Metodo para añadirle a un pedido el tipo de envio y la direccion cambiada
	 * @param String con el tipo de envio
	 * @param String con la direccion nueva si la ha cambiado, o la alamacenada en el usuario si no la ha modificado
	 * @param Int con la referencia del pedido
	 */
	public void anadirTipoEnvioyDireccion(String envio, String direccion,int pedido) {
		obtenerPedidoPorReferencia(pedido).setTipoEnvio(envio);
		obtenerPedidoPorReferencia(pedido).setDireccion(direccion);
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
	 * Metodo para borrar un pedido de la lista de pedidos
	 * @param Pedido que deseamos borrar
	 */
	 
	public void borrarPedido(Pedido p) {
		this.repositorio.delete(p);
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