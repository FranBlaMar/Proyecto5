package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProductoPedido;
import com.example.demo.repository.ProductoPedidoRepository;

@Service
public class LineaPedidoService {
	@Autowired
	private ProductoPedidoRepository repositorio;
	
	/**
	 * Metodo para almacenar linea de producto en la base de datos
	 * @param p linea de producto
	 * @return la linea de producto creada
	 */
	public ProductoPedido add(ProductoPedido p) {
		return repositorio.save(p);
	}
}
