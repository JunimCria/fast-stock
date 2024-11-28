package com.example.fast_stock.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private Long preco;

    @Column(nullable = false)
    private Integer quantidadeEstoque;

    @ManyToOne(optional = false)
    private Categoria categoria;

    @Override
    public String toString() {
        return "Produto [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", preco="
                + preco + ", quantidadeEstoque=" + quantidadeEstoque + ", categoria=" + categoria + "]";
    }
}
