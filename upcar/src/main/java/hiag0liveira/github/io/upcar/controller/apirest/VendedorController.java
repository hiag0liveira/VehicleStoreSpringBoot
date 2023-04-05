package hiag0liveira.github.io.upcar.controller.apirest;

import hiag0liveira.github.io.upcar.domain.entity.Cliente;
import hiag0liveira.github.io.upcar.domain.entity.Vendedor;
import hiag0liveira.github.io.upcar.domain.repository.Vendedores;
import hiag0liveira.github.io.upcar.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping ("/apirest/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @GetMapping("{id}")
    public ResponseEntity OneVendedorById(@PathVariable Integer id ){
        return ResponseEntity.ok(service.getVendedorById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveNewVendedor( @RequestBody Vendedor vendedor ){
        service.saveOneNewVendedor(vendedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendedor);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity OneDeleteVendedorByID( @PathVariable Integer id ){
        service.deleteVendedorByID(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity updateVendedorByID( @PathVariable Integer id, @RequestBody Vendedor vendedor ){
        service.updateVendedor(id , vendedor);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity findAllVendedores(){
        return ResponseEntity.ok(service.findAllVendedores());
    }
}
