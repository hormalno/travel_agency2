package com.travelagency.controllers;

import com.travelagency.entities.Flight;
import com.travelagency.entities.Review;
import com.travelagency.entities.enums.FlightCategory;
import com.travelagency.models.bindingModels.BookingDto;
import com.travelagency.models.bindingModels.FlightDto;
import com.travelagency.models.viewModels.AirlineViewModel;
import com.travelagency.models.viewModels.CityViewModel;
import com.travelagency.models.viewModels.FlightDetailViewModel;
import com.travelagency.models.viewModels.FlightViewModel;
import com.travelagency.services.AirlineService;
import com.travelagency.services.CityService;
import com.travelagency.services.FlightService;
import com.travelagency.utilities.ReviewScore;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FlightController {

    private final FlightService flightService;

    private final CityService cityService;

    private final AirlineService airlineService;

    private final ModelMapper modelMapper;

    @Autowired
    public FlightController(FlightService flightService, CityService cityService, AirlineService airlineService,
                            ModelMapper modelMapper) {
        this.flightService = flightService;
        this.cityService = cityService;
        this.airlineService = airlineService;
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

    @ModelAttribute("airlines")
    public List<AirlineViewModel> getAirlines(){
       return this.airlineService.findAll();
    }

    @ModelAttribute("categories")
    public FlightCategory[] getCategories(){
        return FlightCategory.values();
    }

    @GetMapping("/flights")
    public String getFlightPage(Model model, @PageableDefault(size = 8) Pageable pageable){
        Page<FlightViewModel> flightViewModels = this.flightService.findAll(pageable);
        for (FlightViewModel flightViewModel : flightViewModels) {
            flightViewModel.setScore(ReviewScore.set(flightViewModel));
        }
        model.addAttribute("flightMenu",true);
        model.addAttribute("flights",flightViewModels);
        model.addAttribute("view","flights/flights-page");
        return "base-layout";
    }

    @GetMapping("/flights/{id}")
    public String getDetailFlight(@PathVariable long id, @ModelAttribute BookingDto bookingDto, Model model){
        FlightDetailViewModel flight = this.flightService.findById(id);
        flight.setScore(ReviewScore.set(flight));
        model.addAttribute("flight",flight);
        model.addAttribute("view","flights/flight-detail");
        return "base-layout";
    }

    @PostMapping("/flights/{id}")
    public String goToBookingPage(@PathVariable long id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("bookingProductId",id);
        return "redirect:/booking";
    }

    @GetMapping("/admin/flights/add")
    public String getAddFlightPage(@ModelAttribute FlightDto flightDto, Model model){
        model.addAttribute("view","flights/add-flight");
        model.addAttribute("action","Add");
        return "base-layout";
    }

    @PostMapping("/admin/flights/add")
    public String addFlight(@Valid @ModelAttribute FlightDto flightDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("view","flights/add-flight");
            model.addAttribute("action","Add");
            return "base-layout";
        }
        this.flightService.create(flightDto);
        return "redirect:/flights";
    }

    @GetMapping("/admin/flights/edit/{id}")
    public String getEditFlightPage(@PathVariable long id, @ModelAttribute FlightDto flightDto, Model model){
        FlightDetailViewModel flightDetailViewModel = this.flightService.findById(id);
        this.modelMapper.map(flightDetailViewModel,flightDto);
        model.addAttribute("view","flights/add-flight");
        model.addAttribute("action","Edit");
        return "base-layout";
    }

    @PostMapping("/admin/flights/edit/{id}")
    public String editFlight( @Valid @ModelAttribute FlightDto flightDto, BindingResult bindingResult,
                             Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("view","flights/add-flight");
            model.addAttribute("action","Edit");
            return "base-layout";
        }
        this.flightService.create(flightDto);
        return "redirect:/flights/" + flightDto.getId();
    }
}
