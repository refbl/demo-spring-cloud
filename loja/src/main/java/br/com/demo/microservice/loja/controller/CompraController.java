package br.com.demo.microservice.loja.controller;

import br.com.demo.microservice.loja.controller.dto.CompraDto;
import br.com.demo.microservice.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @RequestMapping(method = RequestMethod.POST )
    public void realizaCompra(@RequestBody CompraDto compra){

        compraService.realizaCompra(compra);

    }

}
