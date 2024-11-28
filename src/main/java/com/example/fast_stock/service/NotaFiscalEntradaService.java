package com.example.fast_stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fast_stock.model.NotaFiscalEntrada;
import com.example.fast_stock.repository.NotaFiscalEntradaRepository;

@Service
@Transactional(readOnly = false)
public class NotaFiscalEntradaService {
    @Autowired
    private NotaFiscalEntradaRepository repo;

    @Transactional
    public NotaFiscalEntrada salvar(NotaFiscalEntrada c) {
        return repo.save(c);
    }

    @Transactional
    public void deletar(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public NotaFiscalEntrada atualizar(NotaFiscalEntrada c) {
        return (repo.save(c));
    }

    @Transactional
    public List<NotaFiscalEntrada> listarTodos() {
        return repo.findAll();
    }
}
