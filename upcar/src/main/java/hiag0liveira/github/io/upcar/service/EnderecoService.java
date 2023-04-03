package hiag0liveira.github.io.upcar.service;

import hiag0liveira.github.io.upcar.domain.entity.Endereco;
import hiag0liveira.github.io.upcar.domain.repository.Enderecos;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EnderecoService {

    private Enderecos enderecos;

    public EnderecoService( Enderecos enderecos ) {
        this.enderecos = enderecos;
    }

    public Endereco getEnderecoById(Integer id ){
        return enderecos
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Endereco não encontrado"));
    }

    public Endereco saveOneNewEndereco(Endereco endereco ){
        return enderecos.save(endereco);
    }

    public void deleteEnderecoByID(Integer id ){
        enderecos.findById(id)
                .map( endereco -> {
                    enderecos.delete(endereco );
                    return endereco;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Endereco não encontrado") );

    }

    public void updateEndereco(Integer id, Endereco endereco ){
        enderecos
                .findById(id)
                .map( enderecoExistente -> {
                    endereco.setId(enderecoExistente.getId());
                    enderecos.save(endereco);
                    return enderecoExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Endereco não encontrado") );
    }

    public List<Endereco> findAllEnderecos(){
        return enderecos.findAll();
    }

}
