//package hiag0liveira.github.io.upcar.service;
//
//import hiag0liveira.github.io.upcar.domain.entity.Carro;
//import hiag0liveira.github.io.upcar.domain.repository.CarroRepositorio;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//
//@Service
//public class CarroService {
//
//    @Autowired
//    private CarroRepositorio carros;
//
//    public CarroService(CarroRepositorio carros) {
//        this.carros = carros;
//    }
//
//    public Carro getCarroById(Integer id ){
//        return carros
//                .findById(id)
//                .orElseThrow(() ->
//                        new ResponseStatusException(HttpStatus.NOT_FOUND,
//                                "Carro não encontrado"));
//    }
//
//    public Carro saveOneNewCarro(Carro carro ){
//        return carros.save(carro);
//    }
//
//    public void deleteCarroByID(Integer id ){
//        carros.findById(id)
//                .map( carro -> {
//                    carros.delete(carro );
//                    return carro;
//                })
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//                        "Carro não encontrado") );
//    }
//
//    public void updateCarro(Integer id, Carro carro ){
//        carros
//                .findById(id)
//                .map( carroExistente -> {
//                    carro.setId(carroExistente.getId());
//                    carros.save(carro);
//                    return carroExistente;
//                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//                        "Carro não encontrado") );
//    }
//
//    public List<Carro> findAllCarros(){
//        return carros.findAll();
//    }
//}
