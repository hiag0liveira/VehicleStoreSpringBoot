package hiag0liveira.github.io.upcar.domain.entity;

public enum TipoCombustivel {

    GASOLINA_COMUM("Gasolina Comum"),
    GASOLINA_ADITIVADA("Gasolina Aditivada"),
    GASOLINA_PREMIUM("Gasolina Premium"),
    GASOLINA_FORMULADA("Gasolina Formulada"),
    ETANOL("Etanol"),
    ETANOL_ADITIVADO("Gasolina Aditivado"),
    GNV("Gasolina GNV"),
    DIESEL("Diesel"),
    DIESEL_S10("Diesel_S10"),
    DIESEL_ADITIVADO("Diesel Aditivado"),
    DIESEL_PREMIUM("Diesel Premium"),
    ;

    private String tipoDoCombustivel;

    TipoCombustivel(String tipoDoCombustivel) {
        this.tipoDoCombustivel = tipoDoCombustivel;
    }

    public String getTipoDoCombustivel() {
        return tipoDoCombustivel;
    }
}