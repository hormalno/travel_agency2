package com.travelagency.services;


import com.travelagency.models.bindingModels.BookingDto;
import com.travelagency.models.viewModels.BookingViewModel;

import java.util.List;

public interface BookingService {

    BookingViewModel create(BookingDto bookingDto);

    List<BookingViewModel> findAllByUsername(String name);
}
