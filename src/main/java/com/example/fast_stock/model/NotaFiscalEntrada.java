package com.example.fast_stock.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class NotaFiscalEntrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @Temporal(TemporalType.DATE)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "notaFiscalEntrada", cascade = CascadeType.ALL)
    private List<ItemNotaFiscalEntrada> itens;

    @Override
    public String toString() {
        return "NotaFiscalEntrada{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", data='" + data + '\'' +
                ", fornecedor=" + fornecedor.getNome() +
                '}';
    }
}