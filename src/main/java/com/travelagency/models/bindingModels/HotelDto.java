package com.travelagency.models.bindingModels;


import com.travelagency.entities.enums.HotelCategory;
import com.travelagency.entities.enums.Facility;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class HotelDto {

    private long id;

    @Pattern(regexp = "Hotel [A-Z][A-z\\s]+",message = "Invalid name")
    private String name;

    private String cityName;

    @Pattern(regexp = "[A-z0-9\\s]+",message = "Invalid address")
    private String address;

    @Range(min = 1,max = 5,message = "Must be between 1 and 5")
    private int star;

    private HotelCategory hotelCategory;

    @NotNull(message = "Price cannot be null")
    @Range(min=1,message = "Invalid price")
    private double price;

    @NotBlank(message = "Invalid input")
    @Size(max = 300,message = "Description too long")
    private String description;

    @NotBlank(message = "Invalid input")
    private String information;

    private String imageUrls;

    private Set<Facility> facilities;

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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }
}
