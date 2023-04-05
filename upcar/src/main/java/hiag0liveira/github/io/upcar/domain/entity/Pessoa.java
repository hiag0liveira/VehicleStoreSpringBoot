package hiag0liveira.github.io.upcar.domain.entity;

import hiag0liveira.github.io.upcar.annotation.EmailValidation;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
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
    @NotBlank(message = "Por favor insira o nome do Usuario")
    @Length(max = 150, message = "Nome deve ter no máximo 150 caracteres.")
    private String nome;

    @Column(name = "cpf",nullable=false, length = 14, unique =true, updatable=false)
    @CPF(message = "CPF inválido.")
    @NotNull(message = "Por favor insira um CPF valido")
    private String cpf;

    @Column(name = "email",nullable=false, length = 80, unique =true)
    @EmailValidation(message = "Email inválido.")
    private String email;

    @ElementCollection
    @Valid
    private List<Telefone> telefones = new ArrayList<>();


    @JoinColumn(name = "endereco_pessoa_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Endereço obrigatório.")
    @OneToMany
    private List<Endereco> enderecos;

    public Pessoa(Integer id, String nome, String cpf, String email, List<Telefone> telefones, List<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefones = telefones;
        this.enderecos = enderecos;
    }

    public Pessoa() {

    }

    public Pessoa(String nome, String cpf, String email, String telefone) {
    }

    public Pessoa(String nome, String cpf, String email, List<Telefone> telefones, List<Endereco> enderecos) {
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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

}
