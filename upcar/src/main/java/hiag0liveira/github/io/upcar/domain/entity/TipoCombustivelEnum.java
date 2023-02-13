package hiag0liveira.github.io.upcar.domain.entity;

public enum TipoCombustivelEnum{
    GASOLINA_COMUM{

        @Override
        public String obterNomeCombustivel() {
            String tipoDoCombustivel = "Gasolina Comum";
            return tipoDoCombustivel;
        }

    },
    GASOLINA_ADITIVADA{

        @Override
        public String obterNomeCombustivel() {
            String tipoDoCombustivel = "Gasolina Aditivada";
            return tipoDoCombustivel;
        }

    },
    GASOLINA_PREMIUM{

        @Override
        public String obterNomeCombustivel() {
            String tipoDoCombustivel = "Gasolina Premium";
            return tipoDoCombustivel;
        }

    },
    GASOLINA_FORMULADA{

        @Override
        public String obterNomeCombustivel() {
            String tipoDoCombustivel = "Gasolina Formulada";
            return tipoDoCombustivel;
        }

    },
    ETANOL{

        @Override
        public String obterNomeCombustivel() {
            String tipoDoCombustivel = "Gasolina Etanol";
            return tipoDoCombustivel;
        }

    },
    ETANOL_ADITIVADO{

        @Override
        public String obterNomeCombustivel() {
            String tipoDoCombustivel = "Etanol Aditivado";
            return tipoDoCombustivel;
        }

    },
    GNV{

        @Override
        public String obterNomeCombustivel() {
            String tipoDoCombustivel = "GNV";
            return tipoDoCombustivel;
        }

    },
    DIESEL{

        @Override
        public String obterNomeCombustivel() {
            String tipoDoCombustivel = "Diesel";
            return tipoDoCombustivel;
        }

    },
    DIESEL_S10{

        @Override
        public String obterNomeCombustivel() {
            String tipoDoCombustivel = "Diesel S-10";
            return tipoDoCombustivel;
        }

    },
    DIESEL_ADITIVADO{

        @Override
        public String obterNomeCombustivel() {
            String tipoDoCombustivel = "Diesel Aditivado";
            return tipoDoCombustivel;
        }

    },
    DIESEL_PREMIUM{

        @Override
        public String obterNomeCombustivel() {
            String tipoDoCombustivel = "Diesel Premium";
            return tipoDoCombustivel;
        }

    };

    public abstract String obterNomeCombustivel();
}