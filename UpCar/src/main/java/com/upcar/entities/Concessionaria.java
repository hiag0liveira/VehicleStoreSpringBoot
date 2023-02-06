package com.upcar.entities;

public class Concessionaria {
    private Endereco endereco;
    private String nome;
    private String cnpj;
    
    public Concessionaria(Endereco endereco, String nome, String cnpj) {
        this.endereco = endereco;
        this.nome = nome;
        this.cnpj = cnpj;
    }

}
