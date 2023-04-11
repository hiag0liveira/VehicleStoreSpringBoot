package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table( name = "endereco" )
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "rua", length = 120)
    @NotBlank(message = "Rua obrigatória.")
    @Length(max = 200, message = "Rua deve ter no máximo 120 caracteres.")
    private String rua;

    @Column(name = "numero")
    @Digits(integer = 4, fraction = 0, message = "Número deve ser inteiro e ter até 4 digitos.")
    private String numero;

    @Column(name = "cep", length = 9)
    @Length(min = 9, max = 9, message = "CEP deve ter exatamente 9 caracteres (Ex: 99999-999).")
    private String cep;

    @Column(name = "complemento", length = 50)
    @Length(max = 200, message = "O complemento deve ter no máximo 120 caracteres.")
    private String complemento;

    @NotBlank(message = "Cidade obrigatória.")
    @Length(max = 50, message = "Cidade deve ter no máximo 50 caracteres.")
    @Column(name = "cidade", length = 50)
    private String cidade;

    @NotBlank(message = "Bairro obrigatório.")
    @Length(max = 50, message = "Bairro deve ter no máximo 50 caracteres.")
    @Column(name = "bairro", length = 50)
    private String bairro;

    @Column(name = "estado", length = 50)
    @NotBlank(message = "Estado obrigatório.")
    private String estado;

    public Endereco(Integer id, String rua, String numero, String cep, String complemento, String cidade, String bairro, String estado) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
    }

    public Endereco() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
