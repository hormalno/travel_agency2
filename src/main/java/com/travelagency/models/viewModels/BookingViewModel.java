package com.travelagency.models.viewModels;

import java.util.Date;

public class BookingViewModel {

    private long id;

    private Date checkInDate;

    private Date checkOutDate;

    private int quantity;

    private double cost;

    private String bookingProductName;

    private double bookingProductPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
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

    public String getBookingProductName() {
        return bookingProductName;
    }

    public void setBookingProductName(String bookingProductName) {
        this.bookingProductName = bookingProductName;
    }

    public double getBookingProductPrice() {
        return bookingProductPrice;
    }

    public void setBookingProductPrice(double bookingProductPrice) {
        this.bookingProductPrice = bookingProductPrice;
    }
}
