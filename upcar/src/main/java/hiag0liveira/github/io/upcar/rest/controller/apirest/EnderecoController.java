package hiag0liveira.github.io.upcar.rest.controller.apirest;

import hiag0liveira.github.io.upcar.domain.entity.Endereco;
import hiag0liveira.github.io.upcar.domain.repository.Enderecos;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    private Enderecos enderecos;

    public EnderecoController(Enderecos enderecos ) {
        this.enderecos = enderecos;
    }

    @GetMapping("{id}")
    public Endereco getEnderecosById(@PathVariable Integer id ){
        return enderecos
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Endereco não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco save(@RequestBody Endereco endereco ){
        return enderecos.save(endereco);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        enderecos.findById(id)
                .map( endereco -> {
                    enderecos.delete(endereco );
                    return endereco;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Endereco não encontrado") );

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Endereco endereco ){
        enderecos
                .findById(id)
                .map( enderecoExistente -> {
                    endereco.setId(enderecoExistente.getId());
                    enderecos.save(endereco);
                    return enderecoExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Endereco não encontrado") );
    }

    @GetMapping
    public List<Endereco> find( Endereco filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return enderecos.findAll(example);
    }

}
