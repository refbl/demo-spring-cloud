package br.com.demo.microservice.fornecedor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.demo.microservice.fornecedor.model.InfoFornecedor;
import br.com.demo.microservice.fornecedor.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	private InfoService infoService;

	@Autowired
	private static final Logger log = LoggerFactory.getLogger(InfoController.class);


	@RequestMapping("/{estado}")
	public InfoFornecedor getInfoPorEstado(@PathVariable String estado) {

		log.info("Recebido pedido de Info do Fornecedor de {}" , estado);
		return infoService.getInfoPorEstado(estado);
	}
}
