package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table( name = "cliente" )
public class Cliente extends Pessoa{

    @Column(name = "categoria", nullable=false, length = 130)
    private String Categoria = "Cliente";

    public Cliente(String nome, String cpf, String email, String telefone, String categoria) {
        super(nome, cpf, email, telefone);
        Categoria = categoria;
    }

    public Cliente() {
        super();
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
}
