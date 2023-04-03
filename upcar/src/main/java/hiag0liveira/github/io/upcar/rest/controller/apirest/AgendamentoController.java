package hiag0liveira.github.io.upcar.rest.controller.apirest;

import hiag0liveira.github.io.upcar.domain.entity.Agendamento;
import hiag0liveira.github.io.upcar.service.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/apirest/agendamentos")
public class AgendamentoController {

    private AgendamentoService service;

    @GetMapping("{id}")
    public ResponseEntity OneAgendamentoById(@PathVariable Integer id ){
        return ResponseEntity.ok(service.getAgendamentoById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveNewAgendamento( @RequestBody Agendamento agendamento ){
        service.saveOneNewAgendamento(agendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamento);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity OneDeleteAgendamentoByID( @PathVariable Integer id ){
        service.deleteAgendamentoByID(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity updateAgendamentoByID( @PathVariable Integer id, @RequestBody Agendamento agendamento ){
        service.updateAgendamento(id , agendamento);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity findAllAgendamentos(){
        return ResponseEntity.ok(service.findAllAgendamentos());
    }
}
