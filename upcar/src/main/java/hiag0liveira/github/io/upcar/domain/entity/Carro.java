package hiag0liveira.github.io.upcar.domain.entity;

import hiag0liveira.github.io.upcar.annotation.PlacaCarroValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

@Entity
@Table( name = "carro" )
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "A Marca do carro é obrigatório.")
    @Size(max = 30, min = 3, message = "A quantidade de caracter em marca deve ter entre deve ter entre 3 a 30 caracteres.")
    private String marca;

    @Column(nullable = false)
    @NotBlank(message = "o Modelo do carro é obrigatório.")
    @Size(max = 40, min = 3, message = "A quantidade de caracter em modelo deve ter entre deve ter entre 3 a 40 caracteres.")
    private String modelo;

    @Column(nullable = false)
    @NotBlank(message = "A cor do carro é obrigatório.")
    @Size(max = 30, min = 3, message = "A quantidade de caracter em cor deve ter entre deve ter entre 3 a 30 caracteres.")
    private String cor;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "O numero da Placa do Carro é obrigatorio")
    @PlacaCarroValidation
    private String placa;

    @Column(nullable = false)
    @NotBlank(message = "A quantidade de KM rodado no carro é obrigatório.")
    @Size (max = 100, message = "A quantidade de KM rodado deve ter no máximo 10 caracteres.")
    private String km_rodado;

    @Size(max = 255, message = "A descrição adicional do carro deve ter no máximo 255 caracteres.")
    private String descricao;

    @Column(nullable = false)
    @NotBlank(message = "O ano de Fabricação do carro é obrigatório.")
    @Length(max = 4, message = "O ano do carro deve conter ate 4 digitos.")
    private int anoFabricacao;

    @ManyToOne
    @JoinColumn(nullable = false, name = "cliente_id_fk")
    @NotNull(message = "Cliente obrigatório.")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Tipo de combustivel é obrigatório.")
    private TipoCombustivel tipoCombustivel1;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCombustivel tipoCombustivel2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getKm_rodado() {
        return km_rodado;
    }

    public void setKm_rodado(String km_rodado) {
        this.km_rodado = km_rodado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoCombustivel getTipoCombustivel1() {
        return tipoCombustivel1;
    }

    public void setTipoCombustivel1(TipoCombustivel tipoCombustivel1) {
        this.tipoCombustivel1 = tipoCombustivel1;
    }

    public TipoCombustivel getTipoCombustivel2() {
        return tipoCombustivel2;
    }

    public void setTipoCombustivel2(TipoCombustivel tipoCombustivel2) {
        this.tipoCombustivel2 = tipoCombustivel2;
    }
}
