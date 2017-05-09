package com.travelagency.models.viewModels;

import com.travelagency.entities.enums.HotelCategory;
import com.travelagency.entities.enums.Facility;
import com.travelagency.interfaces.Reviewable;
import java.util.Set;

public class HotelDetailViewModel implements Reviewable {

    private long id;

    private String name;

    private CityViewModel city;

    private String address;

    private int star;

    private double price;

    private String description;

    private String information;

    private String imageUrls;

    private HotelCategory hotelCategory;

    private Set<Facility> facilities;

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

    public CityViewModel getCity() {
        return city;
    }

    public void setCity(CityViewModel city) {
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

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    public HotelCategory getHotelCategory() {
        return hotelCategory;
    }

    public void setHotelCategory(HotelCategory hotelCategory) {
        this.hotelCategory = hotelCategory;
    }

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
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
