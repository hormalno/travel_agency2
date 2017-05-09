package com.travelagency.entities;

import com.travelagency.entities.enums.CruiseCategory;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cruises")
public class Cruise extends BookingProduct{

    @ManyToOne
    @JoinColumn(name = "origin_city_id")
    private City origin;

    @ManyToMany
    @JoinTable(name = "cruises_destinations",
            joinColumns = @JoinColumn(name = "cruise_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id"))
    private Set<City> destinations;

    @Enumerated(EnumType.STRING)
    private CruiseCategory cruiseCategory;

    private String cruiseLine;

    private int duration;

    private String shipName;

    private String imageUrls;


    public Cruise() {
        this.destinations = new HashSet<>();
    }

    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public Set<City> getDestinations() {
        return destinations;
    }

    public void setDestinations(Set<City> destinations) {
        this.destinations = destinations;
    }

    public String getCruiseLine() {
        return cruiseLine;
    }

    public void setCruiseLine(String cruiseLine) {
        this.cruiseLine = cruiseLine;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    public CruiseCategory getCruiseCategory() {
        return cruiseCategory;
    }

    public void setCruiseCategory(CruiseCategory cruiseCategory) {
        this.cruiseCategory = cruiseCategory;
    }
}
