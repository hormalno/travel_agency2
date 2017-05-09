package com.travelagency.models.bindingModels;

import com.travelagency.annotations.IsPasswordsMatching;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@IsPasswordsMatching
public class UserDto {

    @Size(min = 3, max = 10,message = "Username must be between 3 and 10 characters")
    private String username;

    @Size(min = 3, max = 10,message = "Password must be between 3 and 10 characters")
    //@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)[a-zA-Z\\\\d]{8,}$",message = "Password must be minimum 8 characters with one uppercase, one lowercase and a number")
    private String password;

    private String confirmPassword;

    @Size(min = 3, message = "Not valid email address")
    private String email;

    @Pattern(regexp = "^[A-Z][a-z]{2,}$",message = "Not a valid first name")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-z]{2,}$",message = "Not a valid last name")
    private String lastName;

    private String cityName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
