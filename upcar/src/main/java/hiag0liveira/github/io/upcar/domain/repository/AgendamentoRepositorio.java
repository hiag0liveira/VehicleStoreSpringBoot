package hiag0liveira.github.io.upcar.domain.repository;

import hiag0liveira.github.io.upcar.domain.entity.Agendamento;
import hiag0liveira.github.io.upcar.domain.entity.Horario;
import hiag0liveira.github.io.upcar.domain.repository.projection.HistoricoAgendamentos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AgendamentoRepositorio extends JpaRepository<Agendamento, Long> {

    @Query("select h "
            + "from Horario h "
            + "where not exists("
            + "select a.horario.id "
            + "from Agendamento a "
            + "where "
            + "a.vendedor.id = :id and "
            + "a.dataReuniao = :data and "
            + "a.horario.id = h.id "
            + ") "
            + "order by h.horaMinuto asc")
    List<Horario> findByVendedorIdAndDataNotHorarioAgendado(Long id, LocalDate data);

    @Query("select a.id as id,"
            + "a.cliente as cliente,"
            + "CONCAT(a.dataReuniao, ' ', a.horario.horaMinuto) as dataReuniao,"
            + "a.vendedor as vendedor "
        + "from Agendamento a "
        + "where a.vendedor.usuario.email like :email")
    Page<HistoricoAgendamentos> findHistoricoByVendedorEmail(String email, Pageable pageable);

}
