package com.upcar.entities;

public class Cliente extends Pessoa{
    
    public Cliente(String nome, String cpf, String codUser, String email, String telefone, String senha) {
        super(nome, cpf, codUser, email, telefone, senha);
    }

    public void comprasEfetuadasPeloCliente(){
        
    }
}
