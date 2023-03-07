package hiag0liveira.github.io.upcar.rest.controller.apirest;

import hiag0liveira.github.io.upcar.domain.entity.Vendedor;
import hiag0liveira.github.io.upcar.domain.repository.Vendedores;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping ("/api/vendedor")
public class VendedorController {

    private Vendedores vendedores;

    public VendedorController(Vendedores vendedores) {
        this.vendedores = vendedores;
    }

    @GetMapping("{id}")
    public Vendedor getVendedorById(@PathVariable Integer id ){
        return vendedores
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Vendedor não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vendedor save( @RequestBody Vendedor vendedor ){
        return vendedores.save(vendedor);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        vendedores.findById(id)
                .map( vendedor -> {
                    vendedores.delete(vendedor );
                    return vendedor;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Vendedor encontrado") );

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Vendedor vendedor ){
        vendedores
                .findById(id)
                .map( vendedorExistente -> {
                    vendedor.setId(vendedorExistente.getId());
                    vendedores.save(vendedor);
                    return vendedorExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Vendedor não encontrado") );
    }

    @GetMapping
    public List<Vendedor> find(Vendedor filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return vendedores.findAll(example);
    }
}
