package hiag0liveira.github.io.upcar.service;


import hiag0liveira.github.io.upcar.domain.entity.Cliente;
import hiag0liveira.github.io.upcar.domain.entity.Vendedor;
import hiag0liveira.github.io.upcar.domain.repository.VendedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepositorio vendedorRepository;

    @Transactional(readOnly = true)
    public Vendedor buscarPorUsuarioId(Long id) {

        return vendedorRepository.findByUsuarioId(id).orElse(new Vendedor());
    }

    @Transactional(readOnly = false)
    public void salvar(Vendedor vendedor) {

        vendedorRepository.save(vendedor);
    }

    @Transactional(readOnly = false)
    public void editar(Vendedor vendedor) {
        Vendedor vendedorEditado = vendedorRepository.findById(vendedor.getId()).get();
        vendedorEditado.setNome(vendedor.getNome());
        vendedorEditado.setCpf(vendedor.getCpf());
        vendedorEditado.setTelefone(vendedor.getTelefone());
        vendedorEditado.setEndereco(vendedor.getEndereco());
        vendedorEditado.setCargo(vendedor.getCargo());
        vendedorEditado.setSetor(vendedor.getSetor());
        vendedorEditado.setDataEntrada(vendedor.getDataEntrada());
    }

    @Transactional(readOnly = true)
    public Vendedor buscarPorEmail(String email) {

        return vendedorRepository.findByUsuarioEmail(email).orElse(new Vendedor());
    }

    public List<Vendedor> findAllVendedores(){
        return vendedorRepository.findAll();
    }

}