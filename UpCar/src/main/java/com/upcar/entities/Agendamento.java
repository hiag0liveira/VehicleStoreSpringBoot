package com.upcar.entities;

import java.sql.Date;

import io.micrometer.core.instrument.Clock;

public class Agendamento {
    private Date data;
    private Clock hora;

    public Agendamento(Date data, Clock hora) {
        this.data = data;
        this.hora = hora;
    }

    public void agendarVisita(){

    }

    public void consultarVisitasAgendadas(){
        
    }
}
