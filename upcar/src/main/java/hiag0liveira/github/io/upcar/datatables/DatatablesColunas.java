package hiag0liveira.github.io.upcar.datatables;

public class DatatablesColunas {

    public static final String[] CARROS = {"id", "molelo"};

    public static final String[] VENDEDOR = {"id", "nome"};

    public static final String[] AGENDAMENTOS = {"id", "cliente.nome", "dataReuniao", "vendedor.nome"};

    public static final String[] USUARIOS = {"id", "email", "ativo", "perfis"};
}