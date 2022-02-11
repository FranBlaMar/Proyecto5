package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.PedidoService;

@SpringBootTest
class ProyectoSpring1ApplicationTests {
@Autowired
	private PedidoService servicio;
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	  void testFallo() {
		Pedido p = this.servicio.borrarPedido(2);
	    assertNotNull(p);
	 }
}
