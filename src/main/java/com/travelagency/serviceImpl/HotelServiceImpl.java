package com.travelagency.serviceImpl;

import com.travelagency.entities.City;
import com.travelagency.entities.Hotel;
import com.travelagency.models.bindingModels.HotelDto;
import com.travelagency.models.viewModels.HotelDetailViewModel;
import com.travelagency.models.viewModels.HotelViewModel;
import com.travelagency.repositories.CityRepository;
import com.travelagency.repositories.HotelRepository;
import com.travelagency.services.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository, ModelMapper modelMapper,CityRepository cityRepository) {
        this.hotelRepository = hotelRepository;
        this.modelMapper = modelMapper;
        this.cityRepository = cityRepository;
    }

    @Override
    public void create(HotelDto hotelDto) {
        Hotel hotel = this.modelMapper.map(hotelDto,Hotel.class);
        City city = this.cityRepository.findByName(hotelDto.getCityName());
        hotel.setCity(city);
        this.hotelRepository.saveAndFlush(hotel);
    }

    @Override
    public Page<HotelViewModel> findAll(Pageable pageable) {
       List<HotelViewModel> hotelViewModels = new ArrayList<>();
       Page<Hotel> hotels = this.hotelRepository.findAll(pageable);
        for (Hotel hotel : hotels) {
            HotelViewModel hotelViewModel = this.modelMapper.map(hotel,HotelViewModel.class);
            hotelViewModels.add(hotelViewModel);
        }
        return new PageImpl<>(hotelViewModels,pageable,hotels.getTotalElements());
    }

    @Override
    public List<HotelViewModel> findAll() {
        List<HotelViewModel> hotelViewModels = new ArrayList<>();
        List<Hotel> hotels = this.hotelRepository.findAll();
        for (Hotel hotel : hotels) {
            HotelViewModel hotelViewModel = this.modelMapper.map(hotel,HotelViewModel.class);
            hotelViewModels.add(hotelViewModel);
        }
        return hotelViewModels;
    }

   /* @Override
    public Page<HotelViewModel> findByCityName(String cityName,Pageable pageable) {
        List<HotelViewModel> hotelViewModels = new ArrayList<>();
        Page<Hotel> hotels = this.hotelRepository.findByCity_Name(cityName,pageable);
        for (Hotel hotel : hotels) {
            HotelViewModel hotelViewModel = this.modelMapper.map(hotel,HotelViewModel.class);
            hotelViewModels.add(hotelViewModel);
        }
        Page<HotelViewModel> hotelPages = new PageImpl<>(hotelViewModels,pageable,hotels.getTotalElements());
        return hotelPages;
    }

    @Override
    public Page<HotelViewModel> findByPriceRange(String priceStart, String priceEnd,Pageable pageable) {
        List<HotelViewModel> hotelViewModels = new ArrayList<>();
        double priceStartDouble = Double.parseDouble(priceStart);
        double priceEndDouble = Double.parseDouble(priceEnd);
        Page<Hotel> hotels = this.hotelRepository.findByPriceBetween(priceStartDouble,priceEndDouble,pageable);
        for (Hotel hotel : hotels) {
            HotelViewModel hotelViewModel = this.modelMapper.map(hotel, HotelViewModel.class);
            hotelViewModels.add(hotelViewModel);
        }
        Page<HotelViewModel> hotelPages = new PageImpl<>(hotelViewModels,pageable,hotels.getTotalElements());
        return hotelPages;
    }*/

    @Override
    public HotelDetailViewModel findById(long id) {
        Hotel hotel = this.hotelRepository.findOne(id);
        return this.modelMapper.map(hotel,HotelDetailViewModel.class);
    }


}
