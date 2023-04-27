package hiag0liveira.github.io.upcar.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios", indexes = {@Index(name = "idx_usuario_email", columnList = "email")})
public class Usuario extends AbstractEntity {

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "codigo_verificador", length = 6)
    private String codigoVerificador;

    @ManyToMany
    @JoinTable(
            name = "usuarios_tem_perfis",
            joinColumns = { @JoinColumn(name = "usuario_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "perfil_id", referencedColumnName = "id") }
    )
    private List<Perfil> perfis;

    @Column(name = "ativo", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean ativo;

    public void addPerfil(PerfilTipo tipo) {
        if (this.perfis == null) {
            this.perfis = new ArrayList<>();
        }
        this.perfis.add(new Perfil(tipo.getCod()));
    }

    public Usuario() {
        super();
    }

    public Usuario(Long id) {
        super.setId(id);
    }
    public Usuario(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getCodigoVerificador() {
        return codigoVerificador;
    }

    public void setCodigoVerificador(String codigoVerificador) {
        this.codigoVerificador = codigoVerificador;
    }
}
