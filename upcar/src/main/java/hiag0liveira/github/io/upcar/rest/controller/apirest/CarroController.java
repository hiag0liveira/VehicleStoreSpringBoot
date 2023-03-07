package hiag0liveira.github.io.upcar.rest.controller.apirest;

import hiag0liveira.github.io.upcar.domain.entity.Carro;
import hiag0liveira.github.io.upcar.domain.repository.Carros;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping ("/api/carro")
public class CarroController {

    private Carros carros;

    public CarroController(Carros carros) {
        this.carros = carros;
    }

    @GetMapping("{id}")
    public Carro getCarroById(@PathVariable Integer id ){
        return carros
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Carro não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carro save( @RequestBody Carro carro ){
        return carros.save(carro);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        carros.findById(id)
                .map( carro -> {
                    carros.delete(carro );
                    return carro;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Carro não encontrado") );

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Carro carro ){
        carros
                .findById(id)
                .map( carroExistente -> {
                    carro.setId(carroExistente.getId());
                    carros.save(carro);
                    return carroExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Carro não encontrado") );
    }

    @GetMapping
    public List<Carro> find(Carro filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return carros.findAll(example);
    }
}
