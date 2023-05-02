package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "horas", indexes = {@Index(name = "idx_hora_minuto", columnList = "hora_minuto")})
public class Horario extends AbstractEntity{

    @Column(name = "hora_minuto", unique = true, nullable = false)
    private LocalTime horaMinuto;

    public LocalTime getHoraMinuto() {
        return horaMinuto;
    }

    public void setHoraMinuto(LocalTime horaMinuto) {
        this.horaMinuto = horaMinuto;
    }
}

