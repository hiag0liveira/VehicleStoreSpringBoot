package hiag0liveira.github.io.upcar.rest.controller.apirest;

import hiag0liveira.github.io.upcar.domain.entity.Endereco;
import hiag0liveira.github.io.upcar.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apirest/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping("{id}")
    public ResponseEntity OneEnderecoById(@PathVariable Integer id ){
        return ResponseEntity.ok(service.getEnderecoById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveNewEndereco( @RequestBody Endereco endereco ){
        service.saveOneNewEndereco(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity OneDeleteEnderecoByID( @PathVariable Integer id ){
        service.deleteEnderecoByID(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity updateEnderecoByID( @PathVariable Integer id, @RequestBody Endereco endereco ){
        service.updateEndereco(id , endereco);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity findAllEnderecos(){
        return ResponseEntity.ok(service.findAllEnderecos());
    }

}
