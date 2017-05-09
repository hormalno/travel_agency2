package com.travelagency.serviceImpl;

import com.travelagency.entities.Booking;
import com.travelagency.entities.BookingProduct;
import com.travelagency.entities.User;
import com.travelagency.models.bindingModels.BookingDto;
import com.travelagency.models.viewModels.BookingViewModel;
import com.travelagency.repositories.BookingProductRepository;
import com.travelagency.repositories.BookingRepository;
import com.travelagency.repositories.UserRepository;
import com.travelagency.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private final UserRepository userRepository;

    private final BookingProductRepository bookingProductRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, ModelMapper modelMapper, UserRepository userRepository,
                              BookingProductRepository bookingProductRepository) {
        this.bookingRepository = bookingRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.bookingProductRepository = bookingProductRepository;
    }

    @Override
    public BookingViewModel create(BookingDto bookingDto) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date checkInDate = null;
        Date checkOutDate = null;
        try {
            checkInDate = format.parse(bookingDto.getCheckInDate());
            checkOutDate = format.parse(bookingDto.getCheckOutDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Booking booking = new Booking();
        BookingProduct bookingProduct = this.bookingProductRepository.findOneById(bookingDto.getBookingProductId());
        if(bookingProduct.getName().contains("Hotel")){
            long milliseconds = checkOutDate.getTime() - checkInDate.getTime();
            long days = TimeUnit.DAYS.convert(milliseconds, TimeUnit.MILLISECONDS);
            booking.setCost(bookingDto.getQuantity()*days*bookingProduct.getPrice());
        } else {
            booking.setCost(bookingProduct.getPrice() * bookingDto.getQuantity());
        }
        booking.setBookingProduct(bookingProduct);
        booking.setCheckInDate(checkInDate);
        booking.setCheckOutDate(checkOutDate);
        booking.setQuantity(bookingDto.getQuantity());
        User user = this.userRepository.findOneByUsername(bookingDto.getUsername());
        booking.setUser(user);
        this.bookingRepository.saveAndFlush(booking);
        return this.modelMapper.map(booking,BookingViewModel.class);
    }

    @Override
    public List<BookingViewModel> findAllByUsername(String username) {
        List<BookingViewModel> bookingViewModels = new ArrayList<>();
        List<Booking> bookings = this.bookingRepository.findAllByUserUsername(username);
        for (Booking booking : bookings) {
            BookingViewModel bookingViewModel = this.modelMapper.map(booking,BookingViewModel.class);
            bookingViewModels.add(bookingViewModel);
        }
        return bookingViewModels;
    }
}
