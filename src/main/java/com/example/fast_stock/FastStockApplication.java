package com.example.fast_stock;

import java.util.Date;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.fast_stock.model.Categoria;
import com.example.fast_stock.model.Cliente;
import com.example.fast_stock.model.Fornecedor;
import com.example.fast_stock.model.ItemNotaFiscalEntrada;
import com.example.fast_stock.model.NotaFiscalEntrada;
import com.example.fast_stock.model.Produto;
import com.example.fast_stock.service.CategoriaService;
import com.example.fast_stock.service.ClienteService;
import com.example.fast_stock.service.FornecedorService;
import com.example.fast_stock.service.ItemNotaFiscalEntradaService;
import com.example.fast_stock.service.NotaFiscalEntradaService;
import com.example.fast_stock.service.ProdutoService;

@SpringBootApplication
public class FastStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastStockApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoriaService categoriaService, ClienteService clienteService,
			ProdutoService produtoService, ItemNotaFiscalEntradaService itemEntradaService,
			FornecedorService fornecedorService, NotaFiscalEntradaService notaEntradaService) {
		return (args) -> {

			try {

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

				Cliente cliente = new Cliente();

				cliente.setCpfOuCnpj("08158930514");
				cliente.setEndereco("Rua casa massa");
				cliente.setNome("Junim");
				clienteService.salvar(cliente);
				clienteService.listarTodos().forEach((e) -> {
					System.out.println("nome: " + e.getNome() + "\nCpf/Cnpj: " +
							e.getCpfOuCnpj());
				});

				NotaFiscalEntrada notaEntrada = new NotaFiscalEntrada();

				Date date = new Date();
				notaEntrada.setData(date);

				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setCnpj("1123123123");
				fornecedor.setEndereco("Casinha Seu joao");
				fornecedor.setNome("Casa da Limpeza");
				fornecedor.setTelefone("779999999");
				fornecedor.setNotasFiscais(null);
				fornecedorService.salvar(fornecedor);

				notaEntrada.setFornecedor(fornecedorService.buscarPorId(fornecedor.getId()));
				notaEntrada.setNumero("1581818181");
				notaEntradaService.salvar(notaEntrada);
				ItemNotaFiscalEntrada itemEntrada = new ItemNotaFiscalEntrada();

				itemEntrada.setPrecoUnitario((long) 12);
				itemEntrada.setProduto(p);
				itemEntrada.setQuantidade(13);
				itemEntrada.setNotaFiscalEntrada(notaEntrada);

				itemEntradaService.salvar(itemEntrada);

			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}


		};
	}

}
