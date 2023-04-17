package hiag0liveira.github.io.upcar.service;


import hiag0liveira.github.io.upcar.domain.entity.Cliente;
import hiag0liveira.github.io.upcar.domain.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositorio repositorioCliente;

    public ClienteService( ClienteRepositorio clientes ) {
        this.repositorioCliente = clientes;
    }

    public Cliente getClienteById(Long id){
        return repositorioCliente
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"));
    }

    public void Salvar(Cliente cliente ){
        repositorioCliente.save(cliente);
    }

    public void deleteClienteByID(Long id ){
        repositorioCliente.findById(id)
                .map( cliente -> {
                    repositorioCliente.delete(cliente );
                    return cliente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado") );
    }

    public void updateCliente(Cliente cliente ){
        repositorioCliente
                .findById(cliente.getId())
                .map( clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    repositorioCliente.save(cliente);
                    return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado") );
    }

    public List<Cliente> findAllClientes(){
        return repositorioCliente.findAll();
    }
}