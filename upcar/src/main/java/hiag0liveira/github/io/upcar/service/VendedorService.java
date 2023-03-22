package hiag0liveira.github.io.upcar.service;


import hiag0liveira.github.io.upcar.domain.entity.Vendedor;
import hiag0liveira.github.io.upcar.domain.repository.Vendedores;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VendedorService {

    private Vendedores vendedores;

    public VendedorService(Vendedores vendedores) {
        this.vendedores = vendedores;
    }

    public Vendedor getVendedorById(Integer id ){
        return vendedores
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Vendedor não encontrado"));
    }

    public Vendedor saveOneNewVendedor(Vendedor vendedor ){
        return vendedores.save(vendedor);
    }

    public void deleteVendedorByID(Integer id ){
        vendedores.findById(id)
                .map( vendedor -> {
                    vendedores.delete(vendedor );
                    return vendedor;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Vendedor encontrado") );

    }

    public void updateVendedor(Integer id, Vendedor vendedor ){
        vendedores
                .findById(id)
                .map( vendedorExistente -> {
                    vendedor.setId(vendedorExistente.getId());
                    vendedores.save(vendedor);
                    return vendedorExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Vendedor não encontrado") );
    }

    public List<Vendedor> findAllVendedores(){
        return vendedores.findAll();
    }
}