package br.edu.ifrs.ajudaqui.domain;

public class Solidario extends Usuario {
    private String cpf;
    private String dataDeNascimento;

    public Solidario(){}

    public Solidario(String id, String nome, String identificador, String senha, String email, String cpf, String dataDeNascimento) {
        super(id, nome, identificador, senha, email);
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public String toString() {
        return "Solidario{" +
                "cpf='" + cpf + '\'' +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                '}';
    }
}
