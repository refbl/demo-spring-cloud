package br.com.demo.microservice.loja.service;

import br.com.demo.microservice.loja.controller.dto.CompraDto;
import br.com.demo.microservice.loja.controller.dto.InfoFornecedorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {
    @Autowired
    private RestTemplate client;

    public void realizaCompra(CompraDto compraDto){

        // Faz um Request do tipo GET para acessar o servico de outro sistema (Fornecedor)
        //String url = "http://localhost:8081/info/" + compraDto.getEndereco().getEstado();

        // Endereco para Utilizar o Service Dicover (Eureka)
        String url = "http://fornecedor/info/" + compraDto.getEndereco().getEstado();


        System.out.println(url);

        ResponseEntity<InfoFornecedorDto> exchange = client.exchange(url
                , HttpMethod.GET, null, InfoFornecedorDto.class);

        System.out.println(exchange.getBody().getEndereco());


    }
}
