package es.urjc.dad.practica;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;


@Controller
public class DataBaseUsage /*implements CommandLineRunner*/ {
	
	
/*	@Autowired 
	private ProductoRepository repository;
	
	@Override
	public void run (String... args) throws Exception{
		
		repository.save(new Producto("Nvidia 1070 GTX", "Placa base de la marca Nvidia", 20));
		repository.save(new Producto("Nvidia 1080 GTX", "Placa 1", 40));
		repository.save(new Producto("Nvidia 1090 GTX", "Placa base de la marca Nvidia", 50));
		repository.save(new Producto("Nvidia 2070 GTX", "Placa base de la marca Nvidia", 130));
		repository.save(new Producto("Nvidia 2080 GTX", "Placa base de la marca Nvidia", 230));
		repository.save(new Producto("Nvidia 2090 GTX", "Placa base de la marca Nvidia", 290));
		repository.save(new Producto("Nvidia 3070 GTX", "Placa base de la marca Nvidia", 400));*/
		
		
		//Buscar todos los productos
		/*List<Producto> productos = repository.findAll();
		System.out.println("Todos los productos");
		System.out.println("-------------------");
		for (Producto producto : productos) {
			System.out.println(productos);
		}
		System.out.println();*/
		
		/*
		 * //Buscar un producto por la ID Producto producto =
		 * repository.findById(1L).get(); System.out.println("Producto con esa ID");
		 * System.out.println("-------------------"); System.out.println(producto);
		 * System.out.println();
		 */
		
		/*
		 * //Buscar un producto por el nombre List<Producto> grafica =
		 * repository.findByLastName("Placa 1"); System.out.println("La grafica es: ");
		 * System.out.println("-------------------"); for (Producto productos : grafica
		 * ) { System.out.println(productos); }
		 */
		
		
		
}

