package com.Richi.Gestionale.Controller;

import com.Richi.Gestionale.Models.Ordine;
import com.Richi.Gestionale.Service.ClienteService;
import com.Richi.Gestionale.Service.OrdineService;
import com.Richi.Gestionale.Service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("ordini")
public class OrdineController {
    @Autowired
    private OrdineService ordineService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdottoService prodottoService;

    @GetMapping
    public String visualizzaOrdini (Model model){
        List<Ordine> ordini= ordineService.getAllOrdine();
        model.addAttribute("ordini", ordini);
        return "lista-ordini";
    }

    @GetMapping("/nuovo")
    public String mostraFormNuovoOrdine (Model model){
        model.addAttribute("ordine", new Ordine());
        model.addAttribute("clienti", clienteService.getAllClienti());
        model.addAttribute("prodotti",prodottoService.getAllProdotto());
        return "form-ordine";
    }

    @PostMapping("/nuovo")
    public String creaOrdine (@ModelAttribute("ordine") Ordine ordine){
        ordineService.creaOrdine(ordine);
        return "redirect:/ordine";
    }

    @GetMapping("/{id}/modifica")
    public String mostraFormModificaOrdine (@PathVariable Long id, Model model){
        Ordine ordine = ordineService.getAllOrdineByID(id);
        model.addAttribute("ordine", ordine);
        model.addAttribute("cliente", clienteService.getAllClienti());
        model.addAttribute("prodotti", prodottoService.getAllProdotto());
        return "form-ordine";
    }

    @PostMapping("/{id}/modifica")
    public String aggiornaOrdine(@PathVariable("id") Long id, @ModelAttribute("ordine") Ordine ordine) {
        ordine.setId(id);
        ordineService.aggiornaOrdine(ordine);
        return "redirect:/ordini";
    }
    @GetMapping("/{id}/elimina")
    public String eliminaOrdine(@PathVariable("id") Long id) {
        ordineService.eliminaOrdine(id);
        return "redirect:/ordini";
    }


}
