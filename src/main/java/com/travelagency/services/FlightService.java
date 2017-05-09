package com.travelagency.services;

import com.travelagency.models.bindingModels.FlightDto;
import com.travelagency.models.viewModels.FlightDetailViewModel;
import com.travelagency.models.viewModels.FlightViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface FlightService {

    void create(FlightDto flightDto);

    Page<FlightViewModel> findAll(Pageable pageable);

    FlightDetailViewModel findById(long id);
}
