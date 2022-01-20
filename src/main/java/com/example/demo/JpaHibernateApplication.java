package com.example.demo;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;

@SpringBootApplication
public class JpaHibernateApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner initData(UsuarioRepository repositorioUs,PedidoRepository repositorioPe, UsuarioService servicio, ProductoRepository repositorioPro) {
		return args -> {
			repositorioUs.saveAll( Arrays.asList(new Usuario("J123", "123", "jorge@dominio.com","Jorgue", "911111111", "C/Rosales del campo Nº3"), new Usuario("FRAN", "BLANCO", "fran@dominio.com","Francisco", "922222222", "C/Puente romero Nº23"),new Usuario("F123", "111", "ff123@dominio.com","Maria", "933333333", "C/Perez de la luna Nº41")));
			repositorioPro.saveAll(Arrays.asList (new Producto("Camiseta","camiseta.jpg", 6.99),new Producto("Sudadera","sudadera.jpg", 26.50),new Producto("Botines","botines.jpg", 36.25),new Producto("Gorro","gorro.jpg", 5.99), new Producto("Pendiente","pendiente.jpg", 2.50),new Producto("Pantalon","pantalon.jpg", 19.99)));
		
			
			Usuario usuario1 = servicio.obtenerUsuario("F123");
			Pedido pedido1 = new Pedido(usuario1,usuario1.getDireccion(), usuario1.getTelefono(), usuario1.getEmail());
			pedido1.setTipoEnvio("ESTANDAR");
			pedido1.setPrecioTotal(76.19);
			
			/*pedido1.anadirProductos(productos1);*/
			
			Pedido pedido2 = new Pedido(usuario1, usuario1.getDireccion(), usuario1.getTelefono(), usuario1.getEmail());
			pedido2.setTipoEnvio("EXPRESS");
			LocalDate fecha = LocalDate.parse("2021-11-30");
			pedido2.setFechaPedido(fecha);
			pedido2.setPrecioTotal(75.49);
			/*pedido2.anadirProductos(productos2);*/
			
			Usuario user2 = servicio.obtenerUsuario("J123");
			Pedido pedido3 = new Pedido(user2,user2.getDireccion(), user2.getTelefono(), user2.getEmail());
			pedido3.setTipoEnvio("ESTANDAR");
			pedido3.setPrecioTotal(209.68);
			/*pedido3.anadirProductos(productos3);*/
			
			repositorioPe.saveAll(Arrays.asList(pedido1,pedido2,pedido3));
		
		};
	}
}
