package com.example.instatry;

public class ArticleModel {

    String articlepicture;
    String description;
    String shortdesc;
    String title;


    public ArticleModel() {
    }

    @Override
    public String toString() {
        return "ArticleModel{" +
                "articlepicture='" + articlepicture + '\'' +
                ", description='" + description + '\'' +
                ", shortdesc='" + shortdesc + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getArticlepicture() {
        return articlepicture;
    }

    public void setArticlepicture(String articlepicture) {
        this.articlepicture = articlepicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
