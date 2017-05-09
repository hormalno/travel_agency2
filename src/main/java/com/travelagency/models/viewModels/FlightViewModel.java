package com.travelagency.models.viewModels;


import com.travelagency.interfaces.Reviewable;

import java.util.Set;

public class FlightViewModel implements Reviewable {

    private long id;

    private String name;

    private double price;

    private String description;

    private CityViewModel origin;

    private CityViewModel destination;

    private AirlineViewModel airline;

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

    public CityViewModel getOrigin() {
        return origin;
    }

    public void setOrigin(CityViewModel origin) {
        this.origin = origin;
    }

    public CityViewModel getDestination() {
        return destination;
    }

    public void setDestination(CityViewModel destination) {
        this.destination = destination;
    }

    public AirlineViewModel getAirline() {
        return airline;
    }

    public void setAirline(AirlineViewModel airline) {
        this.airline = airline;
    }

    @Override
    public Set<ReviewViewModel> getReviews() {
        return reviews;
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
