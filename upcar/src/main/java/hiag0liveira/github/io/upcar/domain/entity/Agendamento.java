package hiag0liveira.github.io.upcar.domain.entity;

import java.sql.Date;

import io.micrometer.core.instrument.Clock;
import jakarta.persistence.*;

@Entity
@Table( name = "agendamento" )
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "data")
    private Date data;

    @Column(name = "hora")
    private Clock hora;

    public Agendamento(Date data, Clock hora) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Clock getHora() {
        return hora;
    }

    public void setHora(Clock hora) {
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
