package com.example.fast_stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fast_stock.model.NotaFiscalSaida;
import com.example.fast_stock.repository.NotaFiscalSaidaRepository;

@Service
@Transactional(readOnly = false)
public class NotaFiscalSaidaService {
    @Autowired
    private NotaFiscalSaidaRepository repo;

    @Transactional
    public NotaFiscalSaida salvar(NotaFiscalSaida c) {
        return repo.save(c);
    }

    @Transactional
    public void deletar(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public NotaFiscalSaida atualizar(NotaFiscalSaida c) {
        return (repo.save(c));
    }

    @Transactional
    public List<NotaFiscalSaida> listarTodos() {
        return repo.findAll();
    }
}
