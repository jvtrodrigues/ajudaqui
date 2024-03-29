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
    public static String[] listDesc(){
        String [] todas = new String[3];
        int x = 0;
        for(Status a: Status.values()){
            todas[x] = a.desc;
            x++;
        }
        return todas;
    }
}

