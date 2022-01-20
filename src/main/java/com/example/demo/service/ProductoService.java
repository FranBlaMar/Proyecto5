package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
}