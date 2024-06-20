package com.Richi.Gestionale.Service;

import com.Richi.Gestionale.Models.Cliente;
import com.Richi.Gestionale.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClienti(){
        return clienteRepository.findAllByOrderByCognomeAsc();
    }

    public Cliente getAllClientiById(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente creaCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente aggiornaCliente (Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void eliminaCliente (Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente getClienteByEmail(String email){
        return clienteRepository.findByEmail(email);
    }
}
