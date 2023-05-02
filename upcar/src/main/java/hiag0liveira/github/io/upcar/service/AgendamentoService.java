package hiag0liveira.github.io.upcar.service;

import hiag0liveira.github.io.upcar.datatables.Datatables;
import hiag0liveira.github.io.upcar.datatables.DatatablesColunas;
import hiag0liveira.github.io.upcar.domain.entity.Agendamento;
import hiag0liveira.github.io.upcar.domain.entity.Horario;
import hiag0liveira.github.io.upcar.domain.repository.AgendamentoRepositorio;
import hiag0liveira.github.io.upcar.domain.repository.projection.HistoricoAgendamentos;
import hiag0liveira.github.io.upcar.exception.AcessoNegadoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepositorio agendamentosRepository;
    @Autowired
    private Datatables datatables;

    @Transactional(readOnly = true)
    public List<Horario> buscarHorariosNaoAgendadosPorVendedorIdEData(Long id, LocalDate data) {

        return agendamentosRepository.findByVendedorIdAndDataNotHorarioAgendado(id, data);
    }

    @Transactional(readOnly = false)
    public void salvar(Agendamento agendamento) {

        agendamentosRepository.save(agendamento);
    }

    @Transactional(readOnly = true)
    public Map<String, Object> buscarHistoricoPorVendedorEmail(String email, HttpServletRequest request) {
        datatables.setRequest(request);
        datatables.setColunas(DatatablesColunas.AGENDAMENTOS);
        Page<HistoricoAgendamentos> page = agendamentosRepository.findHistoricoByVendedorEmail(email, datatables.getPageable());
        return datatables.getResponse(page);
    }

    @Transactional(readOnly = true)
    public Agendamento buscarPorId(Long id) {
        return agendamentosRepository.findById(id).get();
    }

    @Transactional(readOnly = false)
    public void editar(Agendamento agendamento, String email) {
        Agendamento ag = agendamentosRepository.findById(agendamento.getId()).get();
        ag.setVendedor(agendamento.getVendedor());
        ag.setCliente(agendamento.getCliente());
        ag.setHorario(agendamento.getHorario());
        ag.setDataReuniao(agendamento.getDataReuniao());
    }

    @Transactional(readOnly = false)
    public void remover(Long id) {
        agendamentosRepository.deleteById(id);
    }

}
