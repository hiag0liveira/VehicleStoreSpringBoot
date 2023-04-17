package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table( name = "vendedor" )
public class Vendedor extends Pessoa{

    @Column(name = "cargo",nullable=false, length = 40)
    @NotBlank(message = "Cargo obrigatório.")
    @Length(max = 50, message = "O cargo deve ter no máximo 40 caracteres.")
    private String cargo;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "Setor obrigatório.")
    @Length(max = 50, message = "Setor deve ter no máximo 50 caracteres.")
    private String setor;

    @NotNull
    @PastOrPresent(message = "A data de entrada tem que ser valida")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "")
    @Column(name= "data_entrada", nullable = false, columnDefinition = "DATE")
    private LocalDate dataEntrada;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_saida", columnDefinition = "DATE")
    private LocalDate dataSaida;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }
}
