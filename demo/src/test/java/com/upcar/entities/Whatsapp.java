package com.upcar.entities;

public class Whatsapp {
    private Concessionaria concessionaria;
    private String telefone;

    public void RedirecionarWhatsapp(){
        
    }

    public Whatsapp(Concessionaria concessionaria, String telefone) {
        this.concessionaria = concessionaria;
        this.telefone = telefone;
    }
}
