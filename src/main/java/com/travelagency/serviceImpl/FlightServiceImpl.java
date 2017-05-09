package com.travelagency.serviceImpl;

import com.travelagency.entities.Airline;
import com.travelagency.entities.City;
import com.travelagency.entities.Flight;
import com.travelagency.entities.Hotel;
import com.travelagency.entities.enums.FlightCategory;
import com.travelagency.models.bindingModels.FlightDto;
import com.travelagency.models.viewModels.FlightDetailViewModel;
import com.travelagency.models.viewModels.FlightViewModel;
import com.travelagency.models.viewModels.HotelViewModel;
import com.travelagency.repositories.AirlineRepository;
import com.travelagency.repositories.CityRepository;
import com.travelagency.repositories.FlightRepository;
import com.travelagency.services.FlightService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void create(FlightDto flightDto) {
        Flight flight = this.modelMapper.map(flightDto, Flight.class);
        City originCity = this.cityRepository.findByName(flightDto.getOriginName());
        City destinationCity = this.cityRepository.findByName(flightDto.getDestinationName());
        Airline airline = this.airlineRepository.findByName(flightDto.getAirlineName());
        flight.setOrigin(originCity);
        flight.setDestination(destinationCity);
        flight.setAirline(airline);
        this.flightRepository.saveAndFlush(flight);
    }

    @Override
    public Page<FlightViewModel> findAll(Pageable pageable) {
        List<FlightViewModel> flightViewModels = new ArrayList<>();
        Page<Flight> flights = this.flightRepository.findAll(pageable);
        for (Flight flight : flights) {
            FlightViewModel flightViewModel = this.modelMapper.map(flight,FlightViewModel.class);
            flightViewModels.add(flightViewModel);
        }
        return new PageImpl<>(flightViewModels,pageable,flights.getTotalElements());
    }

    @Override
    public FlightDetailViewModel findById(long id) {
        Flight flight = this.flightRepository.findOne(id);
        return this.modelMapper.map(flight,FlightDetailViewModel.class);
    }
}
