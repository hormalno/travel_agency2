package com.travelagency.entities;

import com.travelagency.entities.enums.FlightCategory;

import javax.persistence.*;

@Entity
@Table(name = "flights")
public class Flight extends BookingProduct{

    @ManyToOne
    @JoinColumn(name = "origin_city_id")
    private City origin;

    @ManyToOne
    @JoinColumn(name = "destination_city_id")
    private City destination;

    @Enumerated(EnumType.STRING)
    private FlightCategory flightCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airline_id")
    private Airline airline;

    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public FlightCategory getFlightCategory() {
        return flightCategory;
    }

    public void setFlightCategory(FlightCategory flightCategory) {
        this.flightCategory = flightCategory;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
