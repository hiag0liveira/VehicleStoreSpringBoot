package com.upcar.entities;

import java.sql.Date;

public class FeedBack {
    private String Assunto;
    private Date data;
    
    public FeedBack(String assunto, Date data) {
        Assunto = assunto;
        this.data = data;
    }
    
    public void enviarFeedBack(){

    }

    public void curtirFeedBack(){
        
    }
}
