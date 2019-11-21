package br.edu.ifrs.ajudaqui.domain;

public enum Classificacao {
    RUIM("Ruim"),
    A_MELHORAR("À melhorar"),
    BOA("Boa"),
    EXEMPLAR("Exemplar");
    private String desc;

    private Classificacao(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static Classificacao toEnum(String cod) {
        if(cod == null) {
            return null;
        }

        for(Classificacao x : Classificacao.values()) {
            if(cod.equals(x.getDesc())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Desc inválida: " + cod);
    }
}
