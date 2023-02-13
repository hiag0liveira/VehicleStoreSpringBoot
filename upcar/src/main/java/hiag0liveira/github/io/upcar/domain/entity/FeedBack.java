package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table( name = "feedBack" )
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "assunto")
    private String Assunto;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_pedido")
    private LocalDate dataFeedbacl;

    public FeedBack(Integer id, String assunto, String descricao, LocalDate dataFeedbacl) {
        this.id = id;
        Assunto = assunto;
        this.descricao = descricao;
        this.dataFeedbacl = dataFeedbacl;
    }

    public FeedBack() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssunto() {
        return Assunto;
    }

    public void setAssunto(String assunto) {
        Assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataFeedbacl() {
        return dataFeedbacl;
    }

    public void setDataFeedbacl(LocalDate dataFeedbacl) {
        this.dataFeedbacl = dataFeedbacl;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "id=" + id +
                ", Assunto='" + Assunto + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataFeedbacl=" + dataFeedbacl +
                '}';
    }
}
