package com.travelagency.services;

import com.travelagency.models.bindingModels.HotelDto;
import com.travelagency.models.viewModels.HotelDetailViewModel;
import com.travelagency.models.viewModels.HotelViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface HotelService {

    void create(HotelDto hotelDto);

    Page<HotelViewModel> findAll(Pageable pageable);

    List<HotelViewModel> findAll();

/*    Page<HotelViewModel> findByCityName(String cityName,Pageable pageable);

    Page<HotelViewModel> findByPriceRange(String priceStart, String priceEnd,Pageable pageable);*/

    HotelDetailViewModel findById(long id);

}
