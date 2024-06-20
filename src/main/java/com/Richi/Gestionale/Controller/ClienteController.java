package com.Richi.Gestionale.Controller;

import com.Richi.Gestionale.Models.Cliente;
import com.Richi.Gestionale.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clienti")//prefisso come per tutti i clienti
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping
    public String visualizzaClienti(Model model){
        List<Cliente> clienti= clienteService.getAllClienti();
        model.addAttribute("clienti",clienti);
        return "lista-clienti";
    }

    @GetMapping("nuovo")
    public String mostraFormNuovoCliente (Model model){
        model.addAttribute("cliente", new Cliente());
        return "form-cliente";
    }
    @PostMapping("/nuovo")
    public String creaCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.creaCliente(cliente);
        return "redirect:/clienti";
    }


    @GetMapping("/{id}/modifica")
    public String mostraFormModificaCliente(@PathVariable("id") Long id, Model model) {
        Cliente cliente = clienteService.getAllClientiById(id);
        model.addAttribute("cliente", cliente);
        return "form-cliente";
    }

    @PostMapping("/{id}/modifica")
    public String aggiornaCliente(@PathVariable ("id") Long id, @ModelAttribute("cliente") Cliente cliente) {
        cliente.setId(id); // Assicurati di impostare l'ID per l'aggiornamento
        clienteService.aggiornaCliente(cliente);
        return "redirect:/clienti";
    }

    @GetMapping("/{id}/elimina")
    public String eliminaCliente(@PathVariable("id") Long id) {
        clienteService.eliminaCliente(id);
        return "redirect:/clienti";
    }
}
