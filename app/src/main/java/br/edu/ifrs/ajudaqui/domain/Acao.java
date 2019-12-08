package br.edu.ifrs.ajudaqui.domain;

public class Acao {
    private String id;
    private String descricao;
    private Status status;

    public Acao() {
    }

    public Acao(String descricao, Status status) {
        this.descricao = descricao;
        this.status = status;
    }

    public Acao(String id, String descricao, Status status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}