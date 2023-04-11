package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Embeddable
public class Telefone implements Serializable{
    private static final long serialVersionUID = 1L;

    @Column(length = 14, nullable = false)
    @NotBlank(message = "Número de telefone obrigatório.")
    @Length(min=13, max = 14, message = "Telefone deve ter 13 ou 14 caracteres (Ex: (99)9999-9999 ou (99)99999-9999")
    private String numero;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}