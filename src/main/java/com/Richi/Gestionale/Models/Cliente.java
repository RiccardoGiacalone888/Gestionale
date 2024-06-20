package com.Richi.Gestionale.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clienti")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private String telefono;
    private String email;
    private String indirizzo;
    @OneToMany(mappedBy = "cliente", cascade =CascadeType.ALL)
    private List<Ordine> ordines;

    public Cliente() {
    }

    public Cliente(String nome, String cognome, String telefono,
                   String email, String indirizzo, List<Ordine> ordines) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.email = email;
        this.indirizzo = indirizzo;
        this.ordines = ordines;
    }

    public Cliente(Long id, String nome, String cognome, String telefono,
                   String email, String indirizzo, List<Ordine> ordines) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.email = email;
        this.indirizzo = indirizzo;
        this.ordines = ordines;
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public List<Ordine> getOrdines() {
        return ordines;
    }

    public void setOrdines(List<Ordine> ordines) {
        this.ordines = ordines;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", ordines=" + ordines +
                '}';
    }
}



