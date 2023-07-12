package com.sedatsenli.galatasarayapp.model;

public class takimGorsel {

    private String imageUrl;

    public takimGorsel() {

    }
    public takimGorsel(String imageUrl){
        this.imageUrl = imageUrl;
    }
    public String getImageUrl() {

        return imageUrl;
    }
    public void setImageUrl(String imageUrl){

        this.imageUrl = imageUrl;
    }


    public void notifyDataSetChanged() {
    }
}
