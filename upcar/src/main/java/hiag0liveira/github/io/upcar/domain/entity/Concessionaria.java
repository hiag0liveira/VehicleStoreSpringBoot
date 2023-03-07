package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.*;

@Entity
@Table( name = "concessionaria" )
public class Concessionaria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "concessionaria_endereco_id")
    private Endereco endereco;

    @Column(name = "nome", nullable=false, length = 150)
    private String nome;

    @Column(name = "cnpj", length = 20, nullable = false)
    private String cnpj;
    
    public Concessionaria(Endereco endereco, String nome, String cnpj) {
        this.endereco = endereco;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Concessionaria() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Concessionaria{" +
                "id=" + id +
                ", endereco=" + endereco +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
