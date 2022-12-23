package com.upcar.entities;

public class Vendedor extends Pessoa{

    private String cargo;

    public Vendedor(String nome, String cpf, String codUser, String email, String telefone, String senha,
            String cargo) {
        super(nome, cpf, codUser, email, telefone, senha);
        this.cargo = cargo;
    }

    public void cadastrarVendedor(){

    }

    public void listaVendedores(){

    }

    public void registrarVenda(){
        
    }
}
