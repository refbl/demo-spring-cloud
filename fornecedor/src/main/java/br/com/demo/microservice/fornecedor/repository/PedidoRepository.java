package br.com.demo.microservice.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.demo.microservice.fornecedor.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
