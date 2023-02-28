package hiag0liveira.github.io.upcar.rest.controller;

import hiag0liveira.github.io.upcar.domain.entity.Carro;
import hiag0liveira.github.io.upcar.domain.entity.FeedBack;
import hiag0liveira.github.io.upcar.domain.repository.Carros;
import hiag0liveira.github.io.upcar.domain.repository.FeedBacks;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping ("/api/feedBack")
public class FeedBackController {

    private FeedBacks feedBacks;

    public FeedBackController(FeedBacks feedBacks) {
        this.feedBacks = feedBacks;
    }

    @GetMapping("{id}")
    public FeedBack getFeedBackById(@PathVariable Integer id ){
        return feedBacks
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "FeedBack não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FeedBack save( @RequestBody FeedBack feedBack ){
        return feedBacks.save(feedBack);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        feedBacks.findById(id)
                .map( feedBack -> {
                    feedBacks.delete(feedBack );
                    return feedBack;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "FeedBack não encontrado") );

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody FeedBack feedBack ){
        feedBacks
                .findById(id)
                .map( FeedBackExistente -> {
                    feedBack.setId(FeedBackExistente.getId());
                    feedBacks.save(feedBack);
                    return FeedBackExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "FeedBack não encontrado") );
    }

    @GetMapping
    public List<FeedBack> find(FeedBack filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return feedBacks.findAll(example);
    }
}
