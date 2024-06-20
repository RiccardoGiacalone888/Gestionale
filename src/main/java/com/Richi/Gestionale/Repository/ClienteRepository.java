package com.Richi.Gestionale.Repository;

import com.Richi.Gestionale.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Trova un cliente per email (utile per il login)
    Cliente findByEmail(String email);

    // Trova tutti i clienti ordinati per cognome
    List<Cliente> findAllByOrderByCognomeAsc();

    // Trova i clienti che hanno effettuato almeno un ordine
    @Query("SELECT DISTINCT c FROM Cliente c JOIN FETCH c.ordini")
    List<Cliente> findClientiConOrdini();

}
