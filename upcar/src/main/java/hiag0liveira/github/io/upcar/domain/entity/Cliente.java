package hiag0liveira.github.io.upcar.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "cliente" )
public class Cliente extends Pessoa{

    @Column(length = 200)
    @Length(max = 200, message = "Documentos deve ter no máximo 200 caracteres.")
    private String documentos;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Carro> carros = new ArrayList<>();


    public Cliente(String nome, String cpf, String email, List<Telefone> telefones, List<Endereco> enderecos, String documentos, List<Carro> carros) {
        super(nome, cpf, email, telefones, enderecos);
        this.documentos = documentos;
        this.carros = carros;
    }

    public Cliente(String nome, String cpf, String email, String telefone, String documentos, List<Carro> carros) {
        super(nome, cpf, email, telefone);
        this.documentos = documentos;
        this.carros = carros;
    }

    public Cliente() {
        super();
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
