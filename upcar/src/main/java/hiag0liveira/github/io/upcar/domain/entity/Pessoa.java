package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table( name = "pessoa" )
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", nullable=false, length = 150)
    private String nome;

    @Column(name = "cpf",nullable=false, length = 14, unique =true, updatable=false)
    private String cpf;

    @Column(name = "email",nullable=false, length = 80, unique =true)
    private String email;

    @Column(name = "telefone",nullable=false, length = 11)
    private String telefone;


    @JoinColumn(name = "endereco_pessoa_id", referencedColumnName = "id", nullable = false)
    @OneToMany
    private List<Endereco> enderecos;

    public Pessoa(Integer id, String nome, String cpf, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public Pessoa() {

    }

    public Pessoa(String nome, String cpf, String email, String telefone) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
