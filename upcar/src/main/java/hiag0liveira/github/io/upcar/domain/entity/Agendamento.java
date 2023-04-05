package hiag0liveira.github.io.upcar.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;

@Entity
@Table( name = "agendamento" )
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Data de registro é obrigatória.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Calendar dataHora;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Data de Agendamento é obrigatória.")
    @Future(message = "Data de Agendamento de Reunião deve ser acima da atual")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Calendar InicioReuniao;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Calendar FimReuniao;

    public Agendamento() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public Calendar getInicioReuniao() {
        return InicioReuniao;
    }

    public void setInicioReuniao(Calendar inicioReuniao) {
        InicioReuniao = inicioReuniao;
    }

    public Calendar getFimReuniao() {
        return FimReuniao;
    }

    public void setFimReuniao(Calendar fimReuniao) {
        FimReuniao = fimReuniao;
    }
}
