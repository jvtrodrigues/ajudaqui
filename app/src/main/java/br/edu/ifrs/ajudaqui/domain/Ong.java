package br.edu.ifrs.ajudaqui.domain;
import java.util.ArrayList;
import java.util.List;

public class Ong extends Usuario {
    private String enderecoWeb;
    private String area;
    private Endereco endereco;
    List<Acao> acoes = new ArrayList<>();
    List<Avaliacao> avaliacoes = new ArrayList<>();

    public Ong(){}

    public Ong(String id, String nome, String identificador, String senha, String email, String enderecoWeb, String area, Endereco endereco) {
        super(id, nome, identificador, senha, email);
        this.enderecoWeb = enderecoWeb;
        this.area = area;
        this.endereco = endereco;
    }

    public Area getArea() {
        return Area.toEnum(area);
    }

    public void setArea(Area area) {
        this.area = area.getDesc();
    }

    public String getEnderecoWeb() {
        return enderecoWeb;
    }

    public void setEnderecoWeb(String enderecoWeb) {
        this.enderecoWeb = enderecoWeb;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Acao> getAcoes() {
        return acoes;
    }

    public void setAcoes(List<Acao> acoes) {
        this.acoes = acoes;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public void criarConta() {

    }

    @Override
    public Usuario logar() {
        return null;
    }

    @Override
    public void editarPerfil() {

    }

    @Override
    public String toString() {
        return "Ong{" +
                "enderecoWeb='" + enderecoWeb + '\'' +
                ", area='" + area + '\'' +
                ", endereco=" + endereco +
                ", acoes=" + acoes +
                ", avaliacoes=" + avaliacoes +
                '}';
    }
}
