package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table( name = "vendedor" )
public class Vendedor extends Pessoa{

    @Column(name = "cargo",nullable=false, length = 40)
    private String cargo;

    @Column(name = "categoria")
    private String Categoria = "Vendedor";


    public Vendedor(String nome, String cpf, String email, String telefone,  String cargo) {
        super(nome, cpf,email, telefone);
        this.cargo = cargo;
    }

    public Vendedor() {

    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "cargo='" + cargo + '\'' +
                ", Categoria='" + Categoria + '\'' +
                '}';
    }
}
