package hiag0liveira.github.io.upcar.domain.entity;

import hiag0liveira.github.io.upcar.annotation.PlacaCarroValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table( name = "carro" )
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100, nullable = false)
    @NotBlank(message = "Nome obrigatório.")
    @Length(max = 100, message = "Nome deve ter no máximo 150 caracteres.")
    private String nome;

    @Column(name = "marca", length = 50)
    @NotBlank(message = "A Marca do carro é obrigatório.")
    @Length(max = 50, message = "A marca deve ter no máximo 50 caracteres.")
    private String marca;

    @Column(name = "modelo", length = 100)
    @NotBlank(message = "o Modelo do carro é obrigatório.")
    @Length(max = 100, message = "O modelo deve ter no máximo 100 caracteres.")
    private String modelo;

    @Column(name = "cor", length = 100)
    @NotBlank(message = "A cor do carro é obrigatório.")
    @Length(max = 100, message = "A cor deve ter no máximo 100 caracteres.")
    private String cor;

    @Column(name = "placa", length = 8)
    @PlacaCarroValidation
    private String placa;

    @Column(name = "km_rodado", length = 10)
    @NotBlank(message = "A quantidade de KM rodado no carro é obrigatório.")
    @Length(max = 100, message = "A quantidade de KM rodado deve ter no máximo 10 caracteres.")
    private String km_rodado;

    @Column(name = "descricao", length = 300)
    @Length(max = 300, message = "A descrição adicional do carro deve ter no máximo 300 caracteres.")
    private String descricao;

    @Column(name = "anoFabricacao")
    @NotBlank(message = "A cor do carro é obrigatório.")
    @Length(max = 4, message = "O ano do carro deve conter ate 4 digitos.")
    private int anoFabricacao;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotNull(message = "Cliente obrigatório.")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotNull(message = "Funcionario obrigatório.")
    private Vendedor vendedor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoCombustivel")
    @NotNull(message = "Tipo do quarto é obrigatório.")
    private TipoCombustivelEnum tipoCombustivelEnum;

    public Carro(String nome, String marca, String modelo, String cor, String placa, String km_rodado, String descricao, int anoFabricacao, Cliente cliente, Vendedor vendedor, TipoCombustivelEnum tipoCombustivelEnum) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.km_rodado = km_rodado;
        this.descricao = descricao;
        this.anoFabricacao = anoFabricacao;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.tipoCombustivelEnum = tipoCombustivelEnum;
    }

    public Carro() {

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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public TipoCombustivelEnum getTipoCombustivelEnum() {
        return tipoCombustivelEnum;
    }

    public void setTipoCombustivelEnum(TipoCombustivelEnum tipoCombustivelEnum) {
        this.tipoCombustivelEnum = tipoCombustivelEnum;
    }
}
