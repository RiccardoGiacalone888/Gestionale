package com.Richi.Gestionale.Service;

import com.Richi.Gestionale.Models.Prodotto;
import com.Richi.Gestionale.Repository.ProdottoRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoService {
    @Autowired
    public ProdottoRepository prodottoRepository;

    public List<Prodotto> getAllProdotto (){
    return prodottoRepository.findAllByOrderByNomeAsc();
    }

    public Prodotto getAllProdottoById (Long id){
        return prodottoRepository.findById(id).orElse(null);
    }

    public Prodotto getProdottoById(Long id) {
        return prodottoRepository.findById(id).orElse(null); // Restituisce null se il prodotto non esiste
    }

    public Prodotto creaProdotto (Prodotto prodotto){
        return prodottoRepository.save(prodotto);
    }

    public Prodotto aggiornaProdotto(Prodotto prodotto){
        return prodottoRepository.save(prodotto);
    }

    public void eliminaProdotto(Long id){
        prodottoRepository.deleteById(id);
    }


}
