package hiag0liveira.github.io.upcar.domain.entity;

public enum TipoCliente {

     PF("Pessoa Física"),
     PJ("Pessoa Jurídica");

    private String tipo;

    TipoCliente(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
