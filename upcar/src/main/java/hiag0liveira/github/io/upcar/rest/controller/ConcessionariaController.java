package hiag0liveira.github.io.upcar.rest.controller;

import hiag0liveira.github.io.upcar.domain.entity.Cliente;
import hiag0liveira.github.io.upcar.domain.entity.Concessionaria;
import hiag0liveira.github.io.upcar.domain.repository.Clientes;
import hiag0liveira.github.io.upcar.domain.repository.Concessionarias;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/concessionarias")
public class ConcessionariaController {

    private Concessionarias concessionarias;

    public ConcessionariaController(Concessionarias concessionarias ) {
        this.concessionarias = concessionarias;
    }

    @GetMapping("{id}")
    public Concessionaria getConcessionariaById(@PathVariable Integer id ){
        return concessionarias
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Concessionaria não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Concessionaria save( @RequestBody Concessionaria concessionaria ){
        return concessionarias.save(concessionaria);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        concessionarias.findById(id)
                .map( concessionaria -> {
                    concessionarias.delete(concessionaria );
                    return concessionaria;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Concessionaria não encontrado") );

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Concessionaria concessionaria ){
        concessionarias
                .findById(id)
                .map( concessionariaExistente -> {
                    concessionaria.setId(concessionariaExistente.getId());
                    concessionarias.save(concessionaria);
                    return concessionariaExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Concessionaria não encontrado") );
    }

    @GetMapping
    public List<Concessionaria> find( Concessionaria filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return concessionarias.findAll(example);
    }

}
