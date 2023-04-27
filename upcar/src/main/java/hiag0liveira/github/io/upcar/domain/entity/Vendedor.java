package hiag0liveira.github.io.upcar.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table( name = "vendedores" )
public class Vendedor extends AbstractEntity{

    @Column(nullable=false)
    @NotBlank(message = "Por favor insira o nome do Usuario")
    @Size(min = 3, max = 255)
    private String nome;

    private String cpf;

    @Column(nullable = false)
    @NotNull(message = "Por favor insira um telefone valido")
    @NotBlank
    private String telefone;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id_fk")
    private Endereco endereco;

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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name= "data_entrada", nullable = false, columnDefinition = "DATE")
    private LocalDate dataEntrada;

    @JsonIgnore
    @OneToMany(mappedBy = "vendedor")
    private List<Agendamento> agendamentos;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Vendedor() {
        super();
    }
    public Vendedor(Long id) {
        super.setId(id);
    }
    public Vendedor(Usuario usuario) {
        this.usuario = usuario;
    }


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

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
