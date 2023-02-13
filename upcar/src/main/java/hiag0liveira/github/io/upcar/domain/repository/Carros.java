package hiag0liveira.github.io.upcar.domain.repository;

import hiag0liveira.github.io.upcar.domain.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Carros extends JpaRepository<Carro,Integer> {
}
