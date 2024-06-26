package br.com.mf.controller;

import br.com.mf.service.MyServiceClientImpl;
import br.com.mf.util.RequestData;
import br.com.mf.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    MyServiceClientImpl service;
    @GetMapping("/{idClient}")
    @ResponseStatus(HttpStatus.OK)
    public HashMap getOrder(@RequestParam(value="idClient", required=true)  Long idClient) {

        return service.fetchData(idClient);
    }
}
