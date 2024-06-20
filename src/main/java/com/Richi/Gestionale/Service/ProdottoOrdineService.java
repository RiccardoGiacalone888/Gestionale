package com.Richi.Gestionale.Service;

import com.Richi.Gestionale.Models.Ordine;
import com.Richi.Gestionale.Models.Prodotto;
import com.Richi.Gestionale.Models.ProdottoOrdine;
import com.Richi.Gestionale.Models.ProdottoOrdine.ProdottoOrdineId;
import com.Richi.Gestionale.Repository.ProdottoOrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProdottoOrdineService {

    @Autowired
    private ProdottoOrdineRepository prodottoOrdineRepository;

    @Autowired
    private OrdineService ordineService;

    @Autowired
    private ProdottoService prodottoService;

    // Metodi CRUD di base (generati automaticamente da Spring Data JPA)
    public ProdottoOrdine save(ProdottoOrdine prodottoOrdine) {
        return prodottoOrdineRepository.save(prodottoOrdine);
    }

    public List<ProdottoOrdine> findAll() {
        return prodottoOrdineRepository.findAll();
    }

    public ProdottoOrdine findById(ProdottoOrdineId id) {
        return prodottoOrdineRepository.findById(id).orElse(null);
    }

    public void deleteById(ProdottoOrdineId id) {
        prodottoOrdineRepository.deleteById(id);
    }

    // Metodi personalizzati
    public List<ProdottoOrdine> findByOrdine(Ordine ordine) {
        return prodottoOrdineRepository.findById_OrdineId(ordine.getId());
    }

    public List<ProdottoOrdine> findByProdotto(Prodotto prodotto) {
        return prodottoOrdineRepository.findById_ProdottoId(prodotto.getId());
    }

    public List<ProdottoOrdine> findByQuantitaGreaterThan(Integer soglia) {
        return prodottoOrdineRepository.findByQuantitaGreaterThan(soglia);
    }

    public void aggiungiProdottoAdOrdine(Long ordineId, Long prodottoId, Integer quantita) {
        Ordine ordine = ordineService.getOrdineById(ordineId);
        Prodotto prodotto = prodottoService.getProdottoById(prodottoId);

        if (ordine != null && prodotto != null) {
            ProdottoOrdineId prodottoOrdineId = new ProdottoOrdineId(ordineId, prodottoId);
            ProdottoOrdine prodottoOrdine = new ProdottoOrdine(prodottoOrdineId, ordine, prodotto, quantita);
            save(prodottoOrdine);

            // Aggiorna la quantità disponibile del prodotto
            prodotto.setQuantitàDisponibile(prodotto.getQuantitàDisponibile() - quantita);
            prodottoService.aggiornaProdotto(prodotto);
        }
    }
}