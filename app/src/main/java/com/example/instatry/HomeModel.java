package com.example.instatry;

public class HomeModel {

    String description;
    String latitude;
    String longitude;
    String placepicture;
    String title;

    @Override
    public String toString() {
        return "HomeModel{" +
                "description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", placepicture='" + placepicture + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public HomeModel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPlacepicture() {
        return placepicture;
    }

    public void setPlacepicture(String placepicture) {
        this.placepicture = placepicture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
