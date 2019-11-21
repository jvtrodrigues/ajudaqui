package br.edu.ifrs.ajudaqui.domain;

public class Acao {
    private int _id;
    private String descricao;
    private String status;

    public Acao(){}

    public Acao(int _id, String descricao, Status status) {
        this._id = _id;
        this.descricao = descricao;
        this.status = status.getDesc();
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return Status.toEnum(status);
    }

    public void setStatus(Status status) {
        this.status = status.getDesc();
    }
}
