package ru.gmgspb.betbot.network.entity;

/**
 * Created by DevKoi on 028 28.09.16.
 */
public class RobobetListModel {
    private int image;

    public void setText(String text) {
        this.text = text;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private String text;

    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }

    public RobobetListModel(int image, String text){
        this.image = image;
        this.text = text;
    }
}
