package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Cliente extends AbstractEntity{

    @Column(nullable=false)
    @NotBlank(message = "Por favor insira o nome do Usuario")
    @Size(min = 3, max = 255)
    private String nome;

    private String cpf;

    private String cnpj;

    @Column(nullable = false)
    @NotNull(message = "Por favor insira um telefone valido")
    @NotBlank
    private String telefone;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id_fk")
    private Endereco endereco;

    @NotNull(message = "Selecione um Tipo")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCliente tipoCliente;

    @Column(name = "email")//    @OneToMany(mappedBy = "cliente")
//    private List<Carro> carros;

    @Email(message = "E-mail inválido.")
    @NotNull(message = "Por favor insira um E-mail valido")
    @NotBlank
    private String email;


    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

//    public List<Carro> getCarros() {
//        return carros;
//    }
//
//    public void setCarros(List<Carro> carros) {
//        this.carros = carros;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
