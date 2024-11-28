package com.example.fast_stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fast_stock.model.ItemNotaFiscalEntrada;
import com.example.fast_stock.repository.ItemNotaFiscalEntradaRepository;

@Service
@Transactional(readOnly = false)
public class ItemNotaFiscalEntradaService {
    @Autowired
    private ItemNotaFiscalEntradaRepository repo;

    @Transactional
    public ItemNotaFiscalEntrada salvar(ItemNotaFiscalEntrada c) {
        return repo.save(c);
    }

    @Transactional
    public void deletar(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public ItemNotaFiscalEntrada atualizar(ItemNotaFiscalEntrada c) {
        return (repo.save(c));
    }

    @Transactional
    public List<ItemNotaFiscalEntrada> listarTodos() {
        return repo.findAll();
    }
}
