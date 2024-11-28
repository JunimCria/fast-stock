package com.example.fast_stock.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cpfOuCnpj;

    @Column(nullable = false)
    private String nome;

    private String endereco;

    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<NotaFiscalSaida> notasFiscais;
}
