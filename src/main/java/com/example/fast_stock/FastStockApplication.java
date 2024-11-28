package com.example.fast_stock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.fast_stock.model.Categoria;
import com.example.fast_stock.model.Cliente;
import com.example.fast_stock.service.CategoriaService;
import com.example.fast_stock.service.ClienteService;

@SpringBootApplication
public class FastStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastStockApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoriaService categoriaService, ClienteService clienteService) {
		return (args) -> {

			try {

				// teste categoria
				// Categoria c = new Categoria();
				// c.setNome("doidera4");
				// categoriaService.salvar(c);
				// c.setNome("paia");
				// categoriaService.atualizar(c);
				// categoriaService.listarTodos().forEach((e) -> {
				// System.out.println(e.getNome() + " " + e.getId());
				// });

				// Cliente cliente = new Cliente();

				// cliente.setCpfOuCnpj("08158930514");
				// cliente.setEndereco("Rua casa da porra");
				// cliente.setNome("Junim");
				// clienteService.salvar(cliente);
				// clienteService.listarTodos().forEach((e) -> {
				// System.out.println("nome: " + e.getNome() + "\nCpf/Cnpj: " +
				// e.getCpfOuCnpj());
				// });

			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
			// Categoria c2 = new Categoria();

			// c2.setNome("doidera2");
			// categoriaService.salvar(c2);

			System.out.println("Hello World");

			categoriaService.listarTodos().forEach((e) -> {
				System.out.println(e.getNome() + " " + e.getId());
			});

		};
	}

}
