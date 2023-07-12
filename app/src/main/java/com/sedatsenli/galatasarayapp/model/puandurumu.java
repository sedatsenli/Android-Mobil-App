package com.sedatsenli.galatasarayapp.model;

public class puandurumu {
    private String takimAdi, oynananMac, galibiyet, beraberlik, maglubiyet, atilanGol, yenilenGol, averaj, puan;

    public puandurumu(String takimAdi){

    }

    public String getTakimAdi() {
        return takimAdi;
    }

    public void setTakimAdi(String takimAdi) {
        this.takimAdi = takimAdi;
    }

    public puandurumu( String takimAdi, String oynananMac, String galibiyet, String beraberlik, String maglubiyet, String atilanGol, String yenilenGol, String averaj, String puan){
        this.takimAdi = takimAdi;
        this.oynananMac = oynananMac;
        this.galibiyet = galibiyet;
        this.beraberlik = beraberlik;
        this.maglubiyet = maglubiyet;
        this.atilanGol = atilanGol;
        this.yenilenGol = yenilenGol;
        this.averaj = averaj;
        this.puan = puan;

    }

    public String getOynananMac() {
        return oynananMac;
    }

    public void setOynananMac(String oynananMac) {
        this.oynananMac = oynananMac;
    }

    public String getGalibiyet() {
        return galibiyet;
    }

    public void setGalibiyet(String galibiyet) {
        this.galibiyet = galibiyet;
    }

    public String getBeraberlik() {
        return beraberlik;
    }

    public void setBeraberlik(String beraberlik) {
        this.beraberlik = beraberlik;
    }

    public String getMaglubiyet() {
        return maglubiyet;
    }

    public void setMaglubiyet(String maglubiyet) {
        this.maglubiyet = maglubiyet;
    }

    public String getAtilanGol() {
        return atilanGol;
    }

    public void setAtilanGol(String atilanGol) {
        this.atilanGol = atilanGol;
    }

    public String getYenilenGol() {
        return yenilenGol;
    }

    public void setYenilenGol(String yenilenGol) {
        this.yenilenGol = yenilenGol;
    }

    public String getAveraj() {
        return averaj;
    }

    public void setAveraj(String averaj) {
        this.averaj = averaj;
    }

    public String getPuan() {
        return puan;
    }

    public void setPuan(String puan) {
        this.puan = puan;
    }
}
