package com.travelagency.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BookingProduct {

    @TableGenerator(table = "product_generator", name = "productIdGen")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "productIdGen")
    private long id;

    private String name;

    private double price;

    private String description;

    @Column(columnDefinition = "TEXT")
    private String information;

    @OneToMany(mappedBy = "bookingProduct")
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "bookingProduct")
    private Set<Review> reviews;

    public BookingProduct() {
        this.bookings = new HashSet<>();
        this.reviews = new HashSet<>();
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

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
