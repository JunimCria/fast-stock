package com.example.fast_stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fast_stock.model.Fornecedor;
import java.util.List;


public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    List<Fornecedor> findByNome(String nome);

}
