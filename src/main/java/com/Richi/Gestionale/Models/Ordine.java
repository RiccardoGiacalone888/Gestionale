package com.Richi.Gestionale.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ordini")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private BigDecimal totale;
    @ManyToOne
    @JoinColumn(name = "clienti_id")
    private Cliente cliente;
    @OneToMany(mappedBy ="ordine", cascade = CascadeType.ALL)
    private List<ProdottoOrdine> prodottoOrdines;

    public Ordine() {
    }

    public Ordine(LocalDate data, BigDecimal totale, Cliente cliente,
                  List<ProdottoOrdine> prodottoOrdines) {
        this.data = data;
        this.totale = totale;
        this.cliente = cliente;
        this.prodottoOrdines = prodottoOrdines;
    }

    public Ordine(Long id, LocalDate data, BigDecimal totale,
                  Cliente cliente, List<ProdottoOrdine> prodottoOrdines) {
        this.id = id;
        this.data = data;
        this.totale = totale;
        this.cliente = cliente;
        this.prodottoOrdines = prodottoOrdines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getTotale() {
        return totale;
    }

    public void setTotale(BigDecimal totale) {
        this.totale = totale;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProdottoOrdine> getProdottoOrdines() {
        return prodottoOrdines;
    }

    public void setProdottoOrdines(List<ProdottoOrdine> prodottoOrdines) {
        this.prodottoOrdines = prodottoOrdines;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", data=" + data +
                ", totale=" + totale +
                ", cliente=" + cliente +
                ", prodottoOrdines=" + prodottoOrdines +
                '}';
    }
}
