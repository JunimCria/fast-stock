package com.example.fast_stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fast_stock.model.Categoria;
import com.example.fast_stock.repository.CategoriaRepository;

@Service
@Transactional(readOnly = false)

public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    @Transactional
    public void salvar(Categoria c) {

        if (!repo.findByNome(c.getNome()).isEmpty()) {
            throw new RuntimeException("CATEGORIA JÁ EXISTENTE");
        } else {
            repo.save(c);
        }
    }

    @Transactional
    public void deletar(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public void atualizar(Categoria c) {
        repo.save(c);
    }

    @Transactional
    public List<Categoria> listarTodos() {
        return repo.findAll();
    }

}
