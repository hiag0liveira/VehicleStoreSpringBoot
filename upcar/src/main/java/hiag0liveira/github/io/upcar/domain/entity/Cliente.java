package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table( name = "cliente" )
public class Cliente extends Pessoa{

    @Column(name = "categoria")
    private String Categoria = "Cliente";

    public Cliente(String nome, String cpf, String email, String telefone) {
        super(nome, cpf,email, telefone);
    }

    public Cliente() {

    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
}
