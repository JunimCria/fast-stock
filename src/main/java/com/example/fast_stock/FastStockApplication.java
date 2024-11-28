package com.example.fast_stock;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.fast_stock.model.Categoria;
import com.example.fast_stock.model.Cliente;
import com.example.fast_stock.model.Produto;
import com.example.fast_stock.service.CategoriaService;
import com.example.fast_stock.service.ClienteService;
import com.example.fast_stock.service.ProdutoService;

@SpringBootApplication
public class FastStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastStockApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoriaService categoriaService, ClienteService clienteService,
			ProdutoService produtoService) {
		return (args) -> {

			try {

				// teste categoria
				Categoria c = new Categoria();
				c.setNome("Limpeza");
				categoriaService.salvar(c);

				categoriaService.listarTodos().forEach((e) -> {
					System.out.println(e.getNome() + " " + e.getId());
				});

				Produto p = new Produto();

				p.setCodigo("112546884184");
				p.setDescricao("Detergente YPE o melhor da região");
				p.setNome("Detergente");
				p.setPreco((long) 4);
				p.setQuantidadeEstoque(10);
				p.setCategoria(c);

				Produto p2 = new Produto();

				p2.setCodigo("1126665884184");
				p2.setDescricao("Dsinfetante YPE o melhor da região");
				p2.setNome("Desinfetante");
				p2.setPreco((long) 10);
				p2.setQuantidadeEstoque(20);
				p2.setCategoria(c);

				produtoService.salvar(p);

				produtoService.salvar(p2);

				produtoService.buscarPorCategoria(c).forEach((e) -> {
					System.out.println(e.getNome());
				});

				// Cliente cliente = new Cliente();

				// cliente.setCpfOuCnpj("08158930514");
				// cliente.setEndereco("Rua casa massa");
				// cliente.setNome("Junim");
				// clienteService.salvar(cliente);
				// clienteService.listarTodos().forEach((e) -> {
				// System.out.println("nome: " + e.getNome() + "\nCpf/Cnpj: " +
				// e.getCpfOuCnpj());
				// });

			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}

			System.out.println("Hello World");

			categoriaService.listarTodos().forEach((e) -> {
				System.out.println(e.getNome() + " " + e.getId());
			});

		};
	}

}
