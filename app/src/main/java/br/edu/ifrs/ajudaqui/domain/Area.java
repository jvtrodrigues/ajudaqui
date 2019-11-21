package br.edu.ifrs.ajudaqui.domain;

public enum Area {
    ASSISTENCIA_SOCIAL("Assistência Social"), CULTURA("Cultura"), SAUDE("Saúde"), MEIO_AMBIENTE("Meio Ambiente"), DEFESA_DIREITOS("Defesa de Direitos"), EDUCACAO("Educação"), HABITACAO("Habitação");
    private String desc;

    private Area(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static Area toEnum(String cod) {
        if(cod == null) {
            return null;
        }

        for(Area x : Area.values()) {
            if(cod.equals(x.getDesc())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Desc inválida: " + cod);
    }
}
