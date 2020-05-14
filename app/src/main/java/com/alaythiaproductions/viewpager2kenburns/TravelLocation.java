package com.alaythiaproductions.viewpager2kenburns;

public class TravelLocation {

    private String title, location, imageUrl;
    private Double starRating;

    public TravelLocation(String title, String location, String imageUrl, Double starRating) {
        this.title = title;
        this.location = location;
        this.imageUrl = imageUrl;
        this.starRating = starRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getStarRating() {
        return starRating;
    }

    public void setStarRating(Double starRating) {
        this.starRating = starRating;
    }
}
