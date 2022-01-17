package com.example.demo.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository repositorio;
	

	/**
	 * Metodo para obtener todos los productos almacenados en el servidor
	 * @return La lista de productos
	 */
	public List<Producto> findAll() {
		return repositorio.findAll();
	}
	
	/**
	 * Metodo para obtener un producto mediante su id
	 * @param Id del producto que deseamos obtener
	 * @return El producto deseado
	 */
	public Producto obtenerProductoPorId(long id){
		return repositorio.findById(id).orElse(null);
	}
	
	/**
	 * Metodo para recorrer la lista de productos y almacenar cada producto comprado junto a su cantidad en un hashmap
	 * @param Array con las cantidades de los productos comprados por el usuario 
	 * @return Un hasmap con los productos comprados como clavo y la cantidad de estos como valor
	 */
	public Map<Producto,Integer> obtenerHashMap(int[] cantidades){
		HashMap<Producto,Integer> resultado = new HashMap<>();
		//Recorro los productos del servidor y añado las cantidades de compra del usuario por orden
		for (int i = 0; i < repositorio.findAll().size(); i++) {
			if(cantidades[i] > 0) {
				resultado.put(repositorio.findAll().get(i), cantidades[i]);
			}
		}
		return resultado;
	}
	
	/**
	 * Metodo para calcular el precio total a pagar en un pedido
	 * @param HashMap con los productos y sus cantidades
	 * @return El precio total a pagar por todos los productos
	 */
	public double obtenerPrecioTotal(Map<Producto,Integer> productos) {
		double precioTotal = 0;
		//Recorro el hashmap de productos y cantidades, y voy sumando el total del precio de los productos por su cantidad
		for (Map.Entry<Producto, Integer> producto : productos.entrySet()) {
		    precioTotal += producto.getKey().getPrecio()*producto.getValue() ;
		}
		return precioTotal;
	}
	
	/**
	 * Metodo postConstruct para añadir algunos productos de forma estática para pruebas de desarrollo
	 */
	@PostConstruct
	public void init() {
		this.repositorio.saveAll( Arrays.asList (new Producto("Camiseta","camiseta.jpg", 6.99),new Producto("Sudadera","sudadera.jpg", 26.50),new Producto("Botines","botines.jpg", 36.25),new Producto("Gorro","gorro.jpg", 5.99), new Producto("Pendiente","pendiente.jpg", 2.50),new Producto("Pantalon","pantalon.jpg", 19.99) ));
	}
	
}