package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.ProductoPedido;
import com.example.demo.repository.ProductoPedidoRepository;

public class LineaPedidoService {
	@Autowired
	private ProductoPedidoRepository repositorio;
	
	/**
	 * Metodo para almacenar line de producto en la base de datos
	 * @param p linea de producto
	 * @return la linea de producto creada
	 */
	public ProductoPedido add(ProductoPedido p) {
		return repositorio.save(p);
	}
}
