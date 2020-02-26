package br.com.demo.microservice.loja.service;

import br.com.demo.microservice.loja.client.FornecedorClient;
import br.com.demo.microservice.loja.controller.dto.CompraDto;
import br.com.demo.microservice.loja.controller.dto.InfoFornecedorDto;
import br.com.demo.microservice.loja.controller.dto.InfoPedidoDto;
import br.com.demo.microservice.loja.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// Implementacao com Feign - Client Side Load Balancer
@Service
public class CompraService {
    @Autowired
    private RestTemplate client;

    @Autowired
    private DiscoveryClient eurekaClient;

    //Client Feign
    @Autowired
    private FornecedorClient fornecedorClient;


    public Compra realizaCompra(CompraDto compraDto){


        InfoFornecedorDto infoPorEstado = fornecedorClient.getInfoPorEstado(compraDto.getEndereco().getEstado());

        InfoPedidoDto infoPedido = fornecedorClient.realizaPedido(compraDto.getItens());

        if (infoPorEstado != null) {
            System.out.println(infoPorEstado.getEndereco());

        } else {
            System.out.println("Info por Estado Nulo..");
        }

        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(infoPedido.getId());
        compraSalva.setTempoDePreparo(infoPedido.getTempoDePreparo());
        compraSalva.setEnderecoDestino(compraDto.getEndereco().toString());

        return compraSalva;

    }




    /* Implementacao SEM utilizacao do Feing
    // Utiliza ResponseEntity e Ribbon
    public void realizaCompra(CompraDto compraDto){

        // Faz um Request do tipo GET para acessar o servico de outro sistema (Fornecedor)
        //String url = "http://localhost:8081/info/" + compraDto.getEndereco().getEstado();

        // Endereco para Utilizar o Service Dicover (Eureka)
        String url = "http://fornecedor/info/" + compraDto.getEndereco().getEstado();

        System.out.println(url);

        ResponseEntity<InfoFornecedorDto> exchange = client.exchange(url
                , HttpMethod.GET, null, InfoFornecedorDto.class);


        eurekaClient.getInstances("fornecedor").stream()
                .forEach(fornecedor -> {
                    System.out.println("++++localhost:"+fornecedor.getPort());
                });

        System.out.println(exchange.getBody().getEndereco());
    }

     */
}
