package com.example.fast_stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fast_stock.model.Fornecedor;
import com.example.fast_stock.repository.FornecedorRepository;

@Service
@Transactional(readOnly = false)
public class FornecedorService {
    @Autowired
    private FornecedorRepository repo;

    @Transactional
    public Fornecedor salvar(Fornecedor c) {

        if (!repo.findByNome(c.getNome()).isEmpty()) {
            throw new RuntimeException("Fornecedor JÁ EXISTENTE");
        } else {
            return repo.save(c);
        }
    }

    @Transactional
    public void deletar(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public Fornecedor atualizar(Fornecedor c) {
        return (repo.save(c));
    }

    @Transactional
    public List<Fornecedor> listarTodos() {
        return repo.findAll();
    }

}