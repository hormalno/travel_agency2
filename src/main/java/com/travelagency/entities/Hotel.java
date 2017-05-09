package com.travelagency.entities;

import com.travelagency.entities.enums.Facility;
import com.travelagency.entities.enums.HotelCategory;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "hotels")
public class Hotel extends BookingProduct {

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private String address;

    private int star;

    @Enumerated(EnumType.STRING)
    private HotelCategory hotelCategory;

    private String imageUrls;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<Facility> facilities;

    @ManyToMany(mappedBy = "hotels")
    private Set<Review> reviews;

    public Hotel() {
        this.facilities = new HashSet<>();
        this.reviews = new HashSet<>();
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public HotelCategory getHotelCategory() {
        return hotelCategory;
    }

    public void setHotelCategory(HotelCategory hotelCategory) {
        this.hotelCategory = hotelCategory;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
