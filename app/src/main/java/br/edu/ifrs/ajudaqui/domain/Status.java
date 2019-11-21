package br.edu.ifrs.ajudaqui.domain;

public enum Status {
    EM_ABERTO("Em aberto"), ATINGIDA("Atingida"), CANCELADA("Cancelada");

    private String desc;

    private Status(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static Status toEnum(String cod) {
        if(cod == null) {
            return null;
        }

        for(Status x : Status.values()) {
            if(cod.equals(x.getDesc())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Desc inválida: " + cod);
    }
}
