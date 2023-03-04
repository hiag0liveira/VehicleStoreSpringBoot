package hiag0liveira.github.io.upcar.domain.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micrometer.core.instrument.Clock;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table( name = "agendamento" )
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "data_agendamento", nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @Column(name = "hora")
    private LocalDateTime hora;

    public Agendamento(LocalDate data, LocalDateTime hora) {
        this.data = data;
        this.hora = hora;
    }

    public Agendamento() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", data=" + data +
                ", hora=" + hora +
                '}';
    }
}
