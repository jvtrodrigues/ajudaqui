package br.edu.ifrs.ajudaqui.domain;

public abstract class Usuario {
    private String id;
    private String nome;
    private String identificador;
    private String senha;
    private String email;

    public Usuario () {}

    public Usuario(String nome, String identificador, String senha, String email) {
        this.nome = nome;
        this.identificador = identificador;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(String id, String nome, String identificador, String senha, String email) {
        this.id = id;
        this.nome = nome;
        this.identificador = identificador;
        this.senha = senha;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
