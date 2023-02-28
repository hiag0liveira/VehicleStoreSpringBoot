package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.*;

@Entity
@Table( name = "carro" )
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "cor")
    private String cor;

    @Column(name = "placa")
    private String placa;

    @Column(name = "km_rodado")
    private String km_rodado;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "anoFabricacao")
    private int anoFabricacao;

    @Column(name = "anoModelo")
    private int anoModelo;

    @Column(name = "tipoCombustivel")
    private TipoCombustivelEnum tipoCombustivelEnum;

    public Carro(String nome, String marca, String modelo, String cor, String placa, String km_rodado, String descricao,
            int anoFabricacao, int anoModelo, TipoCombustivelEnum tipoCombustivelEnum) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.km_rodado = km_rodado;
        this.descricao = descricao;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
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

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public TipoCombustivelEnum getTipoCombustivelEnum() {
        return tipoCombustivelEnum;
    }

    public void setTipoCombustivelEnum(TipoCombustivelEnum tipoCombustivelEnum) {
        this.tipoCombustivelEnum = tipoCombustivelEnum;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cor='" + cor + '\'' +
                ", placa='" + placa + '\'' +
                ", km_rodado='" + km_rodado + '\'' +
                ", descricao='" + descricao + '\'' +
                ", anoFabricacao=" + anoFabricacao +
                ", anoModelo=" + anoModelo +
                ", tipoCombustivelEnum=" + tipoCombustivelEnum +
                '}';
    }
}
