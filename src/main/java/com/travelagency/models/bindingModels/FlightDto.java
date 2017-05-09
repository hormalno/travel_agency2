package com.travelagency.models.bindingModels;


import com.travelagency.entities.enums.FlightCategory;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class FlightDto {

    private long id;

    @Pattern(regexp = "[A-z\\s]+",message = "Invalid name")
    private String name;

    @NotNull(message = "Invalid price")
    @Range(min=1,message = "Price must be minimum 1 $")
    private double price;

    @Size(max= 300, message = "Description must be less than 300 symbols")
    private String description;

    @NotBlank(message = "Invalid information")
    private String information;

    private FlightCategory flightCategory;

    @NotBlank(message = "Invalid")
    private String originName;

    @NotBlank(message = "Invalid")
    private String destinationName;

    @NotBlank(message = "Invalid")
    private String airlineName;

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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public FlightCategory getFlightCategory() {
        return flightCategory;
    }

    public void setFlightCategory(FlightCategory flightCategory) {
        this.flightCategory = flightCategory;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
}
