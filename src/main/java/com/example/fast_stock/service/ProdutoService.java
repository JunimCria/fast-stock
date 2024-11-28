package com.example.fast_stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fast_stock.model.Produto;
import com.example.fast_stock.repository.ProdutoRepository;

@Service
@Transactional(readOnly = false)
public class ProdutoService {
    @Autowired
    private ProdutoRepository repo;

    @Transactional
    public Produto salvar(Produto c) {

        if (!repo.findByNome(c.getNome()).isEmpty()) {
            throw new RuntimeException("Produto JÁ EXISTENTE");
        } else {
            return repo.save(c);
        }
    }

    @Transactional
    public void deletar(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public Produto atualizar(Produto c) {
        return (repo.save(c));
    }

    @Transactional
    public List<Produto> listarTodos() {
        return repo.findAll();
    }
}
