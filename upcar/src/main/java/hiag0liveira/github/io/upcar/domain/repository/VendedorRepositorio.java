package hiag0liveira.github.io.upcar.domain.repository;

import hiag0liveira.github.io.upcar.domain.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VendedorRepositorio extends JpaRepository<Vendedor, Long> {

    @Query("select v from Vendedor v where v.usuario.id = :id")
    Optional<Vendedor> findByUsuarioId(Long id);

    @Query("select v from Vendedor v where v.usuario.email like :email")
    Optional<Vendedor> findByUsuarioEmail(String email);

}
