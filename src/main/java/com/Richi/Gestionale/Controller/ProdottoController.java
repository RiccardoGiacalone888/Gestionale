package com.Richi.Gestionale.Controller;
import com.Richi.Gestionale.Models.Prodotto;
import com.Richi.Gestionale.Service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("prodotti")
public class ProdottoController {
    @Autowired
    private ProdottoService prodottoService;

    @GetMapping
    public String visualizzaProdotto (Model model){
        List<Prodotto> prodotti= prodottoService.getAllProdotto();
        model.addAttribute("prodotti", prodotti);
        return "lista-prodotti";
    }

    @GetMapping("/nuovo")
    public String mostraFormNuovoProdotto(Model model){
        model.addAttribute("prodotto", new Prodotto());
        return "form-prodotto";
    }

    @PostMapping("/nuovo")
    public String creaProdotto (@ModelAttribute("prodotto") Prodotto prodotto){
        prodottoService.creaProdotto(prodotto);
        return "redirect:/prodotto";
    }

    @GetMapping("/{id}/modifica")
    public String mostraFormModificaProdotto(@PathVariable("id") Long id, Model model){
        Prodotto prodotto = prodottoService.getAllProdottoById(id);
        model.addAttribute("prodotto", prodotto);
        return "form-prodotto";

    }


    @PostMapping("/{id}/modifica")
    public String aggiornaProdotto(@PathVariable("id") Long id, @ModelAttribute("prodotto") Prodotto prodotto){
        prodotto.setId(id);
        prodottoService.aggiornaProdotto(prodotto);
        return "redirect:/prodotto";
    }

    @GetMapping("/{id}/elimina")
    public String eliminaProdotto(@PathVariable("id") Long id){
        prodottoService.eliminaProdotto(id);
        return "redirect:/prodotto";
    }

}
