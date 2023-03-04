package hiag0liveira.github.io.upcar.domain.repository;

import hiag0liveira.github.io.upcar.domain.entity.Agendamento;
import hiag0liveira.github.io.upcar.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Agendamentos extends JpaRepository<Agendamento, Integer> {
}
