package br.com.demo.microservice.fornecedor.service;

import br.com.demo.microservice.fornecedor.model.InfoFornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;


    public InfoFornecedor getInfoPorEstado(String estado) {

        return infoRepository.findByEstado(estado);
    }
}
