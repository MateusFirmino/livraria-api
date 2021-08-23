package br.com.totemti.livraria.dto;

public class ErroDTO {

    private String erro;

    public ErroDTO(String erro) {
        this.erro = erro;
    }

    public String getErro(){
        return erro;
    }
}
