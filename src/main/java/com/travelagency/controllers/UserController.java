package com.travelagency.controllers;

import com.travelagency.config.Error;
import com.travelagency.models.bindingModels.UserDto;
import com.travelagency.models.viewModels.BookingViewModel;
import com.travelagency.models.viewModels.CityViewModel;
import com.travelagency.models.viewModels.ReviewByUserViewModel;
import com.travelagency.services.BookingService;
import com.travelagency.services.CityService;
import com.travelagency.services.ReviewService;
import com.travelagency.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final BookingService bookingService;

    private final ReviewService reviewService;

    private final UserService userService;

    private final CityService cityService;

    private final ModelMapper modelMapper;

    @Autowired
    public UserController(BookingService bookingService, ReviewService reviewService, UserService userService,
                          CityService cityService, ModelMapper modelMapper) {
        this.bookingService = bookingService;
        this.reviewService = reviewService;
        this.userService = userService;
        this.cityService = cityService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("cityNames")
    public List<String> getCities(){
        List<CityViewModel> cities = this.cityService.findAll();
        List<String> cityNames = new ArrayList<>();
        for (CityViewModel city : cities) {
            cityNames.add(city.getName());
        }
        return cityNames;
    }

    @GetMapping("/register")
    public String getRegisterPage(@ModelAttribute UserDto userDto){

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register";
        }

        this.userService.create(userDto);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(required = false) String error, Model model){
        if(error != null){
            model.addAttribute("error", Error.INVALID_CREDENTIALS);
        }

        return "login";
    }

    @GetMapping("/user/bookings")
    public String getUserBookings(Model model, @AuthenticationPrincipal Principal principal){
        List<BookingViewModel> bookingViewModels = this.bookingService.findAllByUsername(principal.getName());
        model.addAttribute("bookings",bookingViewModels);
        model.addAttribute("view","user/user-bookings");
        return "base-layout";
    }

    @GetMapping("/user/reviews")
    public String getUserReviews(Model model, @AuthenticationPrincipal Principal principal){
        List<ReviewByUserViewModel> reviews = this.reviewService.findAllByUsername(principal.getName());
        model.addAttribute("reviews",reviews);
        model.addAttribute("view","user/user-reviews");
        return "base-layout";
    }

}
