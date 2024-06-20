package com.Richi.Gestionale.Models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "prodottiOrdini")
public class ProdottoOrdine {
    @EmbeddedId
    private ProdottoOrdineId id;


    @ManyToOne
    @MapsId("ordineId")
    private Ordine ordine;

    @ManyToOne
    @MapsId("prodottoId")
    private Prodotto prodotto;

    private Integer quantità;

    public ProdottoOrdine() {
    }

    public ProdottoOrdine(Ordine ordine, Prodotto prodotto, Integer quantità) {
        this.ordine = ordine;
        this.prodotto = prodotto;
        this.quantità = quantità;
    }

    public ProdottoOrdine(ProdottoOrdineId id, Ordine ordine, Prodotto prodotto, Integer quantità) {
        this.id = id;
        this.ordine = ordine;
        this.prodotto = prodotto;
        this.quantità = quantità;
    }

    public ProdottoOrdineId getId() {
        return id;
    }

    public void setId(ProdottoOrdineId id) {
        this.id = id;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public Integer getQuantità() {
        return quantità;
    }

    public void setQuantità(Integer quantità) {
        this.quantità = quantità;
    }

    @Embeddable
    public static class ProdottoOrdineId implements Serializable{
        private Long ordineId;
        private Long prodottoId;

        public ProdottoOrdineId() {
        }

        public ProdottoOrdineId(Long ordineId, Long prodottoId) {
            this.ordineId = ordineId;
            this.prodottoId = prodottoId;
        }

        public Long getOrdineId() {
            return ordineId;
        }

        public void setOrdineId(Long ordineId) {
            this.ordineId = ordineId;
        }

        public Long getProdottoId() {
            return prodottoId;
        }

        public void setProdottoId(Long prodottoId) {
            this.prodottoId = prodottoId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ProdottoOrdineId that = (ProdottoOrdineId) o;

            if (!ordineId.equals(that.ordineId)) return false;
            return prodottoId.equals(that.prodottoId);
        }

        @Override
        public int hashCode() {
            int result = ordineId.hashCode();
            result = 31 * result + prodottoId.hashCode();
            return result;
        }
    }

    @Override
    public String toString() {
        return "ProdottoOrdine{" +
                "id=" + id +
                ", ordine=" + ordine +
                ", prodotto=" + prodotto +
                ", quantità=" + quantità +
                '}';
    }
}

