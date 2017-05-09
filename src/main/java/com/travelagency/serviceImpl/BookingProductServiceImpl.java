package com.travelagency.serviceImpl;

import com.travelagency.entities.BookingProduct;
import com.travelagency.models.viewModels.BookingProductViewModel;
import com.travelagency.repositories.BookingProductRepository;
import com.travelagency.services.BookingProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookingProductServiceImpl implements BookingProductService {

    private final BookingProductRepository bookingProductRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public BookingProductServiceImpl(ModelMapper modelMapper, BookingProductRepository bookingProductRepository) {
        this.modelMapper = modelMapper;
        this.bookingProductRepository = bookingProductRepository;
    }

    @Override
    public BookingProductViewModel findById(long id) {
        BookingProduct bookingProduct = this.bookingProductRepository.findOneById(id);
        return this.modelMapper.map(bookingProduct,BookingProductViewModel.class);
    }
}
