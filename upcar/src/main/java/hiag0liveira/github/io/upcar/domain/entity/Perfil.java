package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfis")
public class Perfil extends AbstractEntity {

    @Column(name = "descricao", nullable = false, unique = true)
    private String desc;

    public Perfil() {
        super();
    }

    public Perfil(Long id) {
        super.setId(id);
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
