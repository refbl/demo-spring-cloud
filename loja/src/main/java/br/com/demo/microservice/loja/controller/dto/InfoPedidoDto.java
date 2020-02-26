package br.com.demo.microservice.loja.controller.dto;

public class InfoPedidoDto {

    private long id;

    private int tempoDePreparo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(int tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }
}
