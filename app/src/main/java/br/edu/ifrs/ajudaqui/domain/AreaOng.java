package br.edu.ifrs.ajudaqui.domain;

public enum AreaOng {
    ASSISTENCIA_SOCIAL("Assistência Social"), CULTURA("Cultura"), SAUDE("Saúde"), MEIO_AMBIENTE("Meio Ambiente"), DEFESA_DIREITOS("Defesa de Direitos"), EDUCACAO("Educação"), HABITACAO("Habitação");
    private String desc;

    private AreaOng(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }


    public static AreaOng toEnum(String cod) {
        if(cod == null) {
            return null;
        }

        for(AreaOng x : AreaOng.values()) {
            if(cod.equals(x.getDesc())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Desc inválida: " + cod);
    }

    public static String[] listDesc(){
        String [] todas = new String[7];
        int x = 0;
        for(AreaOng a: AreaOng.values()){
            todas[x] = a.desc;
            x++;
        }
        return todas;
    }
}
