package hiag0liveira.github.io.upcar.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Calendar;

@Entity
@Table( name = "agendamento" )
public class Agendamento extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name="id_vendedor")
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="id_horario")
    private Horario horario;

    @Column(name="data_Reuniao")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataReuniao;

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public LocalDate getDataReuniao() {
        return dataReuniao;
    }

    public void setDataReuniao(LocalDate dataReuniao) {
        this.dataReuniao = dataReuniao;
    }
}
