package com.example.fast_stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fast_stock.model.Cliente;
import java.util.List;
import com.example.fast_stock.model.NotaFiscalSaida;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNome(String nome);

    List<Cliente> findByCpfOuCnpj(String cpfOuCnpj);

    List<Cliente> findByNotasFiscais(List<NotaFiscalSaida> notasFiscais);
}