package br.edu.ifrs.ajudaqui.domain;

public class Avaliacao {
    private int _id;
    private String comentario;
    private String classificacao;

    public Avaliacao(){}

    public Avaliacao(int _id, String comentario, Classificacao classificacao) {
        this._id = _id;
        this.comentario = comentario;
        this.classificacao = classificacao.getDesc();
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Classificacao getClassificacao() {
        return Classificacao.toEnum(classificacao);
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao.getDesc();
    }
}
