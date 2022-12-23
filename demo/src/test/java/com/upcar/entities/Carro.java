package com.upcar.entities;

public class Carro {
    private String nome, marca, modelo, cor, placa, km, descricao;
    private int anoFabricacao, anoModelo;
    private TipoCombustivelEnum tipoCombustivelEnum;

    public Carro(String nome, String marca, String modelo, String cor, String placa, String km, String descricao,
            int anoFabricacao, int anoModelo, TipoCombustivelEnum tipoCombustivelEnum) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.km = km;
        this.descricao = descricao;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.tipoCombustivelEnum = tipoCombustivelEnum;
    }

    public void adicionarCarro(){

    }

    public void removerCarro(){

    }

    public void statusCarro(){

    }

    public void visualizarCarrosCadastrados(){
        
    }
}
