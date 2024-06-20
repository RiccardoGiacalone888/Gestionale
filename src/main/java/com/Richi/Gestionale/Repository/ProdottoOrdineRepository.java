package com.Richi.Gestionale.Repository;

import com.Richi.Gestionale.Models.ProdottoOrdine;
import com.Richi.Gestionale.Models.ProdottoOrdine.ProdottoOrdineId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoOrdineRepository extends JpaRepository<ProdottoOrdine, ProdottoOrdineId> {

    List<ProdottoOrdine> findById_OrdineId(Long ordineId);

    List<ProdottoOrdine> findById_ProdottoId(Long prodottoId);

    List<ProdottoOrdine> findByQuantitaGreaterThan(Integer soglia);
}