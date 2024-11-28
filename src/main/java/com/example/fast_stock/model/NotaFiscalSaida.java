package com.example.fast_stock.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class NotaFiscalSaida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @Temporal(TemporalType.DATE)
    private Date data;

    @ManyToOne(optional = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "notaFiscalSaida", cascade = CascadeType.ALL)
    private List<ItemNotaFiscalSaida> itens;

    
}
