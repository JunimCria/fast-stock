package com.example.fast_stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fast_stock.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
