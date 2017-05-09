package com.travelagency.services;


import com.travelagency.models.viewModels.BookingProductViewModel;

public interface BookingProductService {

    BookingProductViewModel findById(long id);
}
