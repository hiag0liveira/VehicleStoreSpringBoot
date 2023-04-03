package hiag0liveira.github.io.upcar.service;

import hiag0liveira.github.io.upcar.domain.entity.Agendamento;
import hiag0liveira.github.io.upcar.domain.repository.Agendamentos;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AgendamentoService {

    private Agendamentos agendamentos;

    public AgendamentoService(Agendamentos agendamentos) {
        this.agendamentos = agendamentos;
    }

    public Agendamento getAgendamentoById(@PathVariable Integer id ){
        return agendamentos
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Agendamento não encontrado"));
    }

    public Agendamento saveOneNewAgendamento(Agendamento agendamento ){
        return agendamentos.save(agendamento);
    }

    public void deleteAgendamentoByID(Integer id ){
        agendamentos.findById(id)
                .map( agendamento -> {
                    agendamentos.delete(agendamento );
                    return agendamento;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Agendamento não encontrado") );
    }

    public void updateAgendamento(Integer id, Agendamento agendamento ){
        agendamentos
                .findById(id)
                .map( agendamentoExistente -> {
                    agendamento.setId(agendamentoExistente.getId());
                    agendamentos.save(agendamento);
                    return agendamentoExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Agendamento não encontrado") );
    }

    public List<Agendamento> findAllAgendamentos(){
        return agendamentos.findAll();
    }
}
