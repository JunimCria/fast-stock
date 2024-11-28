package com.example.fast_stock;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;
import com.example.fast_stock.model.Categoria;
import com.example.fast_stock.model.Cliente;
import com.example.fast_stock.model.Fornecedor;
import com.example.fast_stock.model.NotaFiscalEntrada;
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

				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, 2020);
				cal.set(Calendar.MONTH, 11 - 1);
				cal.set(Calendar.DAY_OF_MONTH, 10);
				Date date = new Date(cal.getTimeInMillis());
				System.out.println(sdf.format(date));

				NotaFiscalEntrada nfe = new NotaFiscalEntrada();

				nfe.setData(date);

				Fornecedor f = new Fornecedor();

				f.setCnpj("121211-1000");
				f.setEndereco("Caso joaozinho");
				f.setNome("Casa de Limpeza");
				f.setTelefone("77999014752");

			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}

		};
	}

}
