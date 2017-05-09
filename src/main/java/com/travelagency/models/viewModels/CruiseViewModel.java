package com.travelagency.models.viewModels;


import com.travelagency.entities.City;
import com.travelagency.interfaces.Reviewable;

import java.util.Set;

public class CruiseViewModel implements Reviewable{

    private long id;

    private String name;

    private double price;

    private String description;

    private String originName;

    private Set<CityViewModel> destinations;

    private int duration;

    private Set<ReviewViewModel> reviews;

    private int score;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public Set<CityViewModel> getDestinations() {
        return destinations;
    }

    public void setDestinations(Set<CityViewModel> destinations) {
        this.destinations = destinations;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public Set<ReviewViewModel> getReviews() {
        return this.reviews;
    }

    public void setReviews(Set<ReviewViewModel> reviews) {
        this.reviews = reviews;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
