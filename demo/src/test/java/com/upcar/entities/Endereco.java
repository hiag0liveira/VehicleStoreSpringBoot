package com.upcar.entities;

public class Endereco {
    private String rua;
    private String numero;
    private String cep;
    private String complemento;
    private String cidade;
    private String bairro;
    private String estado;
    
    public Endereco(String rua, String numero, String cep, String complemento, String cidade, String bairro,
            String estado) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
    }
}
