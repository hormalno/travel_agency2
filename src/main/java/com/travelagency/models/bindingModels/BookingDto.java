package com.travelagency.models.bindingModels;

import org.hibernate.validator.constraints.Range;


public class BookingDto {

    private long id;

    private String checkInDate;

    private String checkOutDate;

    @Range(min = 1,message = "Quantity must be minimum 1")
    private int quantity;

    private double cost;

    private String username;

    private long bookingProductId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getBookingProductId() {
        return bookingProductId;
    }

    public void setBookingProductId(long bookingProductId) {
        this.bookingProductId = bookingProductId;
    }
}
