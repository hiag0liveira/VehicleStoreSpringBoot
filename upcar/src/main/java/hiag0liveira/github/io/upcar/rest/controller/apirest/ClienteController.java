package hiag0liveira.github.io.upcar.rest.controller.apirest;

import hiag0liveira.github.io.upcar.domain.entity.Cliente;
import hiag0liveira.github.io.upcar.domain.repository.Clientes;
import hiag0liveira.github.io.upcar.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/apirest/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("{id}")
    public ResponseEntity OneClienteById(@PathVariable Integer id ){
        return ResponseEntity.ok(service.getClienteById(id));
        }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveNewCliente( @RequestBody Cliente cliente ){
       service.saveOneNewCliente(cliente);
       return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity OneDeleteClienteByID( @PathVariable Integer id ){
        service.deleteClienteByID(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity updateClienteByID( @PathVariable Integer id, @RequestBody Cliente cliente ){
        service.updateCliente(id , cliente);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity findAllClientes(){
        return ResponseEntity.ok(service.findAllClientes());
    }
}
