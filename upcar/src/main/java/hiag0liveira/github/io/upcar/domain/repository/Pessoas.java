package hiag0liveira.github.io.upcar.domain.repository;

import hiag0liveira.github.io.upcar.domain.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pessoas  extends JpaRepository<Pessoa,Integer> {
}
