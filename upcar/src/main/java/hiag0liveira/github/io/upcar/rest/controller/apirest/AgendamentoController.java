package hiag0liveira.github.io.upcar.rest.controller.apirest;

import hiag0liveira.github.io.upcar.domain.entity.Agendamento;
import hiag0liveira.github.io.upcar.domain.repository.Agendamentos;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping ("/api/agendamentos")
public class AgendamentoController {

    private Agendamentos agendamentos;

    public AgendamentoController(Agendamentos agendamentos) {
        this.agendamentos = agendamentos;
    }

    @GetMapping("{id}")
    public Agendamento getAgendamentoById( @PathVariable Integer id ){
        return agendamentos
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Agendamento não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento save( @RequestBody Agendamento agendamento ){
        return agendamentos.save(agendamento);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        agendamentos.findById(id)
                .map( agendamento -> {
                    agendamentos.delete(agendamento );
                    return agendamento;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Agendamento não encontrado") );

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Agendamento agendamento ){
        agendamentos
                .findById(id)
                .map( agendamentoExistente -> {
                    agendamento.setId(agendamentoExistente.getId());
                    agendamentos.save(agendamento);
                    return agendamentoExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Agendamento não encontrado") );
    }

    @GetMapping
    public List<Agendamento> find(Agendamento filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return agendamentos.findAll(example);
    }
}
