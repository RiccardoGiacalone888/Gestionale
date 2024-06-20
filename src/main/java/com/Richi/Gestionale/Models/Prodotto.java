package com.Richi.Gestionale.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="prodotti")
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descrizione;
    private BigDecimal prezzo;
    private Integer quantitàDisponibile;
    @OneToMany(mappedBy ="prodotto", cascade = CascadeType.ALL)
    private List<ProdottoOrdine> prodottoOrdines;

    public Prodotto() {
    }

    public Prodotto(String nome, String descrizione, BigDecimal prezzo,
                    Integer quantitàDisponibile, List<ProdottoOrdine> prodottoOrdines) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantitàDisponibile = quantitàDisponibile;
        this.prodottoOrdines = prodottoOrdines;
    }

    public Prodotto(Long id, String nome, String descrizione, BigDecimal prezzo,
                    Integer quantitàDisponibile, List<ProdottoOrdine> prodottoOrdines) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantitàDisponibile = quantitàDisponibile;
        this.prodottoOrdines = prodottoOrdines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public Integer getQuantitàDisponibile() {
        return quantitàDisponibile;
    }

    public void setQuantitàDisponibile(Integer quantitàDisponibile) {
        this.quantitàDisponibile = quantitàDisponibile;
    }

    public List<ProdottoOrdine> getProdottoOrdines() {
        return prodottoOrdines;
    }

    public void setProdottoOrdines(List<ProdottoOrdine> prodottoOrdines) {
        this.prodottoOrdines = prodottoOrdines;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo=" + prezzo +
                ", quantitàDisponibile=" + quantitàDisponibile +
                ", prodottoOrdines=" + prodottoOrdines +
                '}';
    }
}
