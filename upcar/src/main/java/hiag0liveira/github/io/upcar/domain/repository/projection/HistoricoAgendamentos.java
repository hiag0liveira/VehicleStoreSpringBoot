package hiag0liveira.github.io.upcar.domain.repository.projection;

import hiag0liveira.github.io.upcar.domain.entity.Cliente;
import hiag0liveira.github.io.upcar.domain.entity.Vendedor;

public interface HistoricoAgendamentos {

    Long getId();

    Cliente getCliente();

    String getDataReuniao();

    Vendedor getVendedor();
}
