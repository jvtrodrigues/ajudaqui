package br.edu.ifrs.ajudaqui.domain;

public class Endereco {
    private String id;
    private int cep;
    private String rua;
    private int numero;
    private String idOng;

    public Endereco (){}

    public Endereco(int cep, String rua, int numero) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
    }

    public Endereco(int cep, String rua, int numero, String idOng) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.idOng = idOng;
    }

    public Endereco(String id, int cep, String rua, int numero, String idOng) {
        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.idOng = idOng;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIdOng() {
        return idOng;
    }

    public void setIdOng(String idOng) {
        this.idOng = idOng;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id='" + id + '\'' +
                ", cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
