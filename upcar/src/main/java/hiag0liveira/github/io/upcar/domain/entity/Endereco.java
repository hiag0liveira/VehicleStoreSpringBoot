package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

@Entity
@Table( name = "endereco" )
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String logradouro;

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String bairro;

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String cidade;

    @NotNull(message = "{NotNull.endereco.uf}")
    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private UF uf;

    @NotBlank
    @Size(min = 9, max = 9, message = "{Size.endereco.cep}")
    @Column(nullable = false, length = 9)
    private String cep;

    @NotNull(message = "{NotNull.endereco.numero}")
    @Digits(integer = 5, fraction = 0)
    @Column(nullable = false, length = 5)
    private Integer numero;

    @Size(max = 255)
    private String complemento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
