package com.Richi.Gestionale.Service;

import com.Richi.Gestionale.Models.Ordine;
import com.Richi.Gestionale.Repository.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrdineService {
    @Autowired
    public OrdineRepository ordineRepository;

    public List<Ordine> getAllOrdine(){
        return ordineRepository.findAll();
    }
    public Ordine getAllOrdineByID (Long id){
        return ordineRepository.findById(id).orElse(null);
    }

    public Ordine creaOrdine (Ordine ordine){
        return ordineRepository.save(ordine);
    }

    public Ordine getOrdineById(Long id) {
        return ordineRepository.findById(id).orElse(null); // Restituisce null se l'ordine non esiste
    }

    public List<Ordine> getOrdineByIdCliente (Long clienteId){
        return ordineRepository.findByClienteId(clienteId);
    }

    public List<Ordine> getOrdineByPeriodo (LocalDate dataInizio, LocalDate dataFine){
        return ordineRepository.findByDataBetween(dataInizio,dataFine);
    }

    public List<Ordine> getOrdineByTotaleSuperioreA(BigDecimal soglia){
        return ordineRepository.findByTotaleGreaterThan(soglia);
    }

    public Ordine aggiornaOrdine(Ordine ordine) {
        // Qui puoi aggiungere eventuali controlli di validazione prima di salvare l'ordine aggiornato
        return ordineRepository.save(ordine);
    }

    public void eliminaOrdine (Long id){
        ordineRepository.deleteById(id);
    }
}
