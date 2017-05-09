package com.travelagency.controllers;

import com.travelagency.models.bindingModels.BookingDto;
import com.travelagency.models.viewModels.BookingProductViewModel;
import com.travelagency.models.viewModels.BookingViewModel;
import com.travelagency.services.BookingProductService;
import com.travelagency.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    private final BookingProductService bookingProductService;

    @Autowired
    public BookingController(BookingService bookingService, BookingProductService bookingProductService) {
        this.bookingService = bookingService;
        this.bookingProductService = bookingProductService;
    }

    @GetMapping("")
    public String getBookingPage(@ModelAttribute BookingDto bookingDto,@ModelAttribute("bookingProductId") long id, Model model){
        BookingProductViewModel bookingProductViewModel = this.bookingProductService.findById(id);
        model.addAttribute("product",bookingProductViewModel);
        model.addAttribute("view","booking/booking-page");
        return "base-layout";
    }

    @PostMapping("")
    public String bookProduct(@Valid @ModelAttribute BookingDto bookingDto, @AuthenticationPrincipal Principal principal,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("view","booking/booking-page");
            return "base-layout";
        }
        System.out.println(bookingDto.getBookingProductId());
        bookingDto.setUsername(principal.getName());
        BookingViewModel bookingViewModel = this.bookingService.create(bookingDto);
        redirectAttributes.addFlashAttribute("bookingViewModel",bookingViewModel);
        return "redirect:/booking/confirm";
    }

    @GetMapping("/confirm")
    public String getConfirmationPage(@ModelAttribute("bookingViewModel") BookingViewModel bookingViewModel,Model model){
        model.addAttribute("view","booking/booking-confirmation");
        return "base-layout";
    }
}
