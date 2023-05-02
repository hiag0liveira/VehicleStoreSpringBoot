package hiag0liveira.github.io.upcar.service;

import hiag0liveira.github.io.upcar.domain.entity.Carro;
import hiag0liveira.github.io.upcar.domain.repository.CarroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepositorio carroRepositorio;

    public CarroService(CarroRepositorio carros) {
        this.carroRepositorio = carros;
    }

    public Carro getCarroById(Long id ){
        return carroRepositorio
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Carro não encontrado"));
    }

    public Carro Salvar(Carro carro ){
        return carroRepositorio.save(carro);
    }

    public void deleteCarroByID(Long id ){
        carroRepositorio.findById(id)
                .map( carro -> {
                    carroRepositorio.delete(carro );
                    return carro;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Carro não encontrado") );
    }

    public void updateCarro(Carro carro ){
        carroRepositorio
                .findById(carro.getId())
                .map( carroExistente -> {
                    carro.setId(carroExistente.getId());
                    carroRepositorio.save(carro);
                    return carroExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Carro não encontrado") );
    }

    public List<Carro> findAllCarros(){
        return carroRepositorio.findAll();
    }
}
