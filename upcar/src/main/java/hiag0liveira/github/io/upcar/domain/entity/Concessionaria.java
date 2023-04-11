package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "concessionaria" )
public class Concessionaria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Nome obrigatório.")
    @Length(max = 100, message = "Nome deve ter no máximo 50 caracteres.")
    private String nome;

    @Column(name = "cnpj", length = 20, nullable = false)
    @CNPJ(message = "CPNJ inválido.")
    private String cnpj;

    @ManyToOne
    @JoinColumn(name = "concessionaria_endereco_id")
    @NotNull(message = "Endereço obrigatório.")
    @Valid
    private Endereco endereco;

    @ElementCollection
    @Valid
    private List<Telefone> telefones;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(nullable = false, name = "hotel_id")
    @Size(min = 1, message = "A concessioria deve ter pelo menos um Carro")
    @Valid
    private List<Carro> carros= new ArrayList<>();

    public Concessionaria(String nome, String cnpj, Endereco endereco, List<Telefone> telefones, List<Carro> carros) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefones = telefones;
        this.carros = carros;
    }

    public Concessionaria() {

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
