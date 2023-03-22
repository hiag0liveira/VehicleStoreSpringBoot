package hiag0liveira.github.io.upcar.rest.controller.apirest;

import hiag0liveira.github.io.upcar.domain.entity.Carro;
import hiag0liveira.github.io.upcar.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/apirest/carro")
public class CarroController {

    private CarroService service;

    @GetMapping("{id}")
    public ResponseEntity OneCarroById(@PathVariable Integer id ){
        return ResponseEntity.ok(service.getCarroById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveNewCarro( @RequestBody Carro carro ){
        service.saveOneNewCarro(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(carro);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity OneDeleteCarroByID( @PathVariable Integer id ){
        service.deleteCarroByID(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity updateCarroByID( @PathVariable Integer id, @RequestBody Carro carro ){
        service.updateCarro(id , carro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity findAllCarros(){
        return ResponseEntity.ok(service.findAllCarros());
    }
}
