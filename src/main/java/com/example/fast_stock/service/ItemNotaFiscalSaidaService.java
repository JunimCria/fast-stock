package com.example.fast_stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fast_stock.model.ItemNotaFiscalSaida;
import com.example.fast_stock.repository.ItemNotaFiscalSaidaRepository;

@Service
@Transactional(readOnly = false)
public class ItemNotaFiscalSaidaService {
    @Autowired
    private ItemNotaFiscalSaidaRepository repo;

    @Transactional
    public ItemNotaFiscalSaida salvar(ItemNotaFiscalSaida c) {
        return repo.save(c);
    }

    @Transactional
    public void deletar(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public ItemNotaFiscalSaida atualizar(ItemNotaFiscalSaida c) {
        return (repo.save(c));
    }

    @Transactional
    public List<ItemNotaFiscalSaida> listarTodos() {
        return repo.findAll();
    }
}
