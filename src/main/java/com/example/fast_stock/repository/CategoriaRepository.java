package com.example.fast_stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fast_stock.model.Categoria;
import java.util.List;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByNome(String nome);

}