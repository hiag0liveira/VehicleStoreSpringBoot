package hiag0liveira.github.io.upcar.domain.entity;

public enum PerfilTipo {
    ADMIN(1, "ADMIN"),
    VENDEDOR(2, "VENDEDOR");

    private long cod;
    private String desc;

    private PerfilTipo(long cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public long getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
