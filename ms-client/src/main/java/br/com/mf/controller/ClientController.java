package br.com.mf.controller;

import br.com.mf.model.Client;
import br.com.mf.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired ClientService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client getClientById(@RequestParam(value="id", required=true)  Long id) {
        return service.findById(id);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getClients(){
        return service.findAll();
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Client salvar(Client client){
        return service.save(client);
    }
}
