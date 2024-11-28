package com.example.fast_stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fast_stock.model.Cliente;
import com.example.fast_stock.repository.ClienteRepository;

@Service
@Transactional(readOnly = false)
public class ClienteService {
    @Autowired
    private ClienteRepository repo;

    @Transactional
    public Cliente salvar(Cliente c) {

        if (!repo.findByNome(c.getNome()).isEmpty()) {
            throw new RuntimeException("Cliente JÁ EXISTENTE");
        } else {
            return repo.save(c);
        }
    }

    @Transactional
    public void deletar(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public Cliente atualizar(Cliente c) {
        return (repo.save(c));
    }

    @Transactional
    public List<Cliente> listarTodos() {
        return repo.findAll();
    }

}
