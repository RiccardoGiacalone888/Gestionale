package com.Richi.Gestionale.Controller;

import com.Richi.Gestionale.Models.ProdottoOrdine;
import com.Richi.Gestionale.Models.ProdottoOrdine.ProdottoOrdineId;
import com.Richi.Gestionale.Service.OrdineService;
import com.Richi.Gestionale.Service.ProdottoOrdineService;
import com.Richi.Gestionale.Service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/prodotto-ordini")
public class ProdottoOrdineController {

    @Autowired
    private ProdottoOrdineService prodottoOrdineService;

    @Autowired
    private OrdineService ordineService;

    @Autowired
    private ProdottoService prodottoService;

    // Visualizza tutti i ProdottoOrdine
    @GetMapping
    public String visualizzaProdottoOrdini(Model model) {
        List<ProdottoOrdine> prodottoOrdini = prodottoOrdineService.findAll();
        model.addAttribute("prodottoOrdini", prodottoOrdini);
        return "lista-prodotto-ordini";
    }

    // Mostra il form per creare un nuovo ProdottoOrdine
    @GetMapping("/nuovo")
    public String mostraFormNuovoProdottoOrdine(Model model) {
        model.addAttribute("prodottoOrdine", new ProdottoOrdine());
        model.addAttribute("ordini", ordineService.getAllOrdine());
        model.addAttribute("prodotti", prodottoService.getAllProdotto());
        return "form-prodotto-ordine";
    }

    // Crea un nuovo ProdottoOrdine
    @PostMapping("/nuovo")
    public String creaProdottoOrdine(@ModelAttribute("prodottoOrdine") ProdottoOrdine prodottoOrdine) {
        prodottoOrdineService.save(prodottoOrdine);
        return "redirect:/prodotto-ordini";
    }

    // Mostra il form per modificare un ProdottoOrdine esistente
    @GetMapping("/{ordineId}/{prodottoId}/modifica")
    public String mostraFormModificaProdottoOrdine(@PathVariable("ordineId") Long ordineId,
                                                   @PathVariable("prodottoId") Long prodottoId,
                                                   Model model) {
        ProdottoOrdineId prodottoOrdineId = new ProdottoOrdineId(ordineId, prodottoId);
        ProdottoOrdine prodottoOrdine = prodottoOrdineService.findById(prodottoOrdineId);
        model.addAttribute("prodottoOrdine", prodottoOrdine);
        model.addAttribute("ordini", ordineService.getAllOrdine());
        model.addAttribute("prodotti", prodottoService.getAllProdotto());
        return "form-prodotto-ordine";
    }

    // Aggiorna un ProdottoOrdine esistente
    @PostMapping("/{ordineId}/{prodottoId}/modifica")
    public String aggiornaProdottoOrdine(@PathVariable("ordineId") Long ordineId,
                                         @PathVariable("prodottoId") Long prodottoId,
                                         @RequestParam("quantita") Integer quantita) {

        ProdottoOrdineId prodottoOrdineId = new ProdottoOrdineId(ordineId, prodottoId);
        ProdottoOrdine prodottoOrdine = prodottoOrdineService.findById(prodottoOrdineId);

        if (prodottoOrdine != null) {
            prodottoOrdine.setQuantità(quantita);
            prodottoOrdineService.save(prodottoOrdine);
        }

        return "redirect:/prodotto-ordini";
    }

    // Elimina un ProdottoOrdine
    @GetMapping("/{ordineId}/{prodottoId}/elimina")
    public String eliminaProdottoOrdine(@PathVariable("ordineId") Long ordineId,
                                        @PathVariable("prodottoId") Long prodottoId) {

        ProdottoOrdineId prodottoOrdineId = new ProdottoOrdineId(ordineId, prodottoId);
        prodottoOrdineService.deleteById(prodottoOrdineId);

        return "redirect:/prodotto-ordini";
    }
}