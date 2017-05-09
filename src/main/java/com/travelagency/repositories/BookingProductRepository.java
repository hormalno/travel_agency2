package com.travelagency.repositories;

import com.travelagency.entities.BookingProduct;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingProductRepository extends JpaRepository<BookingProduct,Long> {

    BookingProduct findOneById(Long id);

    BookingProduct findOneByName(String bookingProduct);
}
