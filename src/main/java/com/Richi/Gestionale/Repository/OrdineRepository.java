package com.Richi.Gestionale.Repository;

import com.Richi.Gestionale.Models.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Long> {
    // Trova tutti gli ordini di un cliente
    List<Ordine> findByClienteId(Long clienteId);

    // Trova tutti gli ordini effettuati in un determinato periodo
    List<Ordine> findByDataBetween(LocalDate dataInizio, LocalDate dataFine);

    // Trova gli ordini con un totale superiore a una certa soglia
    List<Ordine> findByTotaleGreaterThan(BigDecimal soglia);

}
