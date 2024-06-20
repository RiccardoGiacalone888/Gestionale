package com.Richi.Gestionale.Repository;

import com.Richi.Gestionale.Models.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
    // Trova tutti i prodotti ordinati per nome
    List<Prodotto> findAllByOrderByNomeAsc();

    // Trova i prodotti con una quantità disponibile inferiore a una certa soglia
    List<Prodotto> findByQuantitaDisponibileLessThan(Integer soglia);

    // Trova i prodotti che sono stati ordinati almeno una volta
    @Query("SELECT DISTINCT p FROM Prodotto p JOIN FETCH p.prodottoOrdines")
    List<Prodotto> findProdottiOrdinati();
}
