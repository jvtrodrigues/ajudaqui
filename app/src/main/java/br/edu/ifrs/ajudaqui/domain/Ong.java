package br.edu.ifrs.ajudaqui.domain;
import java.util.ArrayList;
import java.util.List;

public class Ong extends Usuario {
    private String enderecoWeb;
    private AreaOng areaOng;
    private int cep;
    private String rua;
    private int numero;
    List<Acao> acoes = new ArrayList<>();
    List<Avaliacao> avaliacoes = new ArrayList<>();

    public Ong() {
    }

    public Ong(String nome, String identificador, String senha, String email, String enderecoWeb, AreaOng areaOng, int cep, String rua, int numero) {
        super(nome, identificador, senha, email);
        this.enderecoWeb = enderecoWeb;
        this.areaOng = areaOng;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
    }

    public Ong(String id, String nome, String identificador, String senha, String email, String enderecoWeb, AreaOng areaOng, int cep, String rua, int numero) {
        super(id, nome, identificador, senha, email);
        this.enderecoWeb = enderecoWeb;
        this.areaOng = areaOng;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public AreaOng getAreaOng() {
        return areaOng;
    }

    public void setAreaOng(AreaOng areaOng) {
        this.areaOng = areaOng;
    }

    public String getEnderecoWeb() {
        return enderecoWeb;
    }

    public void setEnderecoWeb(String enderecoWeb) {
        this.enderecoWeb = enderecoWeb;
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
    public String toString() {
        return "Ong{" +
                "enderecoWeb='" + enderecoWeb + '\'' +
                ", areaOng=" + areaOng +
                ", cep=" + cep +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", acoes=" + acoes +
                ", avaliacoes=" + avaliacoes +
                '}';
    }
}