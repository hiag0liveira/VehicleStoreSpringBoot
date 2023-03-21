package hiag0liveira.github.io.upcar.service;


import hiag0liveira.github.io.upcar.domain.entity.Cliente;
import hiag0liveira.github.io.upcar.domain.repository.Clientes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    private Clientes clientes;

    public ClienteService( Clientes clientes ) {
        this.clientes = clientes;
    }

    public Cliente getClienteById(Integer id){
        return clientes
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"));
    }


    public Cliente saveOneNewCliente( Cliente cliente ){
        return clientes.save(cliente);
    }

    public void deleteClienteByID(Integer id ){
        clientes.findById(id)
                .map( cliente -> {
                    clientes.delete(cliente );
                    return cliente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado") );

    }

    public void updateCliente(  Integer id, Cliente cliente ){
        clientes
                .findById(id)
                .map( clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clientes.save(cliente);
                    return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado") );
    }

    @GetMapping
    public List<Cliente> findAllClientes(){
        return clientes.findAll();
    }
}