package com.sedatsenli.galatasarayapp.model;

public class fikstur {
    private String takim, rakipTakim,hafta, saatvegun;

    public fikstur(String takim){

    }

    public String getTakim() {
        return takim;
    }

    public void setTakim(String takim) {
        this.takim = takim;
    }

    public String getRakipTakim() {
        return rakipTakim;
    }

    public void setRakipTakim(String rakipTakim) {
        this.rakipTakim = rakipTakim;
    }

    public String getSaatvegun() {
        return saatvegun;
    }

    public void setSaatvegun(String saatvegun) {
        this.saatvegun = saatvegun;
    }

    public String getHafta() {
        return hafta;
    }

    public void setHafta(String hafta) {
        this.hafta = hafta;
    }

    public fikstur(String takim, String rakipTakim, String hafta, String saatvegun){
        this.takim = takim;
        this.rakipTakim = rakipTakim;
        this.hafta = hafta;
        this.saatvegun = saatvegun;
    }

}
