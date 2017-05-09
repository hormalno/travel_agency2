package com.travelagency.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String country;

    @OneToMany
    private Set<Hotel> hotels;

    @OneToMany(mappedBy = "origin")
    private Set<Flight> flightsFrom;

    @OneToMany(mappedBy = "destination")
    private Set<Flight> flightsTo;

    @OneToMany
    private Set<Cruise> cruises;

    @ManyToMany
    private Set<Cruise> cruisesDestinations;

    public City() {
        this.hotels = new HashSet<>();
        this.flightsFrom = new HashSet<>();
        this.flightsTo = new HashSet<>();
        this.cruises = new HashSet<>();
        this.cruisesDestinations = new HashSet<>();
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Set<Flight> getFlightsFrom() {
        return flightsFrom;
    }

    public void setFlightsFrom(Set<Flight> flightsFrom) {
        this.flightsFrom = flightsFrom;
    }

    public Set<Flight> getFlightsTo() {
        return flightsTo;
    }

    public void setFlightsTo(Set<Flight> flightsTo) {
        this.flightsTo = flightsTo;
    }

    public Set<Cruise> getCruises() {
        return cruises;
    }

    public void setCruises(Set<Cruise> cruises) {
        this.cruises = cruises;
    }

    public Set<Cruise> getCruisesDestinations() {
        return cruisesDestinations;
    }

    public void setCruisesDestinations(Set<Cruise> cruisesDestinations) {
        this.cruisesDestinations = cruisesDestinations;
    }
}
