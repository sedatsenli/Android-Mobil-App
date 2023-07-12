package com.sedatsenli.galatasarayapp.model;

public class haberlerModel {
    private String imageUrl;

    public haberlerModel() {

    }
    public haberlerModel(String imageUrl){

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
