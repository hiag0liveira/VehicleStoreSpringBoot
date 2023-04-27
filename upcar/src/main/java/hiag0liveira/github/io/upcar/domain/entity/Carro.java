package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

@Entity
@Table( name = "carro" )
public class Carro extends AbstractEntity {

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

    @NotNull(message = "O preço é requerido")
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    @Column(name = "preco_promocao", nullable = false)
    private BigDecimal preco;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "O numero da Placa do Carro é obrigatorio")
    private String placa;

    @Column(nullable = false)
    @NotBlank(message = "A quantidade de KM rodado no carro é obrigatório.")
    @Size (max = 100, message = "A quantidade de KM rodado deve ter no máximo 10 caracteres.")
    private String km_rodado;

    private String descricao;

    @Column(nullable = false)
    @NotBlank(message = "O ano de Fabricação do carro é obrigatório.")
    @Length(max = 4, message = "O ano do carro deve conter ate 4 digitos.")
    private String anoFabricacao;

//    @ManyToOne
//    @JoinColumn(nullable = false, name = "cliente_id_fk")
//    @NotNull(message = "Cliente obrigatório.")
//    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Tipo de combustivel é obrigatório.")
    private TipoCombustivel tipoCombustivel1;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCombustivel tipoCombustivel2;

    @NotBlank(message = "Uma imagem é requerida")
    private String linkImagem;

    public String getLinkImagem() {
        return linkImagem;
    }

    public void setLinkImagem(String linkImagem) {
        this.linkImagem = linkImagem;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
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

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
//
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }

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
