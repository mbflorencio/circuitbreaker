package br.com.mf.controller;

import br.com.mf.model.Deadline;
import br.com.mf.service.DeadlineService;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deadline")
public class DeadlineController {

    @Autowired DeadlineService service;
    Logger logger = LogManager.getLogger(DeadlineController.class);
    @GetMapping("/{idClient}")
    @ResponseStatus(HttpStatus.OK)
    public Deadline getDeadLineByClientId( @RequestParam(value="idClient", required=true) Long idClient) {
        System.out.println("Solictou para o cliente" + idClient);
        return service.findByClientId(idClient);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Deadline> getClients(){
        return service.findAll();
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Deadline salvar(Deadline deadline){
        return service.save(deadline);
    }
}
