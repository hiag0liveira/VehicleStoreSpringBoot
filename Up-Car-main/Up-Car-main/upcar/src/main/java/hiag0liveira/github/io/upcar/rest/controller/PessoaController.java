package hiag0liveira.github.io.upcar.rest.controller;

import hiag0liveira.github.io.upcar.domain.entity.Carro;
import hiag0liveira.github.io.upcar.domain.entity.Pessoa;
import hiag0liveira.github.io.upcar.domain.repository.Carros;
import hiag0liveira.github.io.upcar.domain.repository.Pessoas;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping ("/api/pessoa")
public class PessoaController {

    private Pessoas pessoas;

    public PessoaController(Pessoas pessoas) {
        this.pessoas = pessoas;
    }

    @GetMapping("{id}")
    public Pessoa getPessoaById(@PathVariable Integer id ){
        return pessoas
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Pessoa não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa save( @RequestBody Pessoa pessoa ){
        return pessoas.save(pessoa);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        pessoas.findById(id)
                .map( pessoa -> {
                    pessoas.delete(pessoa );
                    return pessoa;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Pessoa não encontrado") );

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Pessoa pessoa ){
        pessoas
                .findById(id)
                .map( pessoaExistente -> {
                    pessoa.setId(pessoaExistente.getId());
                    pessoas.save(pessoa);
                    return pessoaExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Pessoa não encontrado") );
    }

    @GetMapping
    public List<Pessoa> find(Pessoa filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return pessoas.findAll(example);
    }
}
